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
    @Modifying
    @Transactional
    @Query(value = "UPDATE products p SET p.name = :name, p.description = :description," +
            "p.img_product = :imageProduct, p.new_price = :newPrice, p.old_price = :oldPrice," +
            " p.promotion = :promotion, p.star = :star WHERE p.id = :id", nativeQuery = true)
    void updateProduct(@Param("id") int id, @Param("name") String name, @Param("description")
            String description,@Param("imageProduct") String imageProduct , @Param("newPrice")
            String newPrice, @Param("oldPrice") String oldPrice,  @Param("promotion") int promotion,
                       @Param("star") int star);

    //    @Modifying
    //    @Transactional
    @Query(value = "SELECT * from products p WHERE p.name LIKE %:name%", nativeQuery = true)
    List<Products> searchProduct(@Param("name") String name);
}
