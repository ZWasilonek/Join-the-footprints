package pl.codelearn.JoinTheFootprints.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.codelearn.JoinTheFootprints.impl.generic.GenericServiceImpl;
import pl.codelearn.JoinTheFootprints.model.User;
import pl.codelearn.JoinTheFootprints.repository.MemberRepository;
import pl.codelearn.JoinTheFootprints.repository.UserRepository;
import pl.codelearn.JoinTheFootprints.service.MemberService;

@Service
public class MemberServiceImpl extends GenericServiceImpl<User, UserRepository> implements MemberService<User> {

    private final MemberRepository memberRepository;
    private final UserServiceImpl userServiceImpl;

    @Autowired
    public MemberServiceImpl(UserRepository repository, MemberRepository memberRepository, UserServiceImpl userServiceImpl) {
        super(repository);
        this.memberRepository = memberRepository;
        this.userServiceImpl = userServiceImpl;
    }

    @Override
    public void saveMemberToExcursion(Long excursionId, Long memberId) {
        if (excursionId != null && memberId != null)
        memberRepository.saveMemberToExcursion(excursionId, memberId);
    }

    @Override
    public boolean hasMemberAlready(Long memberId) {
        if (userServiceImpl.findById(memberId) != null) {
            return getExcursionIdByMemberId(memberId) != null;
        }
        return false;
    }

    @Override
    public Long getExcursionIdByMemberId(Long memberId) {
        return memberRepository.getExcursionIdByMemberId(memberId);
    }

    @Override
    public void removeMemberFromExcursion(Long excursionId, Long memberId) {
        if (excursionId != null && memberId != null)
            memberRepository.removeMemberFromExcursion(excursionId, memberId);
    }
}
