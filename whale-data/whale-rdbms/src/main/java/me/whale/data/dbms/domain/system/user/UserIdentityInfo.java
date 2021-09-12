package me.whale.data.dbms.domain.system.user;

import me.whale.common.enums.general.ValidStatus;
import me.whale.common.enums.personal.IdentityType;
import me.whale.data.dbms.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class UserIdentityInfo extends BaseEntity {
    private static final long serialVersionUID = -8497103552742470946L;
    private Long userId;
    @Enumerated(EnumType.STRING)
    private IdentityType identityType;
    private String identity;
    private ValidStatus validStatus;
    private boolean useLogin;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public IdentityType getIdentityType() {
        return identityType;
    }

    public void setIdentityType(IdentityType identityType) {
        this.identityType = identityType;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public ValidStatus getValidStatus() {
        return validStatus;
    }

    public void setValidStatus(ValidStatus validStatus) {
        this.validStatus = validStatus;
    }

    public boolean isUseLogin() {
        return useLogin;
    }

    public void setUseLogin(boolean useLogin) {
        this.useLogin = useLogin;
    }
}
