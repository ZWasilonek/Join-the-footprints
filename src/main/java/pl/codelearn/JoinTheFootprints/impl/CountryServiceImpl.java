package pl.codelearn.JoinTheFootprints.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.codelearn.JoinTheFootprints.impl.generic.GenericServiceImpl;
import pl.codelearn.JoinTheFootprints.model.Country;
import pl.codelearn.JoinTheFootprints.model.Excursion;
import pl.codelearn.JoinTheFootprints.repository.CountryRepository;
import pl.codelearn.JoinTheFootprints.service.CountryService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl extends GenericServiceImpl<Country, CountryRepository> implements CountryService<Country> {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository repository, CountryRepository countryRepository) {
        super(repository);
        this.countryRepository = countryRepository;
    }

    @Override
    public Set<Long> availableCountriesId() {
        return countryRepository.getAllAvailableCountriesId();
    }

//    @Override
//    public List<Country> findAll() {
//        return countryRepository.findAll();
//    }

    public List<Country> availableCountries() {
        return availableCountriesId().stream()
                .map(id ->
                        countryRepository.findById(id).orElse(null))
                .collect(Collectors.toList());
    }

}
