package org.example.day01._1스프링스레드;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ThreadService {

    // 1.
    public int thread1(){
        int result = 0;
        // 반복문
        for ( int i = 1 ; i<=10 ; i++ ){
            result += i; // result 에 i+ 증가 , 누적
            System.out.println("ThreadController.thread\n"+result);
            // 만약에 서비스 처리가 늦어진다면 HTTP의 반환?? **
            try{ Thread.sleep(1000); // 현재 스레드 1초간 일시정지 , * Talenn Send 시 HTTP 응답 10초 후 다시 가능
            }catch (Exception e) { System.out.println("예외"+e); } // 예외 처리
        } // for end
        // 위 누적값 반환
        return result;
    }// func end

    // 2.
    @Async // 응답을 먼저하고 내부적으로 처리하는 상황
    public void thread2(){
        int result = 0;
        // 반복문
        for (int i = 1; i<=10 ; i++){
            result += i;
            System.out.println("ThreadController.thread2");
            try{ Thread.sleep(1000); }
            catch (Exception e) { System.out.println( e ); }
        }
//        return result;
    } // func end

} // class end
