package org.takensoft.taken_soft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TakenSoftApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(TakenSoftApplication.class, args);
    }
    
}
