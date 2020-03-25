package com.example.plasticcabinets.service.impl;

import com.example.plasticcabinets.dto.UserDto;
import com.example.plasticcabinets.exception.BaseException;
import com.example.plasticcabinets.exception.EntityType;
import com.example.plasticcabinets.exception.ExceptionType;
import com.example.plasticcabinets.model.Roles;
import com.example.plasticcabinets.repository.RolesRepository;
import com.example.plasticcabinets.service.RoleService;
import com.example.plasticcabinets.util.Constant;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    final static Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    private static final Gson gson = new Gson();
    @Autowired
    UserServiceImpl userService;

    @Autowired
    private RoleServiceImpl roleService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        LOGGER.debug("Find User by Name: {}", userName);
        UserDto user = userService.findUserByEmail(userName);
        if (user == null) {
            LOGGER.debug("{} not found!", userName);
            throw new UsernameNotFoundException("Tài khoản :" + userName + " không tồn tại !");
        }
        Integer roleID = user.getRoleId();
        List<GrantedAuthority> grantList = new ArrayList<>();
        if (roleID != null) {
            roleService.findByID(roleID).getFunctions().stream().map((function) -> new SimpleGrantedAuthority(function.getFunctionCode())).forEachOrdered((authority) -> {
                grantList.add(authority);
            });
            if(roleID.equals(Constant.ROLE_SUPER_ID)){
                grantList.add(new SimpleGrantedAuthority(roleService.findByID(roleID).getRoleName()));
            }
        }
        LOGGER.debug("{}: grantList: {}", userName, gson.toJson(grantList));
        UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantList);
        return userDetails;
    }
}