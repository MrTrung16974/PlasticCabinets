package com.example.plasticcabinets.service.impl;

import com.example.plasticcabinets.dto.UserDto;
import com.example.plasticcabinets.exception.BaseException;
import com.example.plasticcabinets.exception.EntityType;
import com.example.plasticcabinets.exception.ExceptionType;
import com.example.plasticcabinets.model.Users;
import com.example.plasticcabinets.repository.RolesRepository;
import com.example.plasticcabinets.repository.UserRepository;
import com.example.plasticcabinets.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.plasticcabinets.exception.ExceptionType.ENTITY_NOT_FOUND;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RolesRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto addUser(UserDto userDto) {
        Users user = userRepository.findByEmail(userDto.getEmail());
        if (user == null) {
            user = new Users()
                    .setEmail(userDto.getEmail())
                    .setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()))
                    .setRoleId(userDto.getRoleId());

            return modelMapper.map(userRepository.save(user), UserDto.class);
        }
        throw exception(EntityType.USER, ExceptionType.DUPLICATE_ENTITY, userDto.getEmail());
    }

    /**
     * Search an existing user
     *
     * @param email
     * @return
     */
    public UserDto findUserByEmail(String email) {
        Optional<Users> user = Optional.ofNullable(userRepository.findByEmail(email));
        if (user.isPresent()) {
            return modelMapper.map(user.get(), UserDto.class);
        }
        throw exception(EntityType.USER, ENTITY_NOT_FOUND, email);
    }

    /**
     * Update User Profile
     *
     * @param userDto
     * @return
     */
    @Override
    public UserDto updateUser(UserDto userDto) {
        Optional<Users> user = Optional.ofNullable(userRepository.findByEmail(userDto.getEmail()));
        if (user.isPresent()) {
            Users userModel = user.get();
            userModel.setEmail(userDto.getEmail());
            return modelMapper.map(userRepository.save(userModel),UserDto.class);
        }
        throw exception(EntityType.USER, ENTITY_NOT_FOUND, userDto.getEmail());
    }

    /**
     * Change Password
     *
     * @param userDto
     * @param newPassword
     * @return
     */
    @Override
    public UserDto changePassword(UserDto userDto, String newPassword) {
        Optional<Users> user = Optional.ofNullable(userRepository.findByEmail(userDto.getEmail()));
        if (user.isPresent()) {
            Users userModel = user.get();
            userModel.setPassword(bCryptPasswordEncoder.encode(newPassword));
            return modelMapper.map(userRepository.save(userModel),UserDto.class);
        }
        throw exception(EntityType.USER, ENTITY_NOT_FOUND, userDto.getEmail());
    }

    /**
     * Returns a new RuntimeException
     *
     * @param entityType
     * @param exceptionType
     * @param args
     * @return
     */
    private RuntimeException exception(EntityType entityType, ExceptionType exceptionType, String... args) {
        return BaseException.throwException(entityType, exceptionType, args);
    }
}
