package pl.codelearn.JoinTheFootprints.service;

import pl.codelearn.JoinTheFootprints.service.generic.GenericService;

public interface MemberService<T> extends GenericService<T> {

    void saveMemberToExcursion(Long excursionId, Long memberId);
    boolean hasMemberAlready(Long memberId);
    Long getExcursionIdByMemberId(Long memberId);
    void removeMemberFromExcursion(Long excursionId, Long memberId);

}
