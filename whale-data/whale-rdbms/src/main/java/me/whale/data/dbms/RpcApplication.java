package me.whale.data.dbms;

import io.grpc.BindableService;
import me.whale.components.rpc.GrpcServer;
import me.whale.components.rpc.annotation.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
public class RpcApplication implements ApplicationRunner {
    private final static Logger LOGGER = LoggerFactory.getLogger(RpcApplication.class);
    @Resource
    private ApplicationContext applicationContext;
    private final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0,
            TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(1));

    @Override
    public void run(ApplicationArguments args) throws Exception {
        final Map<String, Object> grpcServices = applicationContext.getBeansWithAnnotation(GrpcService.class);
        List<BindableService> bindableServices = new ArrayList<>();
        for (Map.Entry<String, Object> entry : grpcServices.entrySet()) {
            if (entry.getValue() instanceof BindableService bindableService) {
                bindableServices.add(bindableService);
                LOGGER.info("find grpc service:{}", entry.getKey());
            }
        }
        int port = Integer.parseInt(System.getenv("WHALE_RDBMS_PORT"));
        final RpcServer server = new RpcServer(port, bindableServices, false);
        threadPoolExecutor.execute(() -> {
            try {
                server.run();
            } catch (IOException | InterruptedException e) {
                LOGGER.error("start rpc server failed");
            }
        });
    }

    static class RpcServer extends GrpcServer {
        public RpcServer(int port, List<BindableService> services, boolean autoDiscover) {
            super(port, services, autoDiscover);
        }

        public void run() throws IOException, InterruptedException {
            this.start();
            this.blockUntilShutdown();
        }
    }
}
