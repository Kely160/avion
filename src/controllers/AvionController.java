package controllers;

import annotation.Controller;
import annotation.Get;
import annotation.Url;
import services.AvionService;
import util.ModelAndView;

@Controller
public class AvionController {
    @Get    
    @Url(url = "avions")
    public ModelAndView listeAvion() {
        ModelAndView mv = new ModelAndView("template-back.jsp");
        mv.setAttribute("content", "avion/avions.jsp");

        try {
            mv.setAttribute("avions", new AvionService().getAllAvions());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return mv;  
    }
}
