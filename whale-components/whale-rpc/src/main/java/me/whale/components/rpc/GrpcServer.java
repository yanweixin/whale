package me.whale.components.rpc;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GrpcServer {
    private static final Logger LOGGER = LoggerFactory.getLogger(GrpcServer.class);

    private final Server server;
    /* The port on which the server should run */
    private final int port;

    public GrpcServer(Server server) {
        this.server = server;
        this.port = server.getPort();
    }

    public GrpcServer(int port, BindableService service) {
        this.port = port;
        this.server = ServerBuilder.forPort(port)
                .addService(service)
                .build();
    }

    protected void start() throws IOException {
        server.start();
        LOGGER.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                LOGGER.error("*** shutting down gRPC server since JVM is shutting down");
                try {
                    GrpcServer.this.stop();
                } catch (InterruptedException e) {
                    LOGGER.error("server interrupted. ", e);
                }
                LOGGER.error("*** server shut down");
            }
        });
    }

    protected void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    protected void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }
}
