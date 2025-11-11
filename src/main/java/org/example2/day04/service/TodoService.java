package org.example2.day04.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example2.day04.model.dto.TodoDto;
import org.example2.day04.model.entity.TodoEntity;
import org.example2.day04.model.repository.TodoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TodoService {
    private final TodoRepository todoRepository;


    // 전체 조회
    public List<TodoDto> findAll(){
        return todoRepository.findAll()
                .stream().map( TodoEntity :: toDto )
                .collect(Collectors.toList() );
    }
    // 개별삭제
    public boolean delete(int id){
        if ( todoRepository.existsById(id) ){
            todoRepository.deleteById(id);
            return true;
        }return false;
    }
    // 개별 조회
    public TodoDto findById(int id){
        Optional<TodoEntity> optional = todoRepository.findById(id);
        if (optional.isPresent()){
            TodoEntity todoEntity = optional.get();
            return todoEntity.toDto();
        }else {
            return null;
        }
    }
    // 개별 수정 // day 02 goods 참고
    public TodoDto update(TodoDto todoDto){
        Optional<TodoEntity> opt = todoRepository.findById(todoDto.getId());
        if (opt.isPresent()){
            TodoEntity entity = opt.get();
            // JAP는 수정함수가 별도로 존재하지 않고 setter 이용한 *영속성* 수정 @Transactional
            entity.setTitle(todoDto.getTitle());
            entity.setContent(todoDto.getContent());
            entity.setDone(todoDto.isDone()); // boolean setter는 isXXX
            return entity.toDto();
        } else {
            return null;
        }
    }

    // [1] TodoRepository 2-1 , 3- 1
    public List<TodoDto> query1(String title) {

        // 2-1
        List<TodoEntity> result1 =
                todoRepository.findByTitle(title);
        System.out.println("result1 = " + result1);

        // 3-1 내가 만든 네이티브 쿼리 매소드
        List<TodoEntity> result2 =
                todoRepository.query1( title );
        System.out.println("result2 = " + result2);

        return result2.stream()
                .map( TodoEntity :: toDto )
                .collect(Collectors.toList());
    }
    
    // [2]
    public List<TodoDto> query2(String title , String content) {
        
        // 2=2 
        List<TodoEntity> result1 = 
        todoRepository.findByTitleAndContent( title, content);
        System.out.println("result1 = " + result1);
        // 3-2
        List<TodoEntity> result2 =
        todoRepository.query2(title,content);
        System.out.println("result2 = " + result2);
        
        return result2.stream()
                .map(TodoEntity :: toDto )
                .collect(Collectors.toList() );
        
    }

    // [3]
    public List<TodoDto> query3(String title ) {
        // 2-3
        List<TodoEntity> result =
                todoRepository.findByTitleContaining( title );
        System.out.println("result = " + result);
        // 3-3
        List<TodoEntity> result2 =
                todoRepository.query3( title );
        System.out.println("result2 = " + result2);

        return result2.stream()
                .map( TodoEntity::toDto )
                .collect(Collectors.toList() );
    }

    // [4] import org.springframework.data.domain.Page;
    public Page<TodoDto> page(int page , int size ){
        // 4-1 : 페이징 처리 옵션 설정한다. PageRequest.of
        // PageRequest.of( 조회할페이지번호 , 조회할페이지당데이터수, Sort.by(Sort.Direction.DESC , "정렬속성명" ) );
        PageRequest pageRequest = PageRequest.of( page-1 , size , Sort.by( Sort.Direction.DESC , "id") );

            // page-1 : 조회할 페이지는 0부터 시작함으로 1페이지가 0 이고 2페이지가 1 으로 처리됨에 -1 주입
            // size : 현재 (한)페이지에 조회할 자료 개수 , 1페이지에서 3개 조회
            // Sort.by( Sort.Direction.ASC , id ) 'id' 속성(컬럼) 내림차순 정렬 , order by id desc
        // 4-2 : 조회한다. // . findAll( 페이징객체 ); , Page< > 타입으로 반환된다. <---> List 타입 동일
        Page<TodoEntity> result = todoRepository.findAll( pageRequest );
            // Page : 페이징 처리 결과를 담는 인터페이스 타입 , 다양한 페이징 결과 제공한다.
        // 4-3 : 조회 결과 반환 , Page 타입은 스트림을 기본적으로 제공한다.
        return result.map(TodoEntity::toDto );
    }

    // [5]  2-5
    public Page<TodoDto> page2(String keyword , int page , int size ){
        Pageable pageable = PageRequest.of(page-1 , size , Sort.by(Sort.Direction.ASC , "id") ); // 페이징 옵션
        Page<TodoEntity> result;
        if (keyword == null || keyword.isBlank() ){ // 5-1 : 만약에 검색이 없으면 전체조회
            result = todoRepository.findAll( pageable ); // 전체 조회
        }else { // 5-2 : 검색이 있으면 검색조회
           result = todoRepository.findByTitleContaining( keyword , pageable );
        }
        // result 내 모든 자료들을 하나씩 toDto 함수를 호출하여 반환값들을 새로운 리스트에 반환한다.
        return result.map(TodoEntity::toDto );
        // vs
//        for (int i = 0; i<result.getSize(); i++){
//            TodoEntity todoEntity = result.getContent().get(i);
//            TodoDto todoDto = todoEntity.toDto();
//            resunt2.add(todoDto);
//          }
    }
} // class end

// 다형성이란? 특정 타입이 다양한 타입으로 변환 가능성 성질 : 상속 , 구현
