package com.adatech.stickers.user.controller;

import com.adatech.stickers.user.model.dto.UserDTO;
import com.adatech.stickers.user.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@Slf4j
public class UserController {

    protected final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> result = service.findAll();
        if(result.size() == 0) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(result);
        } else {
            return ResponseEntity.ok(result);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable("id") Long id) {
        try {

            return ResponseEntity.ok(service.findById(id));

        } catch (EntityNotFoundException ex) {

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception ex) {

            log.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody @Valid UserDTO entidade) {
        try {

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(service.create(entidade));

        } catch (Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> edit(@PathVariable("id") Long id,
                                        @RequestBody @Valid UserDTO entidade) {
        try {

            return ResponseEntity.ok(service.edit(id, entidade));

        } catch (EntityNotFoundException ex) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception ex) {

            log.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        try {
            service.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();

        } catch (EntityNotFoundException ex) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception ex) {

            log.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
