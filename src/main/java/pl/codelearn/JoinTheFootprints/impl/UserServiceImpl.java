package pl.codelearn.JoinTheFootprints.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.codelearn.JoinTheFootprints.impl.generic.GenericServiceImpl;
import pl.codelearn.JoinTheFootprints.model.Excursion;
import pl.codelearn.JoinTheFootprints.model.User;
import pl.codelearn.JoinTheFootprints.repository.RoleRepository;
import pl.codelearn.JoinTheFootprints.repository.UserRepository;
import pl.codelearn.JoinTheFootprints.service.UserService;

import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, UserRepository> implements UserService<User> {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository repository, UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        super(repository);
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        if (user.getSurname().equals("")) user.setSurname(null);
        userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

//    @Override
//    public User findById(Long userId) {
//        return userRepository.findById(userId).orElse(null);
//    }

//    @Override
//    public Long getOrganizerIdByExcursionId(Long excursionId) {
//        return userRepository.getOrganizerIdByExcursionId(excursionId);
//    }

//    @Override
//    public List<Excursion> findUserExcursions() {
//        return userRepository.findAllByExcursions();
//    }

//    @Override
//    public int countAllUserExcursions() {
//        return userRepository.countByExcursions();
//    }

}