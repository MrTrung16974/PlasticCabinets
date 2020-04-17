package com.example.plasticcabinets.repository;

import com.example.plasticcabinets.model.CastProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CastProductRepository extends JpaRepository<CastProduct, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cast_product (user_id, status, description, the_number, product_id, id_img, create_by )" +
            " values (:userId, :status, :description, :theNumber, :productId, :idImg, :createBy)", nativeQuery = true)
    void saveCastProduct(@Param("userId") Integer userId, @Param("status") Integer status,
                                       @Param("description") String description, @Param("theNumber") Integer theNumber,  @Param("productId") Integer productId,
                                       @Param("idImg") Integer idImg, @Param("createBy") Integer createBy);

//    @Query(value = "select * from cast_product cast where cast.product_id = :productId")
//    public CastProduct findByCast(@Param("productId") Integer productId);
}
