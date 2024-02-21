package by.yudzin.service;

import by.yudzin.model.entity.User;
import by.yudzin.model.repository.UserRepository;

import java.util.List;

public class LoginService {
    public boolean checkCredentials(String login, String password) {
        UserRepository userRepository = new UserRepository();
        List<User> users = userRepository.getUsers();
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
