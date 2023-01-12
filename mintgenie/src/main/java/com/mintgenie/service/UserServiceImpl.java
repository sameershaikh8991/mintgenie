package com.mintgenie.service;

import com.mintgenie.dto.UserDTO;
import com.mintgenie.model.User;
import com.mintgenie.payload.ModelMapperPayload;
import com.mintgenie.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    @Autowired
    UserRepo userRepo;

    @Autowired
    private ModelMapperPayload modelMapperPayload;

    public UserDTO saveUser(UserDTO userDTO) {
        User user = this.modelMapperPayload.dtoToUser(userDTO);
        User savedUser = this.userRepo.save(user);
        return this.modelMapperPayload.userToDto(savedUser);
    }

    public UserDTO getById(int id) {
        User user = this.userRepo.findById(id).get();
        return this.modelMapperPayload.userToDto(user);
    }

}
