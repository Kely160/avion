package dto;

import annotation.FieldAnnotation;
import annotation.Required;

public class LoginDTO {
    @Required
    @FieldAnnotation(name = "email")
    String email;
    @Required
    @FieldAnnotation(name = "mdp")
    String mdp;

    public LoginDTO() {
    }

    public LoginDTO(String email, String mdp) {
        this.email = email;
        this.mdp = mdp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
