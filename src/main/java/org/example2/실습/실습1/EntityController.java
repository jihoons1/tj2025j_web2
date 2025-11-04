package org.example2.실습.실습1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/entity")
public class EntityController {

    private final EntityService entityService;


    @PostMapping
    public ResponseEntity< ? > bookpost(@RequestBody EntityEntity entityEntity){
        return ResponseEntity.ok( entityService.bookpost(entityEntity) );
    }

    @GetMapping
    public ResponseEntity< ?> get(){
        return ResponseEntity.ok(entityService.get() );
    }

    @PutMapping
    public ResponseEntity< ? > update(@RequestBody EntityEntity entityEntity){
        return ResponseEntity.ok(entityService.update(entityEntity) );
    }

    @DeleteMapping
    public ResponseEntity< ? > delete(@RequestParam int bookid){
        return ResponseEntity.ok(entityService.delete( bookid));
    }
}
