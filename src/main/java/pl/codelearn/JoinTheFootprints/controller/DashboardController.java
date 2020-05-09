package pl.codelearn.JoinTheFootprints.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.codelearn.JoinTheFootprints.controller.generic.SessionUserGeneric;
import pl.codelearn.JoinTheFootprints.model.Excursion;
import pl.codelearn.JoinTheFootprints.model.User;
import pl.codelearn.JoinTheFootprints.impl.ExcursionServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/app")
public class DashboardController extends SessionUserGeneric {

    private final ExcursionServiceImpl excursionServiceImpl;

    @Autowired
    public DashboardController(ExcursionServiceImpl excursionServiceImpl) {
        this.excursionServiceImpl = excursionServiceImpl;
    }

    @GetMapping
    public String displayDashboard(@ModelAttribute("excursion") Excursion excursion) {
        return "app-desktop";
    }

//    @ModelAttribute("organizer")
//    public User getOrganizer() {
//        Long userId = (Long) session.getAttribute("userId");
//        User sessionUser = null;
//
//        try {
//            sessionUser = userRepository.findById(userId).get();
//        } catch (NoSuchElementException e) {
//            System.out.println("No such user in session");
//        }
//        return sessionUser;
//    }

    @Override
    @ModelAttribute("organizer")
    public User getSessionUser() {
        return super.getSessionUser();
    }

    @ModelAttribute("excursion")
    public Excursion getEarliestExcursion() {
        return excursionServiceImpl.findTheEarliestTrip(getSessionUser().getId());
    }

    @ModelAttribute("excursions")
    public List<Excursion> getUpcomingExcursions() {
        return excursionServiceImpl.getNextExcursionsByDate(getSessionUser().getId());
    }

}
