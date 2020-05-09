package pl.codelearn.JoinTheFootprints.service;

import pl.codelearn.JoinTheFootprints.model.Excursion;

import java.util.List;

public interface PageService {

    List<Excursion> getAllExcursions(Integer pageNo, Integer pageSize);
    Integer getPagesNumber();
}
