package me.whale.data.dbms.domain.system.user;

import me.whale.common.annotation.MultiLangText;
import me.whale.data.dbms.domain.BaseEntity;

import javax.persistence.Entity;
import java.io.Serial;

@Entity
public class TbRole extends BaseEntity {
    @Serial
    private static final long serialVersionUID = -1551224225590725701L;
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
