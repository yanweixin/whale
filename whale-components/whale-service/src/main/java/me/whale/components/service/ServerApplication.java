package me.whale.components.service;

import io.grpc.BindableService;
import io.grpc.Server;
import me.whale.components.rpc.GrpcServer;
import me.whale.components.service.impl.GreeterImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ServerApplication extends GrpcServer {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServerApplication.class);

    public ServerApplication(Server server) {
        super(server);
    }

    public ServerApplication(int port, BindableService service) {
        super(port, service);
    }

    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        int port = Integer.parseInt(System.getenv("WHALE_SERVICE_PORT"));
        final ServerApplication server = new ServerApplication(port, new GreeterImpl());
        server.start();
        server.blockUntilShutdown();
    }
}
