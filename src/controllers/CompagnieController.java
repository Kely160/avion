package controllers;

import annotation.Controller;
import annotation.Get;
import annotation.Url;
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
}
