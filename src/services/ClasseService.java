package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import models.Classe;
import utils.DBConnect;

public class ClasseService {
    public Classe getClasseById(Long id) throws Exception {
        Classe classe = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try (Connection connection = DBConnect.getConnection()) {
            preparedStatement = connection.prepareStatement("SELECT * FROM Classe WHERE id = ?");
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                classe = toClasse(resultSet);
            } else {
                throw new Exception("Aucune classe trouvé avec l'ID : " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Erreur lors de la récupération de la classe : " + e.getMessage(), e);
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return classe;
    }

    public List<Classe> getAllClasses() throws Exception {
        List<Classe> classes = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try (Connection connection = DBConnect.getConnection()) {
            preparedStatement = connection.prepareStatement("SELECT * FROM Classe");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Classe classe = toClasse(resultSet);
                classes.add(classe);
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

        return classes;
    }

    public Classe toClasse(ResultSet resultSet) throws Exception {
        Classe classe = new Classe();
        classe.setId(resultSet.getLong("id"));
        classe.setNom(resultSet.getString("nom"));

        return classe;
    }
}
