package com.mintgenie.service;

import com.mintgenie.dto.UserDTO;
import com.mintgenie.model.User;
import com.mintgenie.payload.ModelMapperPayload;
import com.mintgenie.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    private ModelMapperPayload modelMapperPayload;

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        User user = this.modelMapperPayload.dtoToUser(userDTO);
        User savedUser = this.userRepo.save(user);
        return this.modelMapperPayload.userToDto(savedUser);
    }

    @Override
    public UserDTO getById(int id) {
        User user = this.userRepo.findById(id).get();
        return this.modelMapperPayload.userToDto(user);
    }

}
