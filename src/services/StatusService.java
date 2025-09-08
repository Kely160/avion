package services;

import java.sql.PreparedStatement;

import models.Status;

public class StatusService {
    public Status getStatusByNom(String nom) throws Exception {
        PreparedStatement ps = null;
        java.sql.ResultSet rs = null;   
        Status status = null;
        try (java.sql.Connection connection = utils.DBConnect.getConnection()) {
            ps = connection.prepareStatement("SELECT * FROM Status WHERE nom = ?");
            ps.setString(1, nom);
            rs = ps.executeQuery();
            if (rs.next()) {
                status = new Status();
                status.setId(rs.getLong("id"));
                status.setNom(rs.getString("nom"));
            } else {
                throw new Exception("Status non trouvé");
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        }
        return status;
    }

    public Status getStatusById(Long id) throws Exception {
        PreparedStatement ps = null;
        java.sql.ResultSet rs = null;   
        Status status = null;
        try (java.sql.Connection connection = utils.DBConnect.getConnection()) {
            ps = connection.prepareStatement("SELECT * FROM Status WHERE id = ?");
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                status = new Status();
                status.setId(rs.getLong("id"));
                status.setNom(rs.getString("nom"));
            } else {
                throw new Exception("Status non trouvé");
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        }
        return status;
    }
}
