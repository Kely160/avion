package controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import annotation.Controller;
import annotation.Get;
import annotation.ParamObject;
import annotation.Post;
import annotation.Url;
import dto.VolDTO;
import models.Avion;
import models.Vol;
import services.AvionService;
import services.VolService;
import util.ModelAndView;

@Controller
public class VolController {
    @Get
    @Url(url = "ajouterVol")
    public ModelAndView ajouterVol() {
        ModelAndView mv = new ModelAndView("template-back.jsp");
        mv.setAttribute("content", "vol/form-vol.jsp");

        try {
            mv.setAttribute("avions", new AvionService().getAllAvions());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return mv;
    }

    @Post
    @Url(url = "saveVol")
    public ModelAndView saveVol(@ParamObject(name = "vol") VolDTO dto) {
        ModelAndView mv = new ModelAndView("template-back.jsp");
        mv.setAttribute("content", "vol/form-vol.jsp");

        try {
            Vol vol = new Vol();
            vol.setIdentification(dto.getIdentification());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
            LocalDateTime dateTime = LocalDateTime.parse(dto.getDateHeureDepart(), formatter);
            vol.setDateHeureDepart(dateTime);

            Avion avion = new AvionService().getAvionById(dto.getAvionId());
            vol.setAvion(avion);

            new VolService().saveVol(vol);

            mv.setAttribute("success", "Le vol a été enregistré avec succès.");
            mv.setAttribute("avions", new AvionService().getAllAvions());

        } catch (Exception e) {
            e.printStackTrace();
            mv.setAttribute("erreur", "Erreur lors de l'enregistrement du vol : " + e.getMessage());
        }

        return mv;
    }
}
