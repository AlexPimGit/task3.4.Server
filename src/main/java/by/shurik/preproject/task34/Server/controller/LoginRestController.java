package by.shurik.preproject.task34.Server.controller;

import by.shurik.preproject.task34.Server.dto.UserDto;
import by.shurik.preproject.task34.Server.model.User;
import by.shurik.preproject.task34.Server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rest/login", produces = MediaType.APPLICATION_JSON_VALUE)
//produces = MediaType.APPLICATION_JSON_VALUE говорит, что по умолчанию все методы этого контроллера будут отдавать JSON
public class LoginRestController {
    private UserService userService;

    @Autowired
    public LoginRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{email}")
    public UserDto getById(@PathVariable String email) {
        User user = userService.findByUserEmail(email);
        return new UserDto(user);
//        return new User(user.getId(), user.getName(), user.getEmail(), user.getPosition(), user.getUserPassword(), user.getRoles().iterator().next().getName());

    }
}
