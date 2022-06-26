package me.whale.data.dbms.type;

import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.AbstractTypeDescriptor;
import org.hibernate.type.descriptor.java.ImmutableMutabilityPlan;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressJavaDescriptor extends AbstractTypeDescriptor<InetAddress> {
    /**
     * Singleton access
     */
    public static final InetAddressJavaDescriptor INSTANCE = new InetAddressJavaDescriptor();

    @SuppressWarnings("unchecked")
    public InetAddressJavaDescriptor() {
        super(InetAddress.class, ImmutableMutabilityPlan.INSTANCE);
    }

    @Override
    public InetAddress fromString(String string) {
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <X> X unwrap(InetAddress value, Class<X> type, WrapperOptions options) {
        if (value == null) {
            return null;
        }
        if (byte[].class.isAssignableFrom(type)) {
            return (X) value.getAddress();
        }
        throw unknownUnwrap(type);
    }

    @Override
    public <X> InetAddress wrap(X value, WrapperOptions options) {
        if (value == null) {
            return null;
        }
        if (byte[].class.isInstance(value)) {
            try {
                return InetAddress.getByAddress((byte[]) value);
            } catch (UnknownHostException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        throw unknownWrap(value.getClass());
    }
}
