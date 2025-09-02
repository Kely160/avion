package controllers;

import annotation.Controller;
import annotation.ParamObject;
import annotation.Post;
import annotation.Url;
import dto.LoginDTO;
import models.Role;
import services.UtilisateurService;
import util.CustomSession;
import util.ModelAndView;

@Controller
public class UtilisateurController {
    @Post
    @Url(url = "login")
    public ModelAndView login(@ParamObject(name = "utilisateur") LoginDTO utilisateur, CustomSession session) {
        ModelAndView modelAndView = new ModelAndView(null);
        UtilisateurService utilisateurService = new UtilisateurService();

        try {
            Role role = utilisateurService.login(session, utilisateur.getEmail(), utilisateur.getMdp());

            if(role.getNom().equals("ADMIN")){
                modelAndView.setUrl("template-back.jsp");
            }
            else if(role.getNom().equals("PASSAGER")){  
                modelAndView.setUrl("template-front.jsp");
            }
        } catch (Exception e) {
            modelAndView.setUrl("index.jsp");
            modelAndView.setAttribute("erreur", e.getMessage());
        }

        return modelAndView;
    }
}
