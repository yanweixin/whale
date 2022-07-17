package me.whale.data.dbms.repository.backend;


import jakarta.annotation.Resource;
import me.whale.common.enums.personal.LoginMethod;
import me.whale.data.api.model.Address;
import me.whale.data.dbms.BaseTest;
import me.whale.data.dbms.config.DataConfiguration;
import me.whale.data.dbms.domain.system.location.TbAddress;
import me.whale.data.dbms.domain.system.log.LoginHistory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.TestDatabaseAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManagerAutoConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.net.InetAddress;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Transactional("backendTransactionManager")
@ImportAutoConfiguration(classes = {DataConfiguration.class,},
        exclude = {TestEntityManagerAutoConfiguration.class, TestDatabaseAutoConfiguration.class})
class CustomHibernateTypeRepositoryTest extends BaseTest {
    @Resource
    private AddressRepository addressRepository;
    @Resource
    private LoginHistoryRepository loginHistoryRepository;

    @Test
    void compositeTypeTest() {
        TbAddress tbAddress = new TbAddress();
        tbAddress.setUserId(1L);
        tbAddress.setFullName("X");
        tbAddress.setPhone("110");
        Address address = new Address();
        address.setCountryCode("China");
        address.setProvinceCode("Beijing");
        address.setCityCode("Beijing");
        address.setStreet("Haidian");
        address.setPostalCode(100000);
        tbAddress.setAddress(address);
        TbAddress result = addressRepository.save(tbAddress);
        assertNotNull(result);
        TbAddress findOne = addressRepository.getReferenceById(result.getId());
        assertNotNull(findOne);
    }

    @Test
    void javaTypeTest() {
        LoginHistory loginHistory = new LoginHistory();
        loginHistory.setId(1L);
        loginHistory.setUserId(1L);
        loginHistory.setIdentity("OFFICIAL");
        loginHistory.setLoginMethod(LoginMethod.PASSWORD);
        loginHistory.setAddress(InetAddress.getLoopbackAddress());
        loginHistory.setLoginDate(new Date());
        LoginHistory result = loginHistoryRepository.save(loginHistory);
        assertNotNull(result);
        LoginHistory findOne = loginHistoryRepository.getReferenceById(result.getId());
        assertNotNull(findOne);
    }

}