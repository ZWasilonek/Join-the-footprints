package pl.codelearn.JoinTheFootprints.service;

import pl.codelearn.JoinTheFootprints.model.User;
import pl.codelearn.JoinTheFootprints.service.generic.GenericService;

public interface UserService<T> extends GenericService<T> {

//    void save(User user);

    User findUserByEmail(String email);

    void saveUser(User user);

//    User findById(Long userId);

//    Long getOrganizerIdByExcursionId(Long excursionId);

}