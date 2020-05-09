package pl.codelearn.JoinTheFootprints.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.codelearn.JoinTheFootprints.controller.generic.SessionUserGeneric;
import pl.codelearn.JoinTheFootprints.model.Excursion;
import pl.codelearn.JoinTheFootprints.repository.ExcursionRepository;
import pl.codelearn.JoinTheFootprints.service.PaginationExcursionService;

import java.util.List;

@Controller
@RequestMapping("/list")
public class AllExcursionsController extends SessionUserGeneric {

    @Autowired
    private PaginationExcursionService pageService;

    @Autowired
    private ExcursionRepository excursionRepository;

    //------------------------MAIN LIST---------------------------
//    @GetMapping
//    public String displayMainList(@ModelAttribute("allExcursions") List<Excursion> excursions) {
//        return "";
//    }

    @GetMapping
    public String getAllExcursions (@RequestParam(defaultValue = "0") Integer pageNo,
                                    @RequestParam(defaultValue = "4") Integer pageSize,
                                    Model model) {
        List<Excursion> excursionList = pageService.getAllExcursions(pageNo, pageSize);
        Integer pagesNumber = pageService.getPagesNumber()/pageSize;
        model.addAttribute("allExcursions", new ResponseEntity<List<Excursion>>(excursionList, new HttpHeaders(), HttpStatus.OK));
        model.addAttribute("pagesNumber", pagesNumber);
        return "excursions-list";
    }

//    @ModelAttribute("allExcursions")
//    public List<Excursion> getAllExcursions() {
//        return excursionRepository.findAll();
//    }
}
