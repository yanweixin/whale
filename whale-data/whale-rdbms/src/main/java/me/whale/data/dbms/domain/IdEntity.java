package me.whale.data.dbms.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.io.Serial;
import java.io.Serializable;

@MappedSuperclass
public abstract class IdEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1149460465677297983L;

    @GeneratedValue
    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
