package com.example.plasticcabinets.repository;

import com.example.plasticcabinets.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {
    //    @Modifying
    //    @Transactional
    @Query(value = "SELECT * from products p WHERE p.name LIKE %:name%", nativeQuery = true)
    List<Products> searchProduct(@Param("name") String name);

    @Query(value = "SELECT * from products p WHERE p.star >= :star", nativeQuery = true)
    List<Products> goodProduct(@Param("star") Integer star);

    @Query(value = "SELECT p.id, p.name, p.description, p.img_product, p.new_price, p.old_price, " +
            "p.promotion, p.star, p.user_id, p.category_id, p.id_img, p.created_date," +
            "p.modified_date, p.create_by from products p,cast_product ca   WHERE p.id = ca.product_id;", nativeQuery = true)
    List<Products> getCastProduct();
}
