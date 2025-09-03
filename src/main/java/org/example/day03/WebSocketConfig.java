package org.example.day03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

// ** 서버 웹소켓 주소 매핑 설정 클래스 **

@Configuration // 스프링 컨테이너(메모리)의 빈(객체) 등록
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    // implements WebSocketConfigurer  : 구현체

    // 내가 만든 서버 웹소켓 주소 등록 한다,
    // @Autowired 사용하는 클래스들의 전체조건 : 스프링 컨테이너(메모리) 빈 등록
    @Autowired private ChatSocketHandler chatSocketHandler;

    // register 치면 나옴
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // registry.addHandler( 웹소켓객체 , 메핑주소 ); : 여러개 만들기 가능
        registry.addHandler(chatSocketHandler ,"/chat");


    }
}
