package services;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import models.Promotion;
import utils.DBConnect;

public class PromotionService {
    public Promotion getUpcomingPromotion(long idClasse, long idVol, Date date) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Promotion promotion = null;

        try {
            String sql = "SELECT * FROM Promotion WHERE idClasse = ? AND idVol = ? AND dateFin >= ? ORDER BY dateFin ASC LIMIT 1";
            preparedStatement = DBConnect.getConnection().prepareStatement(sql);
            preparedStatement.setLong(1, idClasse);
            preparedStatement.setLong(2, idVol);
            preparedStatement.setDate(3, date);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                promotion = toPromotion(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return promotion;
    }

    public List<Promotion> getPromotionByClasseAndVol(long idClasse, long idVol) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Promotion> promotions = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Promotion WHERE idClasse = ? AND idVol = ?";
            preparedStatement = DBConnect.getConnection().prepareStatement(sql);
            preparedStatement.setLong(1, idClasse);
            preparedStatement.setLong(2, idVol);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                promotions.add(toPromotion(resultSet));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return promotions;
    }

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

    public Promotion toPromotion(ResultSet resultSet) {
        Promotion promotion = new Promotion();
        try {
            promotion.setId(resultSet.getLong("id"));
            promotion.setNbreSiege(resultSet.getInt("nbreSiege"));
            promotion.setPrix(resultSet.getDouble("prix"));
            promotion.setDateFin(resultSet.getDate("dateFin"));
            promotion.setClasse(new ClasseService().getClasseById(resultSet.getLong("idClasse")));
            promotion.setVol(new VolService().getVolById(resultSet.getLong("idVol")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return promotion;
    }
}
