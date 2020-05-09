package pl.codelearn.JoinTheFootprints.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pl.codelearn.JoinTheFootprints.model.Excursion;

public interface MemberRepository extends JpaRepository<Excursion, Long> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO excursions_members VALUES (:excursionId, :memberId)", nativeQuery = true)
    void saveMemberToExcursion(@Param("excursionId") Long excursionId, @Param("memberId") Long memberId);

    //    @Query(value = "SELECT members_id FROM excursions_members WHERE excursions_id=:excursionId", nativeQuery = true)
//    Long getMemberIdByExcursionId(@Param("excursionId") Long excursionId);
    @Query(value = "SELECT members_id FROM excursions_members WHERE members_id=:memberId", nativeQuery = true)
    Long getExcursionIdByMemberId(@Param("memberId") Long memberId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM excursions_members WHERE excursions_id=:excursionId AND members_id=:memberId", nativeQuery = true)
    void removeMemberFromExcursion(@Param("excursionId") Long excursionId, @Param("memberId") Long memberId);

}
