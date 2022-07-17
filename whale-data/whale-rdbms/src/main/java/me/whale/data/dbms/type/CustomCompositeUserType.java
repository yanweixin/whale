package me.whale.data.dbms.type;

import org.hibernate.usertype.CompositeUserType;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author weixin
 */
public abstract class CustomCompositeUserType<T> implements CompositeUserType<T> {

    @Override
    public boolean equals(T x, T y) {
        return Objects.equals(x, y);
    }

    @Override
    public int hashCode(T x) {
        return x == null ? 0 : x.hashCode();
    }

    @Override
    public T deepCopy(T value) {
        return value;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(T value) {
        return (Serializable) deepCopy(value);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T assemble(Serializable cached, Object owner) {
        return deepCopy((T) cached);
    }

    @Override
    public T replace(T original, T target, Object owner) {
        return deepCopy(original);
    }
}
