package pl.codelearn.JoinTheFootprints.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.codelearn.JoinTheFootprints.controller.generic.SessionUserGeneric;
import pl.codelearn.JoinTheFootprints.dto.ExcursionDTO;
import pl.codelearn.JoinTheFootprints.impl.*;
import pl.codelearn.JoinTheFootprints.model.Category;
import pl.codelearn.JoinTheFootprints.model.Country;
import pl.codelearn.JoinTheFootprints.model.Excursion;
import pl.codelearn.JoinTheFootprints.model.User;
import pl.codelearn.JoinTheFootprints.validation.ExcursionDTOValidator;
import pl.codelearn.JoinTheFootprints.validation.ExcursionValidator;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping("/app/excursion")
public class ExcursionController extends SessionUserGeneric {

    public static String uploadDirectory = System.getProperty("users.dir") + "/uploads";

    private final HttpSession session;
    private final CountryServiceImpl countryServiceImpl;
    private final CategoryServiceImpl categoryServiceImpl;
    private final ExcursionDTOValidator excursionDTOValidator;
    private final ExcursionValidator excursionValidator;
    private final ExcursionServiceImpl excursionServiceImpl;
    private final UserServiceImpl userServiceImpl;
    private final MemberServiceImpl memberServiceImpl;

    @Autowired
    public ExcursionController(HttpSession session, CountryServiceImpl countryServiceImpl, CategoryServiceImpl categoryServiceImpl, ExcursionDTOValidator excursionDTOValidator, ExcursionValidator excursionValidator, ExcursionServiceImpl excursionServiceImpl, UserServiceImpl userServiceImpl, MemberServiceImpl memberServiceImpl) {
        this.session = session;
        this.countryServiceImpl = countryServiceImpl;
        this.categoryServiceImpl = categoryServiceImpl;
        this.excursionDTOValidator = excursionDTOValidator;
        this.excursionValidator = excursionValidator;
        this.excursionServiceImpl = excursionServiceImpl;
        this.userServiceImpl = userServiceImpl;
        this.memberServiceImpl = memberServiceImpl;
    }


    @GetMapping
    public String displayPage() {
        return "app-excursions";
    }

    @ModelAttribute("sessionUser")
    public User getSessionUser() {
        Long userId = (Long) session.getAttribute("userId");
        User sessionUser = null;

        try {
            sessionUser = userServiceImpl.findById(userId);
        } catch (NoSuchElementException e) {
            System.out.println("No such user in session");
        }
        return sessionUser;
    }

    @ModelAttribute("userId")
    public Long getUserSessionId() {
        return getSessionUser().getId();
    }


    //------------------------Dashboard---------------------------
    @ModelAttribute("excursions")
    public List<Excursion> userExcursions(Model model) {
//        final String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
        int completedExcursions = excursionServiceImpl.getAllCompletedExcursions(getSessionUser().getId());
        model.addAttribute("completedExcursions", completedExcursions);

        List<Excursion> userExcursions = new ArrayList<>(excursionServiceImpl.getAllUserJoinsExcursions(getSessionUser().getId()));
        if (userExcursions.size() == 0) {
            model.addAttribute("noExcursions", "You want to start your adventure - add your first trip and make your dreams come true with us");
        }
        return userExcursions;
    }


    //------------------------ADD---------------------------
    @GetMapping("/add")
    public String displayForm(Model model) {
        Excursion excursion = new Excursion();
        excursion.setOrganizer(getSessionUser());
        model.addAttribute("excursionForm", excursion);
        return "app-excursion-add";
    }

    @ModelAttribute("countryItems")
    public List<Country> countriesList() {
        return this.countryServiceImpl.findAll();
    }

    @ModelAttribute("categoryItems")
    public List<Category> categoriesList() {
        return this.categoryServiceImpl.findAll();
    }

    @PostMapping("/add")
    public String getExcursionForm(@Valid @ModelAttribute("excursionForm") Excursion excursion,
                                   BindingResult result) {
        excursionValidator.validate(excursion, result);

        if (result.hasErrors()) return "app-excursion-add";
        excursionServiceImpl.saveExcursion(excursion);

        return "redirect:/app/excursion";
    }


    //------------------------FIND---------------------------
    @GetMapping("/find")
    public String displayExcursionsBrowser(Model model) {
        model.addAttribute("excursionFound", new ExcursionDTO());
        return "app-excursion-find";
    }

    @PostMapping("/find")
    public String findAvailableExcursions(Model model,
                                          @ModelAttribute("availableCountries") List<Country> availableCountries,
                                          @ModelAttribute("availableCategories") List<Category> availableCategories,
                                          @Valid @ModelAttribute("excursionFound") ExcursionDTO excursionDTO,
                                          BindingResult result) {

        excursionDTOValidator.validate(excursionDTO, result);
        if (result.hasErrors()) return "app-excursion-find";
        List<Excursion> foundedExcursions = new ArrayList<>(excursionServiceImpl.foundedExcursions(excursionDTO));
        model.addAttribute("foundedExcursions", foundedExcursions);
        model.addAttribute("hideDefaultExcursions", true);
        return "app-excursion-find";
    }

    @ModelAttribute("availableCountries")
    public List<Country> getAvailableCountries() {
        return countryServiceImpl.availableCountries();
    }

    @ModelAttribute("availableCategories")
    public List<Category> getAvailableCategories() {
        return categoryServiceImpl.getAvailableCategories();
    }

    @ModelAttribute("allExcursions")
    public List<Excursion> getAllExcursions() {
        return excursionServiceImpl.findAll();
    }

    //------------------------Edit---------------------------
    @GetMapping("/edit")
    public String displayEditForm(@RequestParam("id") Long excursionId, Model model) {
        Excursion editExcursion = excursionServiceImpl.findById(excursionId);
        model.addAttribute("excursionForm", editExcursion);
        return "app-excursion-add";
    }

    @PostMapping("/edit")
    public String updateExcursion(@Valid @ModelAttribute("excursionForm") Excursion excursion,
                                  BindingResult result) {
        excursionValidator.validate(excursion, result);

        if (result.hasErrors()) return "app-excursion-add";
        excursionServiceImpl.saveExcursion(excursion);

        return "redirect:/app/excursion";
    }


    //------------------------DELETE---------------------------
    @GetMapping("/delete")
    public String removeExcursion(@RequestParam("id") Long excursionId) {
        excursionServiceImpl.removeExcursion(excursionId);
        return "redirect:/app/excursion";
    }


    //------------------------EXCURSION DETAILS---------------------------
    @GetMapping("/showDetails")
    public String displayExcursionDetails(Model model,
                                          @RequestParam("id") Long excursionId) {
        model.addAttribute("excursion", excursionServiceImpl.findById(excursionId));
        return "app-excursion-details";
    }


    //------------------------JOIN---------------------------
    @GetMapping("/join")
    public String joinToExcursion(@RequestParam("id") Long excursionId,
                                  @RequestParam("user_id") Long userId,
                                  @ModelAttribute("hasThisMemberAlready") boolean hasThisMemberAlready,
                                  Model model) {
        if (!hasThisMemberAlready) {
            memberServiceImpl.saveMemberToExcursion(excursionId, userId);
        }
        model.addAttribute("excursion", excursionServiceImpl.findById(excursionId));
        return "app-excursion-details";
    }

    @ModelAttribute("hasThisMemberAlready")
    public boolean hasThisMemberAlready() {
        return memberServiceImpl.hasMemberAlready(getUserSessionId());
    }


    //------------------------RESIGN---------------------------
    @GetMapping("/resign")
    public String leaveExcursion(@RequestParam("id") Long excursionId,
                                 @RequestParam("user_id") Long userId,
                                 Model model) {
        memberServiceImpl.removeMemberFromExcursion(excursionId, userId);
        model.addAttribute("excursion", excursionServiceImpl.findById(excursionId));
        return "app-excursion-details";
    }

//    @ModelAttribute("excursion")
//    public Excursion getExcursionById(Long id) {
//        return excursionRepository.findById(id).get();
//    }

}


//    @PostMapping("/find")
//    public String findAvailableExcursions(@ModelAttribute("availableCountries") List<Country> availableCountries,
//                                          @RequestParam(required = false, name = "departure_date") LocalDate dateOfDeparture,
//                                          @RequestParam(required = false, name = "arrival_date") LocalDate dateOfArrival,
//                                          @RequestParam(required = false, name = "max_members") Integer maxMembers,
//                                          @RequestParam(required = false, name = "max_expense") Integer maxExpense,
//                                          @RequestParam(required = false, name = "min_expense") Integer minExpense,
//                                          @RequestParam(required = false, name = "categories") List<Category> categories,
//                                          @ModelAttribute("excursionFound") Excursion excursion,
//                                          Model model) {
//        Set<Excursion> foundedExcursions = new HashSet<>();
//        if (availableCountries.size() != 0) {
//            foundedExcursions = excursionRepository.getByCountries(availableCountries);
//        }
//        return "redirect:/app/excursion/find";
//    }