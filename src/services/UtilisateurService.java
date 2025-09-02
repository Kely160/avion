package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import models.Role;
import models.Utilisateur;
import util.CustomSession;
import utils.DBConnect;

public class UtilisateurService {
    public Role login(CustomSession customSession, String email, String mdp) throws Exception {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try(Connection connection = DBConnect.getConnection()) {
            preparedStatement = connection.prepareStatement("SELECT * FROM Utilisateur WHERE email = ?");
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Utilisateur utilisateur = new Utilisateur();
                utilisateur = this.toUtilisateur(resultSet);

                if (utilisateur.getMdp().equals(mdp)) {
                    customSession.add("id", utilisateur.getId());
                    customSession.add("nomUtilisateur", utilisateur.getNom());
                    return new RoleService().findById(utilisateur.getIdRole());
                } else {
                    throw new Exception("Mot de passe incorrect");
                }
            } else {
                throw new Exception("Utilisateur non trouvé");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Erreur lors de la tentative de connexion : " + e.getMessage(), e);
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Utilisateur toUtilisateur(ResultSet resultSet) throws Exception {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(resultSet.getLong("id"));
        utilisateur.setNom(resultSet.getString("nom"));
        utilisateur.setEmail(resultSet.getString("email"));
        utilisateur.setMdp(resultSet.getString("mdp"));
        utilisateur.setIdRole(resultSet.getLong("idRole"));

        return utilisateur;
    }
}
