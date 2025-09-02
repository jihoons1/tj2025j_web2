package org.example.실습.실습1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    TaskDao taskDao;

    // 1. 매30초마다 모든 제품의 재고는 3개씩 감소
    @Scheduled(cron = "*/5 * * * * *")
    public void task1() {
        System.out.println("[30초]TaskService.task");
        int asd = taskDao.task11();
        // ++Dao 호출하여 모든 제품3개씩 감소 요청/응답++
    }

    // 2. 매 1분마다 모든 제품 정보를 조회/출력 한다.
    @Scheduled(cron = "*/15 * * * * *") // 1분마다
    public void task2() {
        System.out.println("[1분]TaskService.task");
        String asd = taskDao.task22();
        // ++ 모든 제품 정보를 조회/출력한다. ++
    }

    // 3. 매 5분마다 재고가 10 이하인 상품의 재고를 +20개 추가한다.
    @Scheduled(cron = "*/15 * * * * *") // 5분마다
    public void task3() {
        System.out.println("[5분]TaskService.task3");
        int asd = taskDao.task33();
        // ++ 재고가 10 이하인 상품의 재고를 +20개 추가한다.++
    }


}
