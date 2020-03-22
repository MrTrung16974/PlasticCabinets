package com.example.plasticcabinets.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "product")
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Products  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "img_product")
    private String imgProduct;

    @Column(name = "new_price")
    private String newPrice;

    @Column(name = "old_price")
    private String oldPrice;

    @Column(name = "promotional")
    private Integer promotional;

    @Column(name = "star")
    private Integer star;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "id_img")
    private Integer idImg;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date created_date;

    @Column(name = "modifieddate")
    private Date modifieddate;

    @Column(name = "create_by")
    private Integer createBy;

    public Products(String name, String imgProduct, String newPrice, String oldPrice, Integer promotional, Integer star, Integer userId, Integer idImg, Date created_date, Date modifieddate, Integer createBy) {
        this.name = name;
        this.imgProduct = imgProduct;
        this.newPrice = newPrice;
        this.oldPrice = oldPrice;
        this.promotional = promotional;
        this.star = star;
        this.userId = userId;
        this.idImg = idImg;
        this.created_date = created_date;
        this.modifieddate = modifieddate;
        this.createBy = createBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgProduct() {
        return imgProduct;
    }

    public void setImgProduct(String imgProduct) {
        this.imgProduct = imgProduct;
    }

    public String getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(String newPrice) {
        this.newPrice = newPrice;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public Integer getPromotional() {
        return promotional;
    }

    public void setPromotional(Integer promotional) {
        this.promotional = promotional;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getIdImg() {
        return idImg;
    }

    public void setIdImg(Integer idImg) {
        this.idImg = idImg;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Date getModifieddate() {
        return modifieddate;
    }

    public void setModifieddate(Date modifieddate) {
        this.modifieddate = modifieddate;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }
}
