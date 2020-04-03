package com.example.plasticcabinets.repository;

import com.example.plasticcabinets.model.Functions;
import com.example.plasticcabinets.model.ImageProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ImageProductRepository extends JpaRepository<ImageProduct, Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE image_product p SET p.img_product_1 = :imgProduct1, p.img_product_2 = :imgProduct2," +
            "p.img_product_3 = :imgProduct3, p.img_product_4 = :imgProduct4, p.img_product_5 = :imgProduct5," +
            "WHERE p.id = :id", nativeQuery = true)
    void updateImageProduct(@Param("id") int id, @Param("imgProduct1") String imgProduct1, @Param("imgProduct2")
            String imgProduct2, @Param("imgProduct3") String imgProduct3 , @Param("imgProduct4")
                               String imgProduct4, @Param("imgProduct5") String imgProduct5);

}
