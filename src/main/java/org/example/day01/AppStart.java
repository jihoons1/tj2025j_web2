package org.example.day01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync // 비동기 사용 활성화
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);

    } // main end
} // class end
