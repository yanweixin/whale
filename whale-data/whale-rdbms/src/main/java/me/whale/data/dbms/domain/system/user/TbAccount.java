package me.whale.data.dbms.domain.system.user;

import me.whale.data.dbms.domain.BaseEntity;

import java.io.Serial;

public class TbAccount extends BaseEntity {
    @Serial
    private static final long serialVersionUID = -7490038118881327156L;
    private String accountNo;
    private String accountName;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean enabled;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
