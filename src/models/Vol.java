package models;

import java.time.LocalDateTime;

public class Vol {
    private Long id;
    private String identification;
    private LocalDateTime dateHeureDepart;
    private Avion avion;

    public Vol() {
    }

    public Vol(Long id, String identification, LocalDateTime dateHeureDepart, Avion avion) throws Exception {
        this.setId(id);
        this.setIdentification(identification);
        this.setDateHeureDepart(dateHeureDepart);
        this.setAvion(avion);
    }

    public Long getId() {
        return id;
    }   

    public void setId(Long id) throws Exception {
        if (id == null || id <= 0) throw new Exception("L'ID doit être un entier positif non nul.");
        this.id = id;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) throws Exception {
        if (identification == null || identification.trim().isEmpty())
            throw new Exception("L'identification du vol ne peut pas être vide.");
        this.identification = identification.trim();
    }

    public LocalDateTime getDateHeureDepart() {
        return dateHeureDepart;
    }

    public void setDateHeureDepart(LocalDateTime dateHeureDepart) throws Exception {
        if (dateHeureDepart == null || dateHeureDepart.isBefore(LocalDateTime.now()))
            throw new Exception("La date et l'heure de départ doivent être dans le futur.");
        this.dateHeureDepart = dateHeureDepart;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) throws Exception {
        if (avion == null) throw new Exception("L'avion associé au vol ne peut pas être nul.");
        this.avion = avion;
    }
}
