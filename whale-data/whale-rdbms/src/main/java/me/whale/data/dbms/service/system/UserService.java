package me.whale.data.dbms.service.system;

import io.grpc.stub.StreamObserver;
import me.whale.components.rpc.annotation.GrpcService;
import me.whale.components.service.system.UserApiGrpc;
import me.whale.components.service.system.UserReply;
import me.whale.components.service.system.UserRequest;
import me.whale.data.dbms.domain.system.user.TbUser;
import me.whale.data.dbms.repository.backend.UserRepository;
import org.apache.commons.lang3.StringUtils;

import javax.inject.Named;
import java.time.LocalDate;
import java.util.Optional;

@GrpcService
@Named
public class UserService extends UserApiGrpc.UserApiImplBase {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void add(UserRequest request, StreamObserver<UserReply> responseObserver) {
        var replyBuilder = UserReply.newBuilder().setSuccess(false).setCode(1);
        if (StringUtils.isBlank(request.getUserNo()) || StringUtils.isBlank(request.getPassword())) {
            replyBuilder.setMessage("parameters check failed");
        } else {
            Optional<TbUser> tbUserOptional = userRepository.findByUserNo(request.getUserNo());
            if (tbUserOptional.isPresent()) {
                replyBuilder.setMessage("user exists");
            } else {
                TbUser tbUser = new TbUser();
                tbUser.setUserNo(request.getUserNo());
                tbUser.setUserName(request.getUserName());
                tbUser.setGender(request.getGender());
                tbUser.setBirthday(LocalDate.parse(request.getBirthday()));
                tbUser.setPassword(request.getPassword());
                userRepository.save(tbUser);
                replyBuilder.setSuccess(true);
                replyBuilder.setCode(0);
                replyBuilder.setMessage("");
            }
        }
        UserReply reply = replyBuilder.build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
