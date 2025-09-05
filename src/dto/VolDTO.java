package dto;

import annotation.FieldAnnotation;

public class VolDTO {
    @FieldAnnotation(name = "identification")
    private String identification;

    @FieldAnnotation(name = "dateHeureDepart")
    private String dateHeureDepart; 

    @FieldAnnotation(name = "avion.id")
    private Long avionId;

    public String getIdentification() {
        return identification;
    }
    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getDateHeureDepart() {
        return dateHeureDepart;
    }
    public void setDateHeureDepart(String dateHeureDepart) {
        this.dateHeureDepart = dateHeureDepart;
    }

    public Long getAvionId() {
        return avionId;
    }
    public void setAvionId(Long avionId) {
        this.avionId = avionId;
    }
}
