package com.example.plasticcabinets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleFunctionRepository extends JpaRepository<RolesRepository, Integer> {
}
