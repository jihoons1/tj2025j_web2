package org.example.실습.실습2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration // 스프링 컨테이너 빈 등록
@EnableWebSocket // 소켓 활성화
public class WebSocketConfig implements WebSocketConfigurer {
    // implements WebSocketConfigurer : 구현체

    @Autowired private AlarmHandler alarmHandler; // DI

    // register

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(alarmHandler , "/log");
    }
}
