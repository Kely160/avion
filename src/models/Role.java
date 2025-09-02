package models;

public class Role {
    private Long id;
    private String nom;

    public Role() {}

    public Role(Long id, String nom) throws Exception {
        this.setId(id);
        this.setNom(nom);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) throws Exception {
        if (nom == null || nom.trim().isEmpty()) throw new Exception("Le nom ne doit pas être vide");
        this.nom = nom;
    }
}
