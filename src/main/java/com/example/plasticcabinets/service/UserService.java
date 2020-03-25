package com.example.plasticcabinets.service;

import com.example.plasticcabinets.dto.UserDto;

public interface UserService {
    /**
     * Register a new user
     *
     * @param userDto
     * @return
     */
    UserDto addUser(UserDto userDto);

    /**
     * Search an existing user
     *
     * @param email
     * @return
     */
    UserDto findUserByEmail(String email);

    /**
     * Update profile of the user
     *
     * @param userDto
     * @return
     */
    UserDto updateUser(UserDto userDto);

    /**
     * Update password
     *
     * @param newPassword
     * @return
     */
    UserDto changePassword(UserDto userDto, String newPassword);
}

