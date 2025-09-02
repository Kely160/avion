package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import models.Avion;
import models.Compagnie;
import utils.DBConnect;

public class AvionService {
    public List<Avion> getAllAvions() throws Exception {
        List<Avion> avions = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try (Connection connection = DBConnect.getConnection()) {
            preparedStatement = connection.prepareStatement("SELECT * FROM Avion");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Avion avion = toAvion(resultSet);
                avions.add(avion);
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

        return avions;
    }

    public Avion toAvion(ResultSet resultSet) throws Exception {
        Avion avion = new Avion();
        avion.setId(resultSet.getLong("id"));
        avion.setNom(resultSet.getString("nom"));
        int idCompagnie = resultSet.getInt("idCompagnie");
        if (idCompagnie > 0) {
            CompagnieService compagnieService = new CompagnieService();
            Compagnie compagnie = compagnieService.getCompagnieById(idCompagnie);
            avion.setCompagnie(compagnie);
        }

        return avion;
    }
}
