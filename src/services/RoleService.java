package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import models.Role;
import utils.DBConnect;

public class RoleService {
    public Role findById(Long id) throws Exception {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Role role = null;

        try (Connection connection = DBConnect.getConnection()) {
            preparedStatement = connection.prepareStatement("SELECT * FROM Role WHERE id = ?");
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                role = new Role();
                role = toRole(resultSet);
            }
        } catch (Exception e) {
            throw e; 
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace(); 
            }
        }

        return role;
    }

    public Role toRole(ResultSet resultSet) throws Exception {
        Role role = new Role();
        role.setId(resultSet.getLong("id"));
        role.setNom(resultSet.getString("nom"));

        return role;
    }
}
