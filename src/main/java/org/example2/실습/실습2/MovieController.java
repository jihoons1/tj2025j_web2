package org.example2.실습.실습2;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/movie")
@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    // 영화 등록
    @PostMapping
    public ResponseEntity< ? > moviesave(@RequestBody MovieDto movieDto){
        return ResponseEntity.ok(movieService.moviesave(movieDto) );
    }

    // 영화 조회
    @GetMapping("list")
    public ResponseEntity< ? > movielist(){
        return ResponseEntity.ok(movieService.movielist());
    }

    // 영화 개별 조회
    @GetMapping
    public ResponseEntity< ? > movielistid(@RequestParam int movieid){
        return ResponseEntity.ok(movieService.movielistid(movieid) );
    }

    // 특정 영화 수정
    @PutMapping
    public ResponseEntity< ? > movieupdate(@RequestBody MovieDto movieDto){
        return ResponseEntity.ok(movieService.movieupdate(movieDto) );
    }
    // 특정 영화 삭제
    @DeleteMapping
    public ResponseEntity< ? > moviedelete(@RequestParam int movieid){
        return ResponseEntity.ok(movieService.moviedelete(movieid) );
    }

}
