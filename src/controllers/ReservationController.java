package controllers;

import annotation.Controller;
import annotation.Get;
import annotation.ParamObject;
import annotation.Post;
import annotation.Url;
import dto.ReservationDTO;
import services.ClasseService;
import services.ReservationService;
import services.VolService;
import util.CustomSession;
import util.ModelAndView;

@Controller
public class ReservationController {

    @Get
    @Url(url = "vols")
    public ModelAndView listVols() {
        ModelAndView mv = new ModelAndView("template-front.jsp");
        mv.setAttribute("content", "vol/form-reservation.jsp");
        try {
            mv.setAttribute("vols", new VolService().getAllVols());
            mv.setAttribute("classes", new ClasseService().getAllClasses());
        } catch (Exception e) {
            mv.setAttribute("erreur", e.getMessage());
        }
        return mv;
    }

    @Post
    @Url(url = "reserver")
    public ModelAndView reserver(@ParamObject(name = "reservation") ReservationDTO dto, CustomSession session) {
        ModelAndView mv = new ModelAndView("template-front.jsp");
        mv.setAttribute("content", "vol/form-reservation.jsp");
        try {
            Object userId = session.get("id");
            if (userId == null) {
                throw new Exception("Vous devez être connecté pour réserver");
            }
            new ReservationService().createReservation((Long) userId, dto.getIdVol(), dto.getIdClasse(), java.sql.Date.valueOf(dto.getDate()));
            mv.setAttribute("success", "Réservation effectuée avec succès");
            mv.setAttribute("vols", new VolService().getAllVols());
            mv.setAttribute("classes", new ClasseService().getAllClasses());
        } catch (Exception e) {
            mv.setAttribute("erreur", e.getMessage());
        }
        return mv;
    }

    @Get
    @Url(url = "mesReservations")
    public ModelAndView mesReservations(CustomSession session) {
        ModelAndView mv = new ModelAndView("template-front.jsp");
        mv.setAttribute("content", "vol/mes-reservations.jsp");
        try {
            Object userId = session.get("id");
            if (userId == null) {
                throw new Exception("Vous devez être connecté pour voir vos réservations");
            }
            mv.setAttribute("reservations", new ReservationService().listReservationsByUser((Long) userId));
        } catch (Exception e) {
            mv.setAttribute("erreur", e.getMessage());
        }
        return mv;
    }
}


