package br.com.ada.users.user.service;


import br.com.ada.users.user.model.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> findAll();
    UserDTO findById(Long id);
    UserDTO create(UserDTO entity);
    UserDTO edit(Long id, UserDTO entity);
    void delete(Long id);
}
