package me.whale.data.elastic;

import me.whale.components.rpc.GrpcServer;

import java.io.IOException;

public class ElasticApplication extends GrpcServer {
    public ElasticApplication(int port) {
        super(port);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        int port = Integer.parseInt(System.getenv("WHALE_ELASTIC_PORT"));
        final ElasticApplication server = new ElasticApplication(port);
        server.start();
        server.blockUntilShutdown();
    }
}
