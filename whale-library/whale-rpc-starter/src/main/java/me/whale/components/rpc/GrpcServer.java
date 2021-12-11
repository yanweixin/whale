package me.whale.components.rpc;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import me.whale.utils.lang.ClassUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
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

    public GrpcServer(int port) {
        this(port, null, true);
    }

    public GrpcServer(int port, BindableService service) {
        this.port = port;
        this.server = ServerBuilder.forPort(port)
                .addService(service)
                .build();
    }

    public GrpcServer(int port, List<BindableService> services) {
        this(port, services, false);
    }

    public GrpcServer(int port, List<BindableService> services, boolean autoDiscover) {
        this.port = port;
        ServerBuilder<?> serverBuilder = ServerBuilder.forPort(port);
        if (services != null && !services.isEmpty()) {
            for (BindableService service : services) {
                serverBuilder.addService(service);
            }
        }
        if (autoDiscover) {
            for (BindableService service : findGrpcService()) {
                serverBuilder.addService(service);
            }
        }
        this.server = serverBuilder.build();
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

    @SuppressWarnings("unchecked")
    private List<BindableService> findGrpcService() {
        List<BindableService> bindableServices = new ArrayList<>();
        try {
            String packageName = getClass().getPackageName();
            Class<?>[] classes = ClassUtil.getPackageClasses(packageName);
            for (Class<?> clazz : classes) {
                if (BindableService.class.isAssignableFrom(clazz)) {
                    LOGGER.info("find service class:" + clazz.getName());
                    Constructor<BindableService> constructor = (Constructor<BindableService>) clazz.getConstructor();
                    bindableServices.add(constructor.newInstance());
                }
            }
        } catch (Exception e) {
            LOGGER.info("find gRPC service failed");
        }
        return bindableServices;
    }
}
