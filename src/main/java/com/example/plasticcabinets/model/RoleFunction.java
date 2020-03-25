package com.example.plasticcabinets.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "role_function")
public class RoleFunction {
    @Id
    @GenericGenerator(name = "native_generator", strategy = "native")
    @GeneratedValue(generator = "native_generator")
    @Column(name = "id")
    private Integer id;

    @Column(name = "function_id")
    private String functionId;

    @Column(name = "role_id")
    private Integer roleId;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date created_date;

    @Column(name = "modifieddate")
    private Date modifieddate;

    @Column(name = "create_by")
    private Integer createBy;

    public RoleFunction(String functionId, Integer roleId, Date created_date, Date modifieddate, Integer createBy) {
        this.functionId = functionId;
        this.roleId = roleId;
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

    public String getFunctionId() {
        return functionId;
    }

    public void setFunctionId(String functionId) {
        this.functionId = functionId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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
