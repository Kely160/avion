package models;

import java.time.LocalDateTime;

import services.ClasseService;
import services.StatusService;
import services.VolService;

public class Reservation {
    private Long id;
    private LocalDateTime dateReservation;
    private Long idStatus;
    private Long idUtilisateur;
    private Long idClasse;
    private Long idVol;
    private Long idPromotion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(LocalDateTime dateReservation) {
        this.dateReservation = dateReservation;
    }

    public Long getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Long idStatus) {
        this.idStatus = idStatus;
    }

    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
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

    public Long getIdPromotion() {
        return idPromotion;
    }

    public void setIdPromotion(Long idPromotion) {
        this.idPromotion = idPromotion;
    }

    public Classe getClasse() throws Exception {
        return new ClasseService().getClasseById(idClasse);
    }

    public Vol getVol() throws Exception {
        return new VolService().getVolById(idVol);
    }

    public Status getStatus() throws Exception {
        return new StatusService().getStatusById(idStatus);
    }
}


