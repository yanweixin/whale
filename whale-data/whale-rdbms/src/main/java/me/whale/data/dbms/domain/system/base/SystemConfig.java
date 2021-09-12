package me.whale.data.dbms.domain.system.base;

import me.whale.common.enums.system.AppModule;
import me.whale.data.dbms.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class SystemConfig extends BaseEntity {
    private static final long serialVersionUID = 2748631171007919333L;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AppModule appModule;

    private String businessType;

    @NotBlank
    private String key;

    @NotBlank
    private String value;

    public AppModule getAppModule() {
        return appModule;
    }

    public void setAppModule(AppModule appModule) {
        this.appModule = appModule;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
