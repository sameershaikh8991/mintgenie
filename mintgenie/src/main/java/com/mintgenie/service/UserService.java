package com.mintgenie.service;

import com.mintgenie.dto.UserDTO;

public interface UserService {
    UserDTO saveUser(UserDTO userDTO);

    UserDTO getById(int id);
}
