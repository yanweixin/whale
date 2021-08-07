package me.whale.data.dbms.domain.system;

import me.whale.data.api.validator.ValidEmail;
import me.whale.data.api.validator.ValidPhone;
import me.whale.data.dbms.domain.BaseEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
public class TbUser extends BaseEntity {
    private static final long serialVersionUID = 5586653054373083223L;
    @NotBlank
    private String userNo;
    @NotBlank
    private String userName;
    private String gender;
    private LocalDate birthday;
    @ValidPhone
    private String phone;
    @ValidEmail
    private String email;
    @NotBlank
    private String password;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
