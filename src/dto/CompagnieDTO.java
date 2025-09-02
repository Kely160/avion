package dto;

import annotation.FieldAnnotation;

public class CompagnieDTO {
    @FieldAnnotation(name = "nom")
    String nom;
    
    @FieldAnnotation(name = "adresse")
    String adresse;

    @FieldAnnotation(name = "contact")
    String contact;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

}
