package controllers;

import annotation.Controller;
import annotation.Get;
import annotation.ParamObject;
import annotation.Post;
import annotation.Url;
import dto.CompagnieDTO;
import models.Compagnie;
import services.CompagnieService;
import util.ModelAndView;

@Controller
public class CompagnieController {
    @Get
    @Url(url = "compagnies")
    public ModelAndView listeCompagnie() {
        ModelAndView mv = new ModelAndView("template-back.jsp");
        mv.setAttribute("content", "compagnie/compagnies.jsp");

        try {
            mv.setAttribute("compagnies", new CompagnieService().getAllCompagnies());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mv;
    }

    @Get
    @Url(url = "ajouterCompagnie")
    public ModelAndView ajouterCompagnie() {
        ModelAndView mv = new ModelAndView("template-back.jsp");
        mv.setAttribute("content", "compagnie/form-compagnie.jsp");
        return mv;
    }

    @Post
    @Url(url = "saveCompagnie")
    public ModelAndView saveCompagnie(@ParamObject(name = "compagnie") CompagnieDTO compagnieDTO) {
        ModelAndView mv = new ModelAndView("template-back.jsp");

        try {
            Compagnie compagnie = new Compagnie();
            compagnie.setNom(compagnieDTO.getNom());
            compagnie.setAdresse(compagnieDTO.getAdresse());
            compagnie.setContact(compagnieDTO.getContact());
            new CompagnieService().saveCompagnie(compagnie);

            mv.setAttribute("content", "compagnie/compagnies.jsp");
            mv.setAttribute("compagnies", new CompagnieService().getAllCompagnies());
        } catch (Exception e) {
            e.printStackTrace();
            mv.setAttribute("content", "compagnie/form-compagnie.jsp");
            mv.setAttribute("erreur", e.getMessage());
        }

        return mv;
    }
}
