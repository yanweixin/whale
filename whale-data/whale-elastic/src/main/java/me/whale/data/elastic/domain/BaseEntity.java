package me.whale.data.elastic.domain;

import java.io.Serializable;
import java.util.Date;

public abstract class BaseEntity implements Serializable {
    private static final long serialVersionUID = -6356193698399207192L;

    /**
     * elastic id
     */
    private String id;

    /**
     * the user id of creator
     */
    private Long createdBy;

    private Date createdAt;

    private Long updatedBy;

    private Date updatedAt;

    private Long objectVersionNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getObjectVersionNumber() {
        return objectVersionNumber;
    }

    public void setObjectVersionNumber(Long objectVersionNumber) {
        this.objectVersionNumber = objectVersionNumber;
    }
}
