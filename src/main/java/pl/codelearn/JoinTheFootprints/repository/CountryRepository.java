package pl.codelearn.JoinTheFootprints.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.codelearn.JoinTheFootprints.model.Country;

import java.util.Set;

public interface CountryRepository extends JpaRepository<Country, Long> {

    @Query(value = "SELECT countries_id FROM excursions_countries AS ec ORDER BY ec.countries_id ASC", nativeQuery = true)
    Set<Long> getAllAvailableCountriesId();

}
