package me.whale.data.dbms.type;

import me.whale.data.api.model.Address;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.metamodel.spi.ValueAccess;

public class AddressType extends CustomCompositeUserType<Address> {

    @Override
    public Object getPropertyValue(Address component, int property) throws HibernateException {
        switch (property) {
            case 0:
                return component.getCityCode();
            case 1:
                return component.getCountryCode();
            case 2:
                return component.getPostalCode();
            case 3:
                return component.getProvinceCode();
            case 4:
                return component.getStreet();
            default:
                return null;
        }
    }

    @Override
    public Address instantiate(ValueAccess values, SessionFactoryImplementor sessionFactory) {
        String cityCode = values.getValue(0, String.class);
        String countryCode = values.getValue(1, String.class);
        Integer postalCode = values.getValue(2, Integer.class);
        String provinceCode = values.getValue(3, String.class);
        String street = values.getValue(4, String.class);
        Address address = new Address();
        address.setCountryCode(countryCode);
        address.setProvinceCode(provinceCode);
        address.setCityCode(cityCode);
        address.setStreet(street);
        address.setPostalCode(postalCode);
        return address;
    }

    @Override
    public Class<?> embeddable() {
        return AddressTypeEmbeddable.class;
    }

    @Override
    public Class<Address> returnedClass() {
        return Address.class;
    }

    public static class AddressTypeEmbeddable {
        private String countryCode;
        private String provinceCode;
        private String cityCode;
        private String street;
        private Integer postalCode;
    }
}
