package services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import models.Reservation;
import utils.DBConnect;

public class ReservationService {

    public void annulerReservation(Long idReservation) throws Exception {
        updateStatus(idReservation, new StatusService().getStatusByNom("Annulé").getId()); 
    }
    
    public void payerReservation(Long idReservation) throws Exception {
        updateStatus(idReservation, new StatusService().getStatusByNom("Payé").getId()); 
    }

    public void updateStatus(Long idReservation, Long idStatus) throws Exception {
        PreparedStatement ps = null;
        try (Connection connection = DBConnect.getConnection()) {
            ps = connection.prepareStatement("UPDATE Reservation SET idStatus = ? WHERE id = ?");
            ps.setLong(1, idStatus);
            ps.setLong(2, idReservation);
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated == 0) {
                throw new Exception("Aucune réservation trouvée avec l'ID spécifié");
            }
        } finally {
            if (ps != null) ps.close();
        }
    }

    public int getCapacityForVolAndClasse(Long idVol, Long idClasse) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try (Connection connection = DBConnect.getConnection()) {
            ps = connection.prepareStatement(
                "SELECT n.nbre FROM NbreSiegeAvion n JOIN Vol v ON v.idAvion = n.idAvion WHERE v.id = ? AND n.idClasse = ?"
            );
            ps.setLong(1, idVol);
            ps.setLong(2, idClasse);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("nbre");
            }
            throw new Exception("Capacité introuvable pour ce vol et cette classe");
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        }
    }

    public int countReservationsForVolAndClasse(Long idVol, Long idClasse) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try (Connection connection = DBConnect.getConnection()) {
            ps = connection.prepareStatement(
                "SELECT COUNT(*) AS total FROM Reservation WHERE idVol = ? AND idClasse = ?"
            );
            ps.setLong(1, idVol);
            ps.setLong(2, idClasse);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("total");
            }
            return 0;
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        }
    }

    public void createReservation(Long idUtilisateur, Long idVol, Long idClasse, Date date) throws Exception {
        int capacity = getCapacityForVolAndClasse(idVol, idClasse);
        int reserved = countReservationsForVolAndClasse(idVol, idClasse);
        if (reserved >= capacity) {
            throw new Exception("Plus de sièges disponibles pour cette classe");
        }

        PreparedStatement ps = null;
        try (Connection connection = DBConnect.getConnection()) {
            ps = connection.prepareStatement(
                "INSERT INTO Reservation (dateReservation, idStatus, idUtilisateur, idClasse, idVol, idPromotion) VALUES (?, ?, ?, ?, ?, ?)"
            );
            ps.setDate(1, date);
            ps.setLong(2, 1L); // 1 = réservé (par défaut)
            ps.setLong(3, idUtilisateur);
            ps.setLong(4, idClasse);
            ps.setLong(5, idVol);
            ps.setLong(6, new PromotionService().getUpcomingPromotion(idClasse, idVol, date).getId());
            ps.executeUpdate();
        } finally {
            if (ps != null) ps.close();
        }
    }

    public List<Reservation> listReservationsByUser(Long idUtilisateur) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Reservation> reservations = new ArrayList<>();
        try (Connection connection = DBConnect.getConnection()) {
            ps = connection.prepareStatement(
                "SELECT * FROM Reservation WHERE idUtilisateur = ? ORDER BY dateReservation DESC"
            );
            ps.setLong(1, idUtilisateur);
            rs = ps.executeQuery();
            while (rs.next()) {
                Reservation r = new Reservation();
                r.setId(rs.getLong("id"));
                r.setDateReservation(rs.getTimestamp("dateReservation").toLocalDateTime());
                r.setIdStatus(rs.getLong("idStatus"));
                r.setIdUtilisateur(rs.getLong("idUtilisateur"));
                r.setIdClasse(rs.getLong("idClasse"));
                r.setIdVol(rs.getLong("idVol"));
                reservations.add(r);
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        }
        return reservations;
    }
}


