package me.whale.components.service;

import io.grpc.BindableService;
import io.grpc.Server;
import me.whale.components.rpc.GrpcServer;
import me.whale.components.service.impl.GreeterImpl;
import me.whale.utils.lang.ClassUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class ServerApplication extends GrpcServer {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServerApplication.class);

    public ServerApplication(Server server) {
        super(server);
    }

    public ServerApplication(int port, BindableService service) {
        super(port, service);
    }

    public ServerApplication(int port) {
        super(port, null, true);
    }

    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        int port = Integer.parseInt(System.getenv("WHALE_SERVICE_PORT"));
        final ServerApplication server = new ServerApplication(port);
        server.start();
        server.blockUntilShutdown();
    }
}
