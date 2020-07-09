package by.shurik.preproject.task34.Server.controller;

import by.shurik.preproject.task34.Server.dto.UserDto;
import by.shurik.preproject.task34.Server.model.User;
import by.shurik.preproject.task34.Server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/admin")
public class AdminRestController {
    private UserService userService;


    @Autowired
    public AdminRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/addUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addUser(@RequestBody User newUser) {
        Optional<?> optionalUser = userService.addUser(newUser);//
        if (optionalUser.isPresent()) {
            return new ResponseEntity<>(optionalUser.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User updateUser) {
        Optional<?> optionalUser = userService.updateUser(updateUser);//
        if (optionalUser.isPresent()) {
            return new ResponseEntity<>(optionalUser.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>((HttpStatus.OK));
    }

    @GetMapping("/allUsers")
    public List<User> getUsersList() {
        return userService.listUser();
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.removeUser(id);
    }

    @GetMapping("/{email}")
    public UserDto getByEmail(@PathVariable String email) {
        User user = userService.findByUserEmail(email);
        return new UserDto(user);
    }

}
