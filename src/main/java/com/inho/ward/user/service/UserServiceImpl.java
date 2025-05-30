package com.inho.ward.user.service;

import com.inho.ward.user.domain.User;
import com.inho.ward.user.dto.GetUserDTO;
import com.inho.ward.user.dto.LoginDTO;
import com.inho.ward.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    @Override
    public LoginDTO login(LoginDTO loginDTO) {
        return null;
    }

    @Override
    public GetUserDTO getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return entityToDTO(userOptional.get());
        } else {
//            throw new UsernameNotFoundException("User not found in the DB");
            throw new RuntimeException("User not found in the DB");
        }
    }
}
