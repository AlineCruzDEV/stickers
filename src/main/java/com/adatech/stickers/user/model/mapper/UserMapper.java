package com.adatech.stickers.user.model.mapper;

import com.adatech.stickers.user.model.dto.UserDTO;
import com.adatech.stickers.user.model.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO parseDTO(User user);
    User parseEntity(UserDTO userDTO);

    List<UserDTO> parseListDTO(List<User> users);

}
