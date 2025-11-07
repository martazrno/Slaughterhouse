package via.pro3.restanimalservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestAnimalServiceApplication { //  enables auto configuration and component scanning
    public static void main(String[] args) {
        SpringApplication.run(RestAnimalServiceApplication.class, args); // starts the embedded Tomcat web server
    }
}