package com.example.plasticcabinets.repository;

import com.example.plasticcabinets.model.RoleFunction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleFunctionRepository extends JpaRepository<RoleFunction, Integer> {
}
