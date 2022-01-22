package me.whale.data.dbms.domain.system.location;

import me.whale.data.api.model.Address;
import me.whale.data.dbms.domain.BaseEntity;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

/**
 * @author weixin
 */
@Entity
public class TbAddress extends BaseEntity {
    private static final long serialVersionUID = 1978418630089694960L;
    @NotNull
    private Long userId;
    /**
     * full name of address owner
     */
    private String fullName;
    /**
     * phone number of address owner
     */
    private String phone;
    @Type(type = "me.whale.data.dbms.type.AddressType")
    @Columns(columns = {@Column(name = "countryCode"), @Column(name = "provinceCode"),
            @Column(name = "cityCode"), @Column(name = "street"), @Column(name = "postalCode")})
    private Address address;
    private boolean isValid;
    private boolean isDefault;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }
}
