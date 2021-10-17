package me.whale.data.dbms.domain;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.util.Date;
import java.util.Objects;
import java.util.stream.Stream;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class BaseEntity extends IdEntity {
    @Serial
    private static final long serialVersionUID = -79495259528154026L;

    @NotNull
    @Column(updatable = false)
    @CreatedBy
    private String createdBy;

    @NotNull
    @Column(updatable = false)
    @CreatedDate
    private Date createdAt;

    @NotNull
    @LastModifiedBy
    private String updatedBy;

    @NotNull
    @LastModifiedDate
    private Date updatedAt;

    @NotNull
    @Version
    private Long objectVersionNumber;

    @PrePersist
    public void preparePersist() {
        if (Stream.of(createdBy, createdAt, updatedBy, updatedAt).anyMatch(Objects::isNull)) {
            this.createdBy = "-1";
            this.updatedBy = "-1";
            this.createdAt = new Date();
            this.updatedAt = new Date();
            this.objectVersionNumber = 1L;
        }
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
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
