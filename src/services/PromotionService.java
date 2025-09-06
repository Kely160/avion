package services;

import java.sql.PreparedStatement;

import models.Promotion;
import utils.DBConnect;

public class PromotionService {
    public void savePromotion(Promotion promotion) {
        PreparedStatement preparedStatement = null;

        try {
            String sql = "INSERT INTO Promotion (nbreSiege, prix, dateFin, idClasse, idVol) VALUES (?, ?, ?, ?, ?)";
            preparedStatement = DBConnect.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, promotion.getNbreSiege());
            preparedStatement.setDouble(2, promotion.getPrix());
            preparedStatement.setDate(3, new java.sql.Date(promotion.getDateFin().getTime()));
            preparedStatement.setLong(4, promotion.getClasse().getId());
            preparedStatement.setLong(5, promotion.getVol().getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
