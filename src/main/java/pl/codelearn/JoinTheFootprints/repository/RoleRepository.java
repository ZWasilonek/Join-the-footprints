package pl.codelearn.JoinTheFootprints.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.codelearn.JoinTheFootprints.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
//    void findByName(String role);
}
