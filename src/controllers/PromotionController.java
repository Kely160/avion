package controllers;

import annotation.Controller;
import annotation.Get;
import annotation.ParamObject;
import annotation.Post;
import annotation.Url;
import dto.PromotionDTO;
import models.Promotion;
import services.ClasseService;
import services.PromotionService;
import services.VolService;
import util.ModelAndView;

@Controller 
public class PromotionController {
    @Get
    @Url(url = "ajouterPromotion")
    public ModelAndView ajouterPromotion() {
        ModelAndView mv = new ModelAndView("template-back.jsp");
        mv.setAttribute("content", "vol/form-promotion.jsp");

        try {
            mv.setAttribute("classes", new ClasseService().getAllClasses());
            mv.setAttribute("vols", new VolService().getAllVols());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return mv;
    }

    @Post
    @Url(url = "savePromotion")
    public ModelAndView savePromotion(@ParamObject(name = "promotion") PromotionDTO promotionDTO) {
        ModelAndView mv = new ModelAndView("template-back.jsp");

        try {
            Promotion promotion = new Promotion();
            promotion.setPrix(promotionDTO.getPrix());
            promotion.setNbreSiege(promotionDTO.getNbreSiege());
            promotion.setDateFin(java.sql.Date.valueOf(promotionDTO.getDateFin()));
            promotion.setClasse(new ClasseService().getClasseById(promotionDTO.getIdClasse()));
            promotion.setVol(new VolService().getVolById(promotionDTO.getIdVol()));
            new PromotionService().savePromotion(promotion);

            mv.setAttribute("content", "vol/form-promotion.jsp");
            mv.setAttribute("success", "Promotion ajoutée avec succès !");
        } catch (Exception e) {
            e.printStackTrace();
            mv.setAttribute("content", "vol/form-promotion.jsp");
            mv.setAttribute("erreur", e.getMessage());
        }

        return mv;
    }
}
