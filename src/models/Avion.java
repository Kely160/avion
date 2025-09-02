package models;

public class Avion {
    private Long id;
    private String nom;
    private Compagnie compagnie;

    public Avion() {
    }

    public Avion(Long id, String nom, Compagnie compagnie) throws Exception {
        this.setId(id);
        this.setNom(nom);
        this.setCompagnie(compagnie);
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
        if (nom == null || nom.trim().isEmpty()) throw new Exception("Le nom de l'avion ne peut pas être vide.");
        this.nom = nom.trim();
    }

    public Compagnie getCompagnie() {
        return compagnie;
    }

    public void setCompagnie(Compagnie compagnie) {
        this.compagnie = compagnie;
    }
}
