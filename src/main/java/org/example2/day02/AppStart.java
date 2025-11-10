package org.example2.day02;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

@SpringBootApplication
@EnableWebSecurity // web2 사용했으므로 자동
@EnableJpaAuditing //
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class, args);
    }
}