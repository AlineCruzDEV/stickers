package com.adatech.stickers.controller;

import com.adatech.stickers.model.dto.UserDTO;
import com.adatech.stickers.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@Slf4j
public class UserController extends BaseController<UserDTO, UserService>{
    public UserController(UserService service) {
        super(service);
    }

}
