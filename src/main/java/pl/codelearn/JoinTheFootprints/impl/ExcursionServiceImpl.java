package pl.codelearn.JoinTheFootprints.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import pl.codelearn.JoinTheFootprints.dto.ExcursionDTO;
import pl.codelearn.JoinTheFootprints.impl.generic.GenericServiceImpl;
import pl.codelearn.JoinTheFootprints.model.Category;
import pl.codelearn.JoinTheFootprints.model.Country;
import pl.codelearn.JoinTheFootprints.model.Excursion;
import pl.codelearn.JoinTheFootprints.repository.CategoryRepository;
import pl.codelearn.JoinTheFootprints.repository.CountryRepository;
import pl.codelearn.JoinTheFootprints.repository.ExcursionRepository;
import pl.codelearn.JoinTheFootprints.service.ExcursionService;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ExcursionServiceImpl extends GenericServiceImpl<Excursion, ExcursionRepository> implements ExcursionService<Excursion> {

    private final ExcursionRepository excursionRepository;
    private final CountryRepository countryRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ExcursionServiceImpl(ExcursionRepository repository, ExcursionRepository excursionRepository, CountryRepository countryRepository, CategoryRepository categoryRepository) {
        super(repository);
        this.excursionRepository = excursionRepository;
        this.countryRepository = countryRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void saveExcursion(Excursion excursion) {
        if (excursion.getCategories().size() == 0) excursion.setCategories(null);
        if (excursion.getDescription().equals("")) excursion.setDescription(null);
        if (excursion.getPhoneNumber().equals("")) excursion.setPhoneNumber(null);
        excursionRepository.save(excursion);
    }

    @Override
    public Excursion findTheEarliestTrip(Long organizerId) {
        return excursionRepository.getExcursionByEarliestDate(organizerId);
    }

    @Override
    public List<Excursion> getNextExcursionsByDate(Long organizerId) {
        return excursionRepository.getNextExcursionsByDate(organizerId);
    }

    @Override
    public void removeExcursion(Long excursionId) {
        Excursion excursion = excursionRepository.findById(excursionId).orElse(null);
        if (excursion != null) {
            LocalDate departureDay = excursion.getDateOfDeparture();
            LocalDate today = LocalDate.now();
            if (excursion.getMembers().size() == 0 || (
                    excursion.getMembers().size() != 0
                            && departureDay.isBefore(today))) {
                excursionRepository.deleteById(excursionId);
            }
        }
    }

//    @Override
//    public Excursion findById(Long id) {
//        return excursionRepository.findById(id).orElse(null);
//    }

    @Override
    public List<Excursion> findAll() {
        return excursionRepository.findAll();
    }

    @Override
    public Set<Excursion> getAllUserJoinsExcursions(Long userId) {
        return excursionRepository.getAllUserJoinsExcursions(userId);
    }

    @Override
    public int getAllCompletedExcursions(Long userId) {
        return excursionRepository.getAllCompletedExcursions(userId);
    }

    public Set<Excursion> foundedExcursions(ExcursionDTO excursionDTO) {
        Set<Excursion> result = new HashSet<>();

        Set<Excursion> byCountries = foundedExcursionsByCountries(excursionDTO);
        if (byCountries.size() == 0) {
            Set<Long> allAvailableCountriesId = countryRepository.getAllAvailableCountriesId();
            excursionDTO.setCountries(allAvailableCountriesId.stream()
                .map(id -> countryRepository.findById(id).get())
                .collect(Collectors.toList()));
        }

        Set<Excursion> byCategories = foundedExcursionsByCategories(excursionDTO);
        if (byCategories.size() == 0) {
            Set<Long> allAvailableCategoriesId = categoryRepository.getAllAvailableCategoriesId();
            excursionDTO.setCategories(allAvailableCategoriesId.stream()
                    .map(id -> categoryRepository.findById(id).get())
                    .collect(Collectors.toList()));
        }
        Set<Excursion> byExpense = foundedExcursionsByExpenseRange(excursionDTO);
        if (byExpense.size() == 0) {
            excursionDTO.setMinExpense(1.0);
            excursionDTO.setMaxExpense(99999.0);
        }
        Set<Excursion> byDepartureDate = excursionRepository.getExcursionsByDepartureDate(excursionDTO.getDateOfDeparture());
        if (byDepartureDate.size() == 0) {
            excursionDTO.setDateOfDeparture(LocalDate.now());
        }
        Set<Excursion> byArrivalDate = excursionRepository.getExcursionsByArrivalDate(excursionDTO.getDateOfArrival(), LocalDate.now());
        if (byArrivalDate.size() == 0) {
            excursionDTO.setDateOfArrival(excursionRepository.findFirstByOrderByDateOfArrivalDesc().getDateOfArrival());
        }

        Set<Excursion> byMaxMembers = excursionRepository.getExcursionsByMaxMembers(excursionDTO.getMaxMembers());
        if (byMaxMembers.size() == 0) {
            excursionDTO.setMaxMembers(1);
        }

        Set<Excursion> excursions = mergeSets(byCountries, byExpense, byCategories, byDepartureDate, byArrivalDate);
        for (Excursion excursion : excursions) {
            if (hasDepartureDate(excursion, excursionDTO) && hasArrivalDate(excursion, excursionDTO)
                    && hasCountry(excursion, excursionDTO) && isInRange(excursion, excursionDTO)
                    && freePlaces(excursion, excursionDTO) && hasCategories(excursion, excursionDTO))
                result.add(excursion);
        }
        return result;
    }

    public boolean hasCountry(Excursion excursion, ExcursionDTO excursionDTO) {
        List<Country> dtoCountries = excursionDTO.getCountries();
        if (hasDepartureDate(excursion, excursionDTO)) {
            for (Country country : dtoCountries) {
                if (excursion.getCountries().contains(country))
                return true;
            }
        }
        return false;
    }

    public boolean isInRange(Excursion excursion, ExcursionDTO excursionDTO) {
        return hasDepartureDate(excursion, excursionDTO) &&
                excursion.getExpense() <= excursionDTO.getMaxExpense() &&
                excursion.getExpense() >= excursionDTO.getMinExpense();
    }

    public boolean freePlaces(Excursion excursion, ExcursionDTO excursionDTO) {
        return hasDepartureDate(excursion, excursionDTO) &&
                excursion.getMaxMembers() >= excursionDTO.getMaxMembers();
    }

    public boolean hasCategories(Excursion excursion, ExcursionDTO excursionDTO) {
        List<Category> dtoCategories = excursionDTO.getCategories();
        if (hasDepartureDate(excursion, excursionDTO)) {
            for (Category category : dtoCategories) {
                if (excursion.getCategories().contains(category))
                return true;
            }
        }
        return false;
    }

    public boolean hasDepartureDate(Excursion excursion, ExcursionDTO excursionDTO) {
        LocalDate excursionDate = excursion.getDateOfDeparture();
        LocalDate dtoDate = excursionDTO.getDateOfDeparture();
        return excursionDate.equals(dtoDate) || excursionDate.isAfter(dtoDate);
    }

    public boolean hasArrivalDate(Excursion excursion, ExcursionDTO excursionDTO) {
        LocalDate excursionDate = excursion.getDateOfArrival();
        LocalDate dtoDate = excursionDTO.getDateOfArrival();
        return excursionDate.equals(dtoDate) || excursionDate.isBefore(dtoDate);
    }

    public Set<Excursion> foundedExcursionsByCountries(ExcursionDTO excursionDTO) {
        List<Country> selectedCountries = excursionDTO.getCountries();
        Set<Excursion> result = new HashSet<>();
        for (Country country : selectedCountries) {
            Set<Long> excursionsId = excursionRepository.getExcursionIdByCountryId(country.getId());
            Set<Excursion> excursions = excursionsId.stream()
                    .map(id -> excursionRepository.findById(id).get())
                    .collect(Collectors.toSet());
            result.addAll(excursions);
        }
        return result;
    }

    public Set<Excursion> foundedExcursionsByExpenseRange(ExcursionDTO excursionDTO) {
        Double minExpense = excursionDTO.getMinExpense();
        Double maxExpense = excursionDTO.getMaxExpense();
        return excursionRepository.getExcursionsByExpenseRange(minExpense, maxExpense);
    }

    public Set<Excursion> foundedExcursionsByCategories(ExcursionDTO excursionDTO) {
        List<Category> selectedCategories = excursionDTO.getCategories();
        Set<Excursion> result = new HashSet<>();
        for (Category category : selectedCategories) {
            Set<Long> excursionsId = excursionRepository.getExcursionIdByCategoryId(category.getId());
            Set<Excursion> excursions = excursionsId.stream()
                    .map(id -> excursionRepository.findById(id).get())
                    .collect(Collectors.toSet());
            result.addAll(excursions);
        }
        return result;

//        List<Category> selectedCategories = excursionDTO.getCategories();
//        return selectedCategories.stream()
//            .map(category -> excursionRepository.getExcursionIdByCategoryId(category.getId()))
//            .collect(Collectors.toSet())
//        .stream()
//            .map(id -> excursionRepository.findById(id).get())
//            .collect(Collectors.toSet());
    }

    //----------------FIND-----------------
//    @Override
//    public Set<Excursion> findByCountryId(Long countryId) {
//        return excursionRepository.getAllExcursionsByCountryId(countryId);
//    }


    @SafeVarargs
    public static <T> Set<T> mergeSets(Set<T>... inputSet) {
        Set<T> result = new HashSet<>();
        for (Set<T> set : inputSet) {
            if (Objects.requireNonNull(set).size() != 0) result.addAll(set);
        }
        return result;
    }

}
