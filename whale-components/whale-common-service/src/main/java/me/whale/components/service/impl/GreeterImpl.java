package me.whale.components.service.impl;

import io.grpc.stub.StreamObserver;
import me.whale.components.service.GreeterGrpc;
import me.whale.components.service.HelloReply;
import me.whale.components.service.HelloRequest;

public class GreeterImpl extends GreeterGrpc.GreeterImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello " + request.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
