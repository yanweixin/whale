package me.whale.data.mongo;

import org.springframework.data.annotation.Id;

public abstract class IdEntity {
    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
