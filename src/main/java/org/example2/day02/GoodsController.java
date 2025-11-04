package org.example2.day02;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/goods")
public class GoodsController {

    private final GoodsService goodsService;

    // 등록
    @PostMapping
    public ResponseEntity< ? > goodssave(@RequestBody GoodsDto goodsDto){
        return ResponseEntity.ok(goodsService.goodssave(goodsDto));
    }

    // 조회
    @GetMapping("/list")
    public ResponseEntity< ? > goodsget(){
        return ResponseEntity.ok(goodsService.goodsget());
    }

    // 개별 조회
    @GetMapping
    public ResponseEntity< ? > goodslist(@RequestParam int gno){
        return ResponseEntity.ok(goodsService.goodslist(gno) );
    }

    // 삭제
    @DeleteMapping
    public ResponseEntity< ? > goodsdelete(@RequestParam int gno){
        return ResponseEntity.ok(goodsService.goodsdelete(gno) );
    }

    // 수정
    @PutMapping
    public ResponseEntity< ? > goodsupdate(@RequestBody GoodsDto goodsDto ){
        return ResponseEntity.ok(goodsService.goodsupdate(goodsDto) );

    }
}
