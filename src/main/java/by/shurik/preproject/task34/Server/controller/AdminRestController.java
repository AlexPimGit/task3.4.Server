package by.shurik.preproject.task34.Server.controller;

import by.shurik.preproject.task34.Server.mapper.UserMapper;
import by.shurik.preproject.task34.Server.model.User;
import by.shurik.preproject.task34.Server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminRestController {
    private UserService userService;
    private UserMapper userMapper;

    @Autowired
    public AdminRestController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

//    @PostMapping("/addUser")
//    public ResponseEntity<?> addUser(@RequestBody UserDto newDtoUser
//    ) {
//        if ("".equals(newDtoUser.getName()) ||
//                "".equals(newDtoUser.getPosition()) ||
//                "".equals(Integer.toString(newDtoUser.getAge())) ||
//                "".equals(newDtoUser.getEmail())) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        Optional<User> optionalUser = userService.addUser(userMapper.getUserFromDto(newDtoUser));
//        if (optionalUser.isPresent()) {
//            UserDto backUserDto = userMapper.getUserDtoFromUser(optionalUser.get());
//            return new ResponseEntity<>(backUserDto, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
//
//    @PutMapping("/update")
//    public ResponseEntity<?> updateUser(@RequestBody UserDto updateUserDto) {
//        Optional<User> optionalUser = userService.updateUser(userMapper.getUserFromDto(updateUserDto));
//        if (optionalUser.isPresent()) {
//            UserDto backUserDto = userMapper.getUserDtoFromUser(optionalUser.get());
//            return new ResponseEntity<>(backUserDto, HttpStatus.OK);
//        }
//        return new ResponseEntity<>((HttpStatus.BAD_REQUEST));
//    }

    @GetMapping("/allUsers")
    public List<User> getUsersList() {
        return userService.listUser();
    }

//    @DeleteMapping("/deleteUser/{id}")
//    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
//        userService.removeUser(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

}
