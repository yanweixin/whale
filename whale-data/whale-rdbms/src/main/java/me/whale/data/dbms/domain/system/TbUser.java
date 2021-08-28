package me.whale.data.dbms.domain.system;

import me.whale.data.dbms.domain.BaseEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class TbUser extends BaseEntity {
    private static final long serialVersionUID = 5586653054373083223L;
    @NotBlank
    private String userNo;
    @NotBlank
    private String userName;
    private String gender;
    private Date birthday;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
