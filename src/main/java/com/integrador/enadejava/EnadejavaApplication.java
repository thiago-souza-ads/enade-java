package com.integrador.enadejava;

import com.integrador.enadejava.security.JwtGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class}
)
public class EnadejavaApplication {

    public static void main(String[] args) {SpringApplication.run(EnadejavaApplication.class, args);}

}
