package com.example.plasticcabinets.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "functions")
@Data
@Accessors(chain = true)
@Entity
public class Functions {
    @Id
    @Column(name = "function_code")
    private String functionsCode;

    @Column(name = "description")
    private String description;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date created_date;

    @Column(name = "modifieddate")
    private Date modifieddate;

    @Column(name = "create_by")
    private Integer createBy;

    public Functions() {

    }

    public Functions(String functionsCode, String description, Date created_date, Date modifieddate, Integer createBy) {
        this.functionsCode = functionsCode;
        this.description = description;
        this.created_date = created_date;
        this.modifieddate = modifieddate;
        this.createBy = createBy;
    }

    public String getFunctionsCode() {
        return functionsCode;
    }

    public void setFunctionsCode(String functionsCode) {
        this.functionsCode = functionsCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

