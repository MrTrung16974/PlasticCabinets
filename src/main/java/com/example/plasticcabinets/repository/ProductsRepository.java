package com.example.plasticcabinets.repository;

import com.example.plasticcabinets.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {
    //    @Modifying
    //    @Transactional
    @Query(value = "SELECT * from products p WHERE p.name LIKE %:name%", nativeQuery = true)
    List<Products> searchProduct(@Param("name") String name);
}
