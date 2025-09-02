package models;

import utils.Regexp;

public class Utilisateur {
    private Long id;
    private String nom;
    private String email;
    private String mdp;
    private Long idRole;
    
    public Utilisateur() {
    }

    public Utilisateur(Long id, String nom, String email, String mdp, Long idRole) throws Exception {
        this.setId(id);
        this.setNom(nom);
        this.setEmail(email);
        this.setMdp(mdp);
        this.setIdRole(idRole);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws Exception {
        if (nom == null || nom.trim().isEmpty()) throw new Exception("Le nom ne peut pas être vide.");
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        if (!Regexp.isValidEmail(email)) throw new Exception("L'email n'est pas valide.");
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) throws Exception {
        if (mdp == null || mdp.trim().isEmpty()) throw new Exception("Le mot de passe ne peut pas être vide.");
        this.mdp = mdp;
    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }
}
