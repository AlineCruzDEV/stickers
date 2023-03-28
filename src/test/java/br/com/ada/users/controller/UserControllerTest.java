package br.com.ada.users.controller;

import br.com.ada.users.model.dto.UserCreationDTO;
import br.com.ada.users.model.dto.UserDTO;
import br.com.ada.users.model.dto.UserUpdateDTO;
import br.com.ada.users.model.mapper.PhoneMapper;
import br.com.ada.users.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    private UserServiceImpl userService;

    private PhoneMapper phoneMapper;

    @InjectMocks
    private UserController userController;

    @Test
    public void testFindAll() {
        //arrange
        List<UserDTO> userDTOS = new ArrayList<>();
        Mockito.when(userService.findAll()).thenReturn(userDTOS);
        //act
        ResponseEntity<List<UserDTO>> response = userController.findAll();
        //assert
        Mockito.verify(userService).findAll();
        Assert.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        //Assert.assertEquals(userDTOS, response.getBody());
    }

    @Test
    public void findById() {
        //arrange
        UserDTO userDTO = new UserDTO();
        Mockito.when(userService.findById(anyString())).thenReturn(userDTO);
        //act
        ResponseEntity<UserDTO> response = userController.findById("1");
        //assert
        Mockito.verify(userService).findById("1");
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void create() {
        //arrange
        UserDTO userDTO = new UserDTO();
        UserCreationDTO userCreationDTO = new UserCreationDTO();
        Mockito.when(userService.create(userCreationDTO)).thenReturn(userDTO);
        //act
        ResponseEntity<UserDTO> response = userController.create(userCreationDTO);
        //assert
        Mockito.verify(userService).create(userCreationDTO);
        Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void edit() {
        //arrange
        UserDTO userDTO = new UserDTO();
        UserUpdateDTO userUpdateDTO = new UserUpdateDTO();
        Mockito.when(userService.edit("id", userUpdateDTO)).thenReturn(userDTO);
        //act
        ResponseEntity<UserDTO> response = userController.edit("id", userUpdateDTO);
        //assert
        Mockito.verify(userService).edit("id", userUpdateDTO);
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void delete() {
        //arrange
        //act
        ResponseEntity<Object> response = userController.delete("id");
        //assert
        Mockito.verify(userService).delete("id");
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

//    @Test
//    public void findPhones() {
//        //arrange
//        List<Phone> phones = new ArrayList<>();
//        List<PhoneDTO> phonesDto = new ArrayList<>();
//        Mockito.when(phoneMapper.parseListDTO(phones)).thenReturn(phonesDto);
//        Mockito.when(userService.findPhones("id")).thenReturn(phones);
//        //act
//        ResponseEntity<List<PhoneDTO>> response = (userController.findPhones("id"));
//        //assert
//        Mockito.verify(userService).findPhones("id");
//        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
//    }
}

