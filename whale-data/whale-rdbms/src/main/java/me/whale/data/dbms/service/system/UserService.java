package me.whale.data.dbms.service.system;

import io.grpc.stub.StreamObserver;
import me.whale.components.common.HttpReply;
import me.whale.components.rpc.annotation.GrpcService;
import me.whale.components.service.system.UserApiGrpc;
import me.whale.components.service.system.UserReply;
import me.whale.components.service.system.UserRequest;
import me.whale.data.dbms.domain.system.user.TbUser;
import me.whale.data.dbms.repository.backend.UserRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@GrpcService
@Component
public class UserService extends UserApiGrpc.UserApiImplBase {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void add(UserRequest request, StreamObserver<UserReply> responseObserver) {
        var httpReplyBuilder = HttpReply.newBuilder().setSuccess(false).setCode(1);
        Optional<TbUser> tbUserOptional = userRepository.findByUserNo(request.getUserNo());
        if (tbUserOptional.isPresent()) {
            httpReplyBuilder.setMessage("user exists");
        } else {
            TbUser tbUser = new TbUser();
            tbUser.setUserNo(request.getUserNo());
            tbUser.setUserName(request.getUserName());
            tbUser.setGender(request.getGender());
            tbUser.setBirthday(LocalDate.parse(request.getBirthday()));
            tbUser.setPassword(request.getPassword());
            userRepository.save(tbUser);
            httpReplyBuilder.setSuccess(true);
            httpReplyBuilder.setCode(0);
            httpReplyBuilder.clearMessage();
        }
        UserReply reply = UserReply.newBuilder().setResult(httpReplyBuilder.build()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
