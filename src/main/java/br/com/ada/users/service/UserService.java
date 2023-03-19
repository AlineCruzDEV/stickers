package br.com.ada.users.service;

import br.com.ada.users.model.dto.UserCreationDTO;
import br.com.ada.users.model.dto.UserDTO;
import br.com.ada.users.model.dto.UserUpdateDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> findAll();
    UserDTO findById(Long id);
    UserDTO create(UserCreationDTO entity);
    UserDTO edit(Long id, UserUpdateDTO entity);
    void delete(Long id);
}
