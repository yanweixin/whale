package me.whale.data.dbms.repository.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostRepositoryTest {
    @Resource
    private PostRepository postRepository;

    @Test
    void test() {
        postRepository.findById(0L);
    }

}