package me.whale.data.api.support;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.util.Objects;

public class GenericEntityListener {

    @PrePersist
    public void touchForCreate(Object target) {
        Objects.requireNonNull(target, "Entity must not be null!");
    }

    @PreUpdate
    public void touchForUpdate(Object target) {
        Objects.requireNonNull(target, "Entity must not be null!");
    }
}
