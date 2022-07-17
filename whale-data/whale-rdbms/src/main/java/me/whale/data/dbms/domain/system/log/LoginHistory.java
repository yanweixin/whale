package me.whale.data.dbms.domain.system.log;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import me.whale.common.enums.personal.LoginMethod;
import me.whale.data.dbms.domain.IdEntity;
import me.whale.data.dbms.type.InetAddressJavaType;
import org.hibernate.annotations.JavaType;

import java.net.InetAddress;
import java.util.Date;


/**
 * @author weixin
 */
@Entity
public class LoginHistory extends IdEntity {
    private static final long serialVersionUID = 128441963981287741L;
    @NotNull
    private Long userId;
    @NotNull
    private String identity;
    @NotNull
    private LoginMethod loginMethod;
    @JavaType(InetAddressJavaType.class)
    private InetAddress address;
    @NotNull
    private Date loginDate;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public LoginMethod getLoginMethod() {
        return loginMethod;
    }

    public void setLoginMethod(LoginMethod loginMethod) {
        this.loginMethod = loginMethod;
    }

    public InetAddress getAddress() {
        return address;
    }

    public void setAddress(InetAddress address) {
        this.address = address;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
}
