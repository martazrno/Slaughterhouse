package via.pro3;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import via.pro3.service.SlaughterhouseServiceImpl;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        // create the gRPC server and register the service
        Server server = ServerBuilder
                .forPort(8086) // the port the server listens on
                .addService(new SlaughterhouseServiceImpl())
                .build();

        //start the server
        server.start();
        System.out.println("gRPC Server started on port: " + server.getPort());

        //keep the server running
        server.awaitTermination();


    }
}