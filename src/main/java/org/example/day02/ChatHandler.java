package org.example.day02;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component // 스프링 컨테이너에 빈 등록
public class ChatHandler extends TextWebSocketHandler {

    // 1. 클라이언트 소켓이 서버소켓으로부터 연결을 성공했을때 실행되는 메소드
    // after
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception { }

    // 2. 클라이언 소켓이 서버소켓 과 연결을 끊겼을때 실행되는 메소드
    // after
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception { }

    // 3. 클라이언트 소켓이 서버소켓 에게 메세지를 보냈을때 실행되는 메소드
    // handleText
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception { }


}
