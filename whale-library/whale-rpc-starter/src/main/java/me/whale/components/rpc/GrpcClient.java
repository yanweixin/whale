package me.whale.components.rpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class GrpcClient {
    public static final Logger LOGGER = LoggerFactory.getLogger(GrpcClient.class);

    private final ManagedChannel channel;

    public GrpcClient(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
    }

    /**
     * @param target host:port
     */
    public GrpcClient(String target) {
        this.channel = ManagedChannelBuilder.forTarget(target)
                .usePlaintext()
                .build();
    }

    public GrpcClient(ManagedChannel channel) {
        this.channel = channel;
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public ManagedChannel getChannel() {
        return channel;
    }
}
