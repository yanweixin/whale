package me.whale.data.dbms.domain.system.user;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import me.whale.common.enums.personal.AccountType;
import me.whale.data.dbms.domain.BaseEntity;

import java.io.Serial;

@Entity
public class TbAccount extends BaseEntity {
    @Serial
    private static final long serialVersionUID = -7490038118881327156L;
    @NotBlank
    @Size(min = 8, max = 32)
    private String accountNo;
    @NotBlank
    @Size(max = 255)
    private String accountName;
    @NotBlank
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
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

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
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
