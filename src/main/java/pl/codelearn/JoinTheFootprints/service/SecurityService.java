package pl.codelearn.JoinTheFootprints.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
