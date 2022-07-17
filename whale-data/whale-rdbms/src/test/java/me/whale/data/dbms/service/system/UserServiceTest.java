package me.whale.data.dbms.service.system;

import io.grpc.stub.StreamObserver;
import jakarta.annotation.Resource;
import me.whale.components.service.system.UserReply;
import me.whale.components.service.system.UserRequest;
import me.whale.data.dbms.BaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest extends BaseTest {
    @Resource
    private UserService userService;

//     transaction error
//    @Test
//    void add() {
//        UserRequest userRequest = UserRequest.newBuilder()
//                .setUserNo("0")
//                .setUserName("name")
//                .setGender("gender")
//                .setBirthday("1970-01-01")
//                .setPassword("*******")
//                .build();
//        userService.add(userRequest, new StreamObserver<>() {
//            @Override
//            public void onNext(UserReply value) {
//                log.info("ignore");
//            }
//
//            @Override
//            public void onError(Throwable t) {
//                log.info("error save user");
//            }
//
//            @Override
//            public void onCompleted() {
//                log.info("success save user");
//            }
//        });
//    }

    @Test
    void authenticate() {
    }
}