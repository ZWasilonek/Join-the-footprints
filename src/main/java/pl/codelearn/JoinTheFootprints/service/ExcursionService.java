package pl.codelearn.JoinTheFootprints.service;

import pl.codelearn.JoinTheFootprints.model.Excursion;
import pl.codelearn.JoinTheFootprints.service.generic.GenericService;

import java.util.List;
import java.util.Set;

public interface ExcursionService<T> extends GenericService<T> {

    void saveExcursion(Excursion excursion);
    Excursion findTheEarliestTrip(Long organizerId);
    List<Excursion> getNextExcursionsByDate(Long organizerId);
    void removeExcursion(Long excursionId);

//    Excursion findById(Long id);
//    List<Excursion> findAll();
    Set<Excursion> getAllUserJoinsExcursions(Long userId);
    int getAllCompletedExcursions(Long userId);

}
