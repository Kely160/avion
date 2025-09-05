package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

import models.Vol;
import utils.DBConnect;

public class VolService {
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
}
