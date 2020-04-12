package com.example.plasticcabinets.repository;

import com.example.plasticcabinets.model.Categorys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorysRepository extends JpaRepository<Categorys, Integer> {
}
