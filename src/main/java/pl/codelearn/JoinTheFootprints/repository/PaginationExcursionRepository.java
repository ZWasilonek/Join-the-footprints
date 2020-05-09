package pl.codelearn.JoinTheFootprints.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import pl.codelearn.JoinTheFootprints.model.Excursion;

public interface PaginationExcursionRepository extends PagingAndSortingRepository<Excursion, Long> {

    Page<Excursion> findAll(Pageable pageable);

    @Query(value = "SELECT COUNT(*) FROM excursions", nativeQuery = true)
    Integer pagesNumber();

}
