package me.whale.data.dbms.repository.backend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
class BackendRepositoryTest {
    @Resource
    private UserRepository userRepository;

    @Test
    void test() {
        userRepository.findById(1L);
    }

}