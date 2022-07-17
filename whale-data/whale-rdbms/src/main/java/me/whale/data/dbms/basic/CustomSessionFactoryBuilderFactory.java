package me.whale.data.dbms.basic;

import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.boot.spi.SessionFactoryBuilderFactory;
import org.hibernate.boot.spi.SessionFactoryBuilderImplementor;

public class CustomSessionFactoryBuilderFactory implements SessionFactoryBuilderFactory {
    @Override
    public SessionFactoryBuilder getSessionFactoryBuilder(MetadataImplementor metadata, SessionFactoryBuilderImplementor defaultBuilder) {
        System.out.println("Custom type register! ");
        return defaultBuilder;
    }
}
