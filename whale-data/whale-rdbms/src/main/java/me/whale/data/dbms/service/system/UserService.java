package me.whale.data.dbms.service.system;

import io.grpc.stub.StreamObserver;
import me.whale.common.enums.personal.AccountType;
import me.whale.components.common.HttpReply;
import me.whale.components.rpc.annotation.GrpcService;
import me.whale.components.service.system.AuthReply;
import me.whale.components.service.system.AuthRequest;
import me.whale.components.service.system.UserApiGrpc;
import me.whale.components.service.system.UserReply;
import me.whale.components.service.system.UserRequest;
import me.whale.data.dbms.domain.system.user.TbAccount;
import me.whale.data.dbms.domain.system.user.TbUser;
import me.whale.data.dbms.repository.backend.AccountRepository;
import me.whale.data.dbms.repository.backend.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@GrpcService
@Component
public class UserService extends UserApiGrpc.UserApiImplBase {
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    public UserService(UserRepository userRepository,
                       AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(UserRequest request, StreamObserver<UserReply> responseObserver) {
        var httpReplyBuilder = HttpReply.newBuilder().setSuccess(false).setCode(1);
        Optional<TbAccount> optionalTbAccount = accountRepository.findByAccountNo(request.getUserNo());
        if (optionalTbAccount.isPresent()) {
            httpReplyBuilder.setMessage("account exists");
        } else {
            TbAccount tbAccount = new TbAccount();
            tbAccount.setAccountType(AccountType.USER);
            tbAccount.setAccountNo(request.getUserNo());
            tbAccount.setAccountName(request.getUserName());
            tbAccount.setAccountNonExpired(true);
            tbAccount.setAccountNonLocked(true);
            tbAccount.setEnabled(true);
            accountRepository.save(tbAccount);
            TbUser tbUser = new TbUser();
            tbUser.setAccountId(tbAccount.getId());
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

    @Override
    public void authenticate(AuthRequest request, StreamObserver<AuthReply> responseObserver) {
        super.authenticate(request, responseObserver);
    }
}
