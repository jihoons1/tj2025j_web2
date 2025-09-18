package org.example.day07.controller;

import lombok.RequiredArgsConstructor;
import org.example.day07.model.dto.BoardDto;
import org.example.day07.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
@CrossOrigin( value = "http://localhost:5173") // 리액트 서버와 CORS 통신을 허용
// @CrossOrigin( VALUE = "허용할주소") // CORS( 서로 다른 서버간의 요청/응답 허용 )  정책을 설정
public class BoardController {
    private final BoardService boardService;

    // 게시물 등록
    @PostMapping("")
    public ResponseEntity<Boolean> boardWrite(@RequestBody BoardDto boardDto){
        System.out.println("BoardController.boardWrite");
        boolean result = boardService.boardWrite(boardDto);
        return ResponseEntity.status(200).body(result);
    }
    // 게시물 전체 조회
    @GetMapping("")
    public ResponseEntity<List <BoardDto > > boardPrint(){
        System.out.println("BoardController.boardPrint");
        List<BoardDto> re = boardService.boardPrint();
        return ResponseEntity.status(200).body(re);
    }
    // 특정 게시물 조회
    @GetMapping("/find")
    public ResponseEntity<BoardDto> boardFind(@RequestParam int bno){
        BoardDto re = boardService.boardFind(bno);
        return ResponseEntity.status(200).body(re);
    }
    // 게시물 삭제
    @DeleteMapping("")
    public ResponseEntity<Boolean> boardDelete(@RequestParam int bno){
        Boolean result = boardService.boardDelete(bno);
        return ResponseEntity.ok().body(result);
    }
    // 게시물 수정
    @PutMapping("")
    public ResponseEntity<Boolean> boardUpdate(@RequestBody BoardDto dto){
        Boolean result = boardService.boardUpdate(dto);
        return ResponseEntity.ok().body(result);
    }
}
