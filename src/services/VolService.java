package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import models.Vol;
import utils.DBConnect;

public class VolService {
    public Vol getVolById(Long id) throws Exception {
        Vol vol = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try (Connection connection = DBConnect.getConnection()) {
            preparedStatement = connection.prepareStatement("SELECT * FROM Vol WHERE id = ?");
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                vol = toVol(resultSet);
            } else {
                throw new Exception("Aucun vol trouvé avec l'ID : " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Erreur lors de la récupération du vol : " + e.getMessage(), e);
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return vol;
    }

    public void saveVol(Vol vol) throws Exception{
        PreparedStatement preparedStatement = null;

        try (Connection connection = DBConnect.getConnection()) {
            preparedStatement = connection.prepareStatement(
                "INSERT INTO Vol (identification, dateHeureDepart, idAvion) VALUES (?, ?, ?)"
            );
            preparedStatement.setString(1, vol.getIdentification());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(vol.getDateHeureDepart()));
            preparedStatement.setLong(3, vol.getAvion().getId());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 0) {
                throw new Exception("Échec de l'insertion de la vol.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Erreur lors de l'insertion de la vol : " + e.getMessage(), e);
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Vol> getAllVols() throws Exception {
        List<Vol> vols = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try (Connection connection = DBConnect.getConnection()) {
            preparedStatement = connection.prepareStatement("SELECT * FROM Vol");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Vol vol = new Vol();
                vol.setId(resultSet.getLong("id"));
                vol.setIdentification(resultSet.getString("identification"));
                vol.setDateHeureDepart(resultSet.getTimestamp("dateHeureDepart").toLocalDateTime());
                vols.add(vol);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Erreur lors de la récupération des vols : " + e.getMessage(), e);
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return vols;
    }

    public Vol toVol(ResultSet resultSet) throws Exception {
        Vol vol = new Vol();
        vol.setId(resultSet.getLong("id"));
        vol.setIdentification(resultSet.getString("identification"));
        vol.setDateHeureDepart(resultSet.getTimestamp("dateHeureDepart").toLocalDateTime());
        vol.setAvion(new AvionService().getAvionById(resultSet.getLong("idAvion")));
        return vol;
    }
}
