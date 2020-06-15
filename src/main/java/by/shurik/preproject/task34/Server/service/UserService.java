package by.shurik.preproject.task34.Server.service;

import by.shurik.preproject.task34.Server.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> addUser(User user);

    Optional<User> updateUser(User user);

    void removeUser(Long id);

    List<User> listUser();

    User findByUsername(String name);

    User findByUserEmail(String email);
}
