package com.driva.drivaapi.service.impl;

import com.driva.drivaapi.mapper.UserMapper;
import com.driva.drivaapi.mapper.dto.UserDTO;
import com.driva.drivaapi.model.user.UserRole;
import com.driva.drivaapi.repository.UserRepository;
import com.driva.drivaapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserDTO> findAll() {
        return userMapper.entitiesToUserDTOs(userRepository.findAll());


    }

    @Override
    public List<UserDTO> findAllByRole(UserRole role) {
        return userMapper.entitiesToUserDTOs(userRepository.findAllByRoles_name(role));
    }
}
