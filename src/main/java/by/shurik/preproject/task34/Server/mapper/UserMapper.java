package by.shurik.preproject.task34.Server.mapper;


import by.shurik.preproject.task34.Server.dto.UserDto;
import by.shurik.preproject.task34.Server.model.User;

public interface UserMapper {
    User getUserFromDto(UserDto userDto);

    UserDto getUserDtoFromUser(User user);
}
