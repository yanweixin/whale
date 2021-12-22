package me.whale.web.service

import io.grpc.StatusRuntimeException
import me.whale.components.rpc.GrpcClient
import me.whale.components.service.system.UserApiGrpc
import me.whale.components.service.system.UserReply
import me.whale.components.service.system.UserRequest
import me.whale.web.view.UserVo
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserService {
    private val logger = LoggerFactory.getLogger(this.javaClass)
    private val grpcClient = GrpcClient("localhost:${System.getenv("WHALE_RDBMS_PORT")}")

    fun add(user: UserVo): ResponseEntity<Any> {
        val userRequest = UserRequest.newBuilder()
            .setUserNo(user.userNo)
            .setUserName(user.userName)
            .setGender(user.gender)
            .setBirthday(user.birthday)
            .setPassword(user.password)
            .build()
        val response: UserReply
        try {
            val blockingStub = UserApiGrpc.newBlockingStub(grpcClient.channel)
            response = blockingStub.add(userRequest)
            return ResponseEntity.ok(response.result.message)
        } catch (e: StatusRuntimeException) {
            logger.warn("RPC failed: {}", e.status)
        }
        return ResponseEntity.badRequest().build()
    }
}