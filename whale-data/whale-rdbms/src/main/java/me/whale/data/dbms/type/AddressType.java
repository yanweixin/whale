package me.whale.data.dbms.type;

import me.whale.data.api.model.Address;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Objects;

/**
 * @author weixin
 */
public class AddressType implements UserType {
    @Override
    public int[] sqlTypes() {
        return new int[]{Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER};
    }

    @Override
    public Class<Address> returnedClass() {
        return Address.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return Objects.equals(x, y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return x == null ? 0 : x.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException {
        String countryCode = rs.getString(names[0]);
        String provinceCode = rs.getString(names[1]);
        String cityCode = rs.getString(names[2]);
        String street = rs.getString(names[3]);
        Integer postalCode = rs.getInt(names[4]);
        if (rs.wasNull()) {
            postalCode = null;
        }
        Address address = new Address();
        address.setCountryCode(countryCode);
        address.setProvinceCode(provinceCode);
        address.setCityCode(cityCode);
        address.setStreet(street);
        address.setPostalCode(postalCode);
        return address;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {
        if (Objects.isNull(value)) {
            st.setNull(index, Types.VARCHAR);
            st.setNull(index + 1, Types.VARCHAR);
            st.setNull(index + 2, Types.VARCHAR);
            st.setNull(index + 3, Types.VARCHAR);
            st.setNull(index + 4, Types.INTEGER);
        } else {
            Address address = (Address) value;
            st.setString(index, address.getCountryCode());
            st.setString(index + 1, address.getProvinceCode());
            st.setString(index + 2, address.getCityCode());
            st.setString(index + 3, address.getStreet());
            if (Objects.isNull(address.getPostalCode())) {
                st.setNull(index + 4, Types.INTEGER);
            } else {
                st.setInt(index + 4, address.getPostalCode());
            }
        }
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return value;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable) deepCopy(value);
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return deepCopy(cached);
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return deepCopy(original);
    }
}
