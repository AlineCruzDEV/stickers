package br.com.ada.users.user.model.mapper;

import br.com.ada.users.user.model.dto.UserCreationDTO;
import br.com.ada.users.user.model.dto.UserDTO;
import br.com.ada.users.user.model.dto.UserUpdateDTO;
import br.com.ada.users.user.model.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO parseDTO(User user);
    User parseEntity(UserDTO userDTO);
    User parseEntity(UserCreationDTO userDTO);
    User parseEntity(UserUpdateDTO userDTO);
    List<UserDTO> parseListDTO(List<User> users);

}
