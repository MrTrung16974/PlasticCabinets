package com.example.plasticcabinets.repository;

import com.example.plasticcabinets.model.LoveProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoveProductRepository extends JpaRepository<LoveProduct, Integer> {
}
