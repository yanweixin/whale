package me.whale.web.service

import io.grpc.StatusRuntimeException
import me.whale.components.rpc.GrpcClient
import me.whale.components.service.GreeterGrpc
import me.whale.components.service.HelloReply
import me.whale.components.service.HelloRequest
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class CommonService {
    private val logger = LoggerFactory.getLogger(this.javaClass)
    private val grpcClient = GrpcClient("localhost:${System.getenv("WHALE_SERVICE_PORT")}")

    fun hello(name: String): String {
        val helloRequest = HelloRequest.newBuilder().setName(name).build()
        val response: HelloReply
        try {
            val blockingStub = GreeterGrpc.newBlockingStub(grpcClient.channel)
            response = blockingStub.sayHello(helloRequest)
        } catch (e: StatusRuntimeException) {
            logger.warn("RPC failed: {0}", e.status);
            return ""
        }
        logger.info("Greeting: " + response.message);
        return response.message
    }
}