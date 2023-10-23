package ru.crystal.qrservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//TODO: Use ResponseEntity<T> in controllers return value.
@SpringBootApplication
public class QRServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(QRServiceApplication.class, args);
    }

}
