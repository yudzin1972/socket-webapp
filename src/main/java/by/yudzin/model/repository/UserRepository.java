package by.yudzin.model.repository;

import by.yudzin.model.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        User user1 = new User("admin", "admin");
        User user2= new User("root","root");
        User user3=new User("user","user");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        return users;
    }
}
