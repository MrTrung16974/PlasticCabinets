package com.example.plasticcabinets.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "image_product")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_date", "modifieddate"}, allowGetters = true)
@Entity
public class ImageProduct implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "img_product_1")
    private String imgProduct1;

    @Column(name = "img_product_2")
    private String imgProduct2;

    @Column(name = "img_product_3")
    private String imgProduct3;

    @Column(name = "img_product_4")
    private String imgProduct4;

    @Column(name = "img_product_5")
    private String imgProduct5;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date created_date;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date modifieddate;

    @Column(name = "create_by")
    private Integer createBy;

    public ImageProduct() {

    }

    public ImageProduct(String imgProduct1, String imgProduct2, String imgProduct3, String imgProduct4, String imgProduct5, Date created_date, Date modifieddate, Integer createBy) {
        this.imgProduct1 = imgProduct1;
        this.imgProduct2 = imgProduct2;
        this.imgProduct3 = imgProduct3;
        this.imgProduct4 = imgProduct4;
        this.imgProduct5 = imgProduct5;
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

    public String getImgProduct1() {
        return imgProduct1;
    }

    public void setImgProduct1(String imgProduct1) {
        this.imgProduct1 = imgProduct1;
    }

    public String getImgProduct2() {
        return imgProduct2;
    }

    public void setImgProduct2(String imgProduct2) {
        this.imgProduct2 = imgProduct2;
    }

    public String getImgProduct3() {
        return imgProduct3;
    }

    public void setImgProduct3(String imgProduct3) {
        this.imgProduct3 = imgProduct3;
    }

    public String getImgProduct4() {
        return imgProduct4;
    }

    public void setImgProduct4(String imgProduct4) {
        this.imgProduct4 = imgProduct4;
    }

    public String getImgProduct5() {
        return imgProduct5;
    }

    public void setImgProduct5(String imgProduct5) {
        this.imgProduct5 = imgProduct5;
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
