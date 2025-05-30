package com.inho.ward.user.service;

import com.inho.ward.user.domain.User;
import com.inho.ward.user.dto.GetUserDTO;
import com.inho.ward.user.dto.LoginDTO;

public interface UserService {
    LoginDTO login(LoginDTO loginDTO);
    GetUserDTO getUserById(Long Id);

    default GetUserDTO entityToDTO(User user) {
        return GetUserDTO.builder()
                .username(user.getUsername())
                .build();
    }
}
