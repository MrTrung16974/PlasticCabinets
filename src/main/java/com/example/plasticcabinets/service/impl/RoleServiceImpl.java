package com.example.plasticcabinets.service.impl;

import com.example.plasticcabinets.exception.BaseException;
import com.example.plasticcabinets.exception.EntityType;
import com.example.plasticcabinets.exception.ExceptionType;
import com.example.plasticcabinets.model.Roles;
import com.example.plasticcabinets.repository.RolesRepository;
import com.example.plasticcabinets.service.RoleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl  implements RoleService {

    private static final Logger LOGGER = LogManager.getLogger(RoleService.class);

    @Autowired
    RolesRepository roleRepository;

    @Override
    public List<Roles> getAllRole() {
        return roleRepository.findAll();
    }

    @Override
    public Roles findByID(Integer roleID) {
        return roleRepository.findById(roleID).orElseThrow(
                () -> BaseException.throwException(EntityType.ROLE, ExceptionType.ENTITY_NOT_FOUND, roleID + ""));
    }
}
