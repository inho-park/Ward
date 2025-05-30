package com.inho.ward.user.resource;

import com.inho.ward.user.domain.User;
import com.inho.ward.user.dto.GetUserDTO;
import com.inho.ward.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    @GetMapping(value = "/{id}")
    public ResponseEntity<GetUserDTO> getUser(@PathVariable(value = "id") Long id) {
        try {
            return new ResponseEntity<GetUserDTO>(userService.getUserById(id), HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
