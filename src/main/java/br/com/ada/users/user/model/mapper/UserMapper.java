package br.com.ada.users.user.model.mapper;

import br.com.ada.users.user.model.dto.UserDTO;
import br.com.ada.users.user.model.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO parseDTO(User user);
    User parseEntity(UserDTO userDTO);

    List<UserDTO> parseListDTO(List<User> users);

}
