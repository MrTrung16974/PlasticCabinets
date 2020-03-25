package com.example.plasticcabinets.service;

import com.example.plasticcabinets.model.Roles;

import java.util.List;

public interface RoleService {
    public List<Roles> getAllRole();
    public Roles findByID(Integer roleID);
}
