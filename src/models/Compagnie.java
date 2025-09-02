package models;

public class Compagnie {
    private Long id;
    private String nom;
    private String adresse;
    private String contact;

    public Compagnie() {
    }

    public Compagnie(Long id, String nom, String adresse, String contact) throws Exception {
        this.setId(id);
        this.setNom(nom);
        this.setAdresse(adresse);
        this.setContact(contact);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) throws Exception {
        if (id == null || id <= 0) throw new Exception("L'ID doit être un entier positif non nul.");
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws Exception {
        if (nom == null || nom.trim().isEmpty()) throw new Exception("Le nom de la compagnie ne peut pas être vide.");
        this.nom = nom.trim();
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) throws Exception {
        if (adresse == null || adresse.trim().isEmpty()) throw new Exception("L'adresse ne peut pas être vide.");
        this.adresse = adresse.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) throws Exception {
        if (contact == null || contact.trim().isEmpty()) throw new Exception("Le contact ne peut pas être vide.");
        if (contact.length() < 5) throw new Exception("Le contact est trop court.");
        this.contact = contact.trim();
    }
}
