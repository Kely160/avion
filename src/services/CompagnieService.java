package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import models.Compagnie;
import utils.DBConnect;

public class CompagnieService {

    public List<Compagnie> getAllCompagnies() throws Exception {
        List<Compagnie> compagnies = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try (Connection connection = DBConnect.getConnection()) {
            preparedStatement = connection.prepareStatement("SELECT * FROM Compagnie");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Compagnie compagnie = toCompagnie(resultSet);
                compagnies.add(compagnie);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Erreur lors de la récupération des compagnies : " + e.getMessage(), e);
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return compagnies;
    }

    public void saveCompagnie(Compagnie compagnie) throws Exception {
        PreparedStatement preparedStatement = null;

        try (Connection connection = DBConnect.getConnection()) {
            preparedStatement = connection.prepareStatement(
                "INSERT INTO Compagnie (nom, adresse, contact) VALUES (?, ?, ?)"
            );
            preparedStatement.setString(1, compagnie.getNom());
            preparedStatement.setString(2, compagnie.getAdresse());
            preparedStatement.setString(3, compagnie.getContact());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 0) {
                throw new Exception("Échec de l'insertion de la compagnie.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Erreur lors de l'insertion de la compagnie : " + e.getMessage(), e);
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Compagnie toCompagnie(ResultSet resultSet) throws Exception {
        Compagnie compagnie = new Compagnie();
        compagnie.setId(resultSet.getLong("id"));
        compagnie.setNom(resultSet.getString("nom"));
        compagnie.setAdresse(resultSet.getString("adresse"));
        compagnie.setContact(resultSet.getString("contact"));
        return compagnie;
    }
}
