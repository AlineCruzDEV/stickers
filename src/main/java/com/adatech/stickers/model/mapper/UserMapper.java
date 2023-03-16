package com.adatech.stickers.model.mapper;

import com.adatech.stickers.model.dto.UserDTO;
import com.adatech.stickers.model.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO parseDTO(User user);
    User parseEntity(UserDTO userDTO);

    List<UserDTO> parseListDTO(List<User> users);

}
