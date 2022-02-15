package me.whale.data.dbms.domain.system.user;

import jakarta.validation.constraints.Size;
import me.whale.data.dbms.domain.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;

import java.io.Serial;
import java.time.LocalDate;

@Entity
public class TbUser extends BaseEntity {
    @Serial
    private static final long serialVersionUID = 5586653054373083223L;
    /**
     * @see TbAccount
     */
    private Long accountId;
    @Size(max = 1024)
    private String profile;
    private String gender;
    private LocalDate birthday;
    @NotBlank
    private String password;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
