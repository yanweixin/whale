package me.whale.data.dbms.domain.system.user;

import me.whale.common.annotation.MultiLangText;
import me.whale.data.dbms.domain.BaseEntity;

import jakarta.persistence.Entity;
import java.io.Serial;

@Entity
public class TbPrivilege extends BaseEntity {
    @Serial
    private static final long serialVersionUID = -7612374079542775913L;
    @MultiLangText
    private String name;
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
