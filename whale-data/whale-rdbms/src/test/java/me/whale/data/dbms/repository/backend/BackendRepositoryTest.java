package me.whale.data.dbms.repository.backend;

import me.whale.data.dbms.domain.system.user.TbUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.annotation.Resource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BackendRepositoryTest {
    @Resource
    private UserRepository userRepository;

    @Test
    void testSaveUser() {
        TbUser tbUser = new TbUser();
        tbUser.setId(1L);
        tbUser.setAccountId(0L);
        tbUser.setProfile("sample profile");
        tbUser.setGender("male");
        tbUser.setBirthday(LocalDate.now());
        tbUser.setPassword("********");
        userRepository.save(tbUser);
        TbUser findOne = userRepository.findById(1L).orElse(null);
        assertNotNull(findOne);
        assertEquals("male", findOne.getGender());
    }

}