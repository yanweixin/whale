package me.whale.data.api.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import me.whale.data.api.validator.ValidEmail;
import me.whale.data.api.validator.ValidPhone;
import me.whale.data.api.validator.ValidUserLogin;

import java.io.Serializable;

@ValidUserLogin
public class UserLogin implements Serializable {
    private static final long serialVersionUID = 3060513246209703442L;
    @NotBlank
    @Size(min = 6, max = 127)
    private String userNo;
    @NotBlank
    @Size(min = 1, max = 255)
    private String userName;
    @ValidEmail
    private String email;
    @ValidPhone
    private String phone;
    @Size(min = 10, max = 255)
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
