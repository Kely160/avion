package models;

import java.sql.Date;

public class Promotion {
    private Long id;
    private int nbreSiege;
    private double prix;
    private Date dateFin;
    private Classe classe;
    private Vol vol;

    public Promotion() {
    }

    public Promotion(Long id, int nbreSiege, double prix, Date dateFin) throws Exception {
        this.setId(id);
        this.setNbreSiege(nbreSiege);
        this.setPrix(prix);
        this.setDateFin(dateFin);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNbreSiege() {
        return nbreSiege;
    }

    public void setNbreSiege(int nbreSiege) throws Exception {
        if (nbreSiege < 0) {
            throw new Exception("Le nombre de sièges ne peut pas être négatif.");
        }
        this.nbreSiege = nbreSiege;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) throws Exception {
        if (prix < 0) {
            throw new Exception("Le prix ne peut pas être négatif.");
        }
        this.prix = prix;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Vol getVol() {
        return vol;
    }

    public void setVol(Vol vol) {
        this.vol = vol;
    }
}
