package pl.codelearn.JoinTheFootprints.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.codelearn.JoinTheFootprints.model.Category;

import java.util.Set;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "SELECT categories_id FROM excursions_categories", nativeQuery = true)
    Set<Long> getAllAvailableCategoriesId();

}
