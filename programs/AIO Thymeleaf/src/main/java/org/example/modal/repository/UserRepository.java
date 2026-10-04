package org.example.modal.repository;

import org.example.modal.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    List<User> users = new ArrayList<>();

    public UserRepository() {
        users.add(new User(1, "Kunal", "Noida", 1122334455L));
        users.add(new User(2, "Rahul", "Delhi", 6600778899L));
        users.add(new User(3, "Rohit", "Pune",1133556688L));
        users.add(new User(4, "Vansh", "Pune", 2244006688L));
        users.add(new User(5, "Shrey", "Bengaluru",2244660088L));
    }

    public User getFirstUser() {
        return users.getFirst();
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUsersById(int id) {
        User found = null;
        for (User user : users) {
            if (user.getId() == id) {
                found = user;
                break;
            }
        }

        return found;
    }
}
