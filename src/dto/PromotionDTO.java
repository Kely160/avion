package dto;

import annotation.FieldAnnotation;

public class PromotionDTO {
    @FieldAnnotation(name = "prix")
    private double prix;

    @FieldAnnotation(name = "nbreSiege")
    private int nbreSiege; 

    @FieldAnnotation(name = "idClasse")
    private Long idClasse;

    @FieldAnnotation(name = "idVol")
    private Long idVol;

    @FieldAnnotation(name = "dateFin")
    private String dateFin;

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getNbreSiege() {
        return nbreSiege;
    }

    public void setNbreSiege(int nbreSiege) {
        this.nbreSiege = nbreSiege;
    }

    public Long getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Long idClasse) {
        this.idClasse = idClasse;
    }

    public Long getIdVol() {
        return idVol;
    }

    public void setIdVol(Long idVol) {
        this.idVol = idVol;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }
}
