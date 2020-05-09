package pl.codelearn.JoinTheFootprints.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.codelearn.JoinTheFootprints.model.Country;
import pl.codelearn.JoinTheFootprints.model.Excursion;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ExcursionRepository extends JpaRepository<Excursion, Long> {
    List<Excursion> findAll();

    Optional<Excursion> findById(Long excursionId);

    @Query(value = "SELECT * FROM excursions AS e WHERE e.organizer_id = :organizerId AND e.departure_date >= CURDATE() ORDER BY e.departure_date LIMIT 1", nativeQuery = true)
    Excursion getExcursionByEarliestDate(@Param("organizerId") Long organizerId);

    @Query(value = "SELECT id,created, arrival_date, departure_date, description, expense, max_members, phone, title, updated, image_id, organizer_id From excursions AS e left join excursions_members on e.id = excursions_members.excursions_id where excursions_members.members_id=:userId OR e.organizer_id=:userId AND e.departure_date >= CURDATE() ORDER BY e.departure_date LIMIT 3", nativeQuery = true)
    List<Excursion> getNextExcursionsByDate(@Param("userId") Long userId);

    @Query(value = "SELECT COUNT(*) FROM excursions AS e WHERE e.organizer_id = :organizerId AND e.arrival_date <= CURDATE()", nativeQuery = true)
    int getAllCompletedExcursions(@Param("organizerId") Long organizerId);

//    @Query(value = "SELECT  FROM excursions AS e WHERE e.organizer_id = :organizerId ORDER BY e.departure_date DESC", nativeQuery = true)
//    List<Excursion> getAllExcursionsOrderingByDate(@Param("organizerId") Long organizerId);

    @Query(value = "SELECT id,created, arrival_date, departure_date, description, expense, max_members, phone, title, updated, image_id, organizer_id From excursions AS e left join excursions_members on e.id = excursions_members.excursions_id where excursions_members.members_id=:userId or e.organizer_id=:userId ORDER BY e.departure_date DESC", nativeQuery = true)
    Set<Excursion> getAllUserJoinsExcursions(@Param("userId") Long userId);


    //---------------FIND----------------
    @Query(value = "SELECT excursion_id FROM excursions_countries AS ec WHERE ec.countries_id = :countries_id", nativeQuery = true)
    Set<Long> getExcursionIdByCountryId(@Param("countries_id") Long countryId);

    @Query("select e from Excursion as e where e.countries = :countries")
    Set<Excursion> getByCountries(@Param("countries") List<Country> countries);

    //DLACZEGO NIE DZIAŁA
//    SELECT * From excursions as e where e.expense between 5000 and 99999 and e.departure_date >= NOW();
    // @Query("SELECT e From Excursion as e where e.expense between :minExpense and :maxExpense and e.dateOfDeparture >= current_date")
//    @Query("SELECT e From Excursion as e where e.expense between :minExpense and :maxExpense and e.dateOfDeparture >= :currentDate")
//    Set<Excursion> getExcursionsByExpenseRange(@Param("minExpense") double minExpense,
//                                               @Param("maxExpense") double maxExpense,
//                                               @Param("currentDate") LocalDate currentDate);
    @Query("SELECT e From Excursion as e where e.expense between :minExpense and :maxExpense")
    Set<Excursion> getExcursionsByExpenseRange(@Param("minExpense") double minExpense,
                                               @Param("maxExpense") double maxExpense);


    //Sprawdź co działa 1 czy 2
    //1
    @Query(value = "SELECT excursion_id FROM excursions_categories AS ec WHERE ec.categories_id = :categoryId", nativeQuery = true)
    Set<Long> getExcursionIdByCategoryId(@Param("categoryId") Long categoryId);

    //2 - czy nie znajduje po dokładnym dopasowaniu tych kategori a nie jednym z nich
//    Set<Excursion> findAllByCategories();

    Set<Excursion> findAllByDateOfDeparture(LocalDate dateOfDeparture);

    Set<Excursion> findAllByDateOfArrival(LocalDate dateOfArrival);

    @Query("SELECT e FROM Excursion AS e WHERE e.maxMembers >= :maxMembers")
    Set<Excursion> getExcursionsByMaxMembers(@Param("maxMembers") Integer maxMembers);

    @Query("SELECT distinct e FROM Excursion AS e WHERE e.dateOfDeparture >= :departureDate")
    Set<Excursion> getExcursionsByDepartureDate(@Param("departureDate") LocalDate departureDate);

    @Query("SELECT e FROM Excursion AS e WHERE e.dateOfArrival <= :arrivalDate AND e.dateOfArrival >= :currentDate")
    Set<Excursion> getExcursionsByArrivalDate(@Param("arrivalDate") LocalDate arrivalDate,
                                              @Param("currentDate") LocalDate currentDate);

    Excursion findFirstByOrderByDateOfArrivalDesc();

    @Query(value = "SELECT COUNT(*) FROM excursions", nativeQuery = true)
    Integer pagesNumber();

}
