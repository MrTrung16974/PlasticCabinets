package com.example.plasticcabinets.repository;

import com.example.plasticcabinets.model.Functions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FunctionsRepository extends JpaRepository<Functions, String> {

}
