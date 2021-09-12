package me.whale.data.dbms.type;

import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.descriptor.sql.VarbinaryTypeDescriptor;

import java.net.InetAddress;

public class InetAddressType extends AbstractSingleColumnStandardBasicType<InetAddress> {
    /**
     * Singleton access
     */
    public static final InetAddressType INSTANCE = new InetAddressType();

    public InetAddressType() {
        super(VarbinaryTypeDescriptor.INSTANCE, InetAddressJavaDescriptor.INSTANCE);
    }

    @Override
    public String getName() {
        return InetAddress.class.getSimpleName();
    }

    @Override
    protected boolean registerUnderJavaType() {
        return true;
    }
}
