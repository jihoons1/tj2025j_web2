package org.example.실습.실습2;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.List;
import java.util.Vector;

@Component // 컨테이너 빈 등록
public class AlarmHandler extends TextWebSocketHandler {
    // TextWebSocketHandler : after , handleText 사용하기 위해 사용된 오버로드

    // 명단 목록 (클라이언트)
    private static final List<WebSocketSession> 접속인원 = new Vector<>();

    // 접속
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("[서버] 익명 사용자 접속");
        접속인원.add(session); // 서버에 접속한 접속인원 클라이언트 소켓을 리스트에 저장
    }

    // 종료
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("[서버] 익명 사용자 접속 종료");
        접속인원.remove(session);
        for (WebSocketSession clientSocket1 : 접속인원) {
            clientSocket1.sendMessage(new TextMessage("익명 사용자종료"));
        }
    }
    // 출력


    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("출력 테스트");

        for (WebSocketSession clientSocket : 접속인원){
            clientSocket.sendMessage(message);
        }
    }
}
