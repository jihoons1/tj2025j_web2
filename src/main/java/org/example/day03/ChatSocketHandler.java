package org.example.day03;

// ********** 서버소켓 역할 ************

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component // MVC패턴은 아니지만 스프링 컨테이너(메모리) 빈(객체) 등록
public class ChatSocketHandler extends TextWebSocketHandler {

    // * 접속된 클라이언트소켓들을 서버가 가지고 있을 예정

    // 1. 클라이언트 소켓 과 서버소켓이 연동 되었을때 이벤트

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("=============== *클라이언트 소켓*이 들어왔다. ==============");
    }

    // 2. 클라이언트 소켓 과 서버 소켓이 연동 끊겼을때 이벤트

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("=============== *클라이언트 소켓*이 나갔다. ==============");
    }

    // 3. 클라이언트 소켓으로 부터 메세지를 받았을때 이벤트

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("=============== *클라이언트 소켓* 메세지 받았다. ==============");
    }
}
