package pl.codelearn.JoinTheFootprints.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.codelearn.JoinTheFootprints.model.Excursion;
import pl.codelearn.JoinTheFootprints.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

//    @Query(value = "SELECT organizer_id FROM excursions WHERE id=:excursionId", nativeQuery = true)
//    Long getOrganizerIdByExcursionId(@Param("id") Long excursionId);
}
