package me.whale.data.dbms.domain.system.user;

import me.whale.data.dbms.domain.BaseEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
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
    @Deprecated
    @NotBlank
    private String userNo;
    @Deprecated
    @NotBlank
    private String userName;
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

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
