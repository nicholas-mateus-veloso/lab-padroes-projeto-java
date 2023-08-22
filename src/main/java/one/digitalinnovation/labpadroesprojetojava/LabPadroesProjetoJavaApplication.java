package one.digitalinnovation.labpadroesprojetojava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LabPadroesProjetoJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabPadroesProjetoJavaApplication.class, args);
    }

}