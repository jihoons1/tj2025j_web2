package org.example2.day02;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class GoodsService {

    private final GoodsRepository goodsRepository;

    // 1. 저장
    public GoodsDto goodssave(GoodsDto goodsDto){
        GoodsEntity entity = goodsDto.toEntity(); // 2. 저장할 dto를 entity 변환.
        GoodsEntity savedEntity = goodsRepository.save(entity); // 3. .save() 이용한 엔티티 영속화
        // 4. 만약에 pk가 생성 되었으면 생성된 엔티티를 dto로 변환하여 반환
        if (savedEntity.getGno() >= 0 ){ return savedEntity.toDto(); }
        return goodsDto;
    }

    // 조회
    public List<GoodsDto> goodsget(){
        List<GoodsEntity> goodsEntityList = goodsRepository.findAll(); // 모든 엔티티 조회
        // 2. 모든 엔티티를 Dto로 변환한다.
        // 방법2 스트림 API , java : 리스트명.steam().map() vs js : 리스트명.map()
        List<GoodsDto> goodsDtoList = goodsRepository.findAll()
                .stream().map( GoodsEntity :: toDto )
                        .collect(Collectors.toList() );
        return goodsDtoList;

        // 2. 모든 엔티티를 Dto로 변환한다.
        // 방법1
        // List<GoodsDto> goodsDtoList = new ArrayList<>();
        // for (int i = 0 ; i < goodsEntityList.size() ; i++){
        //    GoodsEntity entity = goodsEntityList.get(i); // i번째 엔티티꺼내서
        //    goodsDtoList.add(entity.toDto()); // 엔티티를 dto로 변ㄴ환후 리스트에 저장
        // }
    }

    public GoodsDto goodslist(int gno) {
        // 개별 조회할 gno 가져오기
        Optional<GoodsEntity> goodsEntityList = goodsRepository.findById(gno);
        if (goodsEntityList.isPresent()) { // 본분에 존재하는지 검사 / 조회 결과가 있으면
            GoodsEntity goodsEntity = goodsEntityList.get(); // 3. 엔티티 꺼내기
            return goodsEntity.toDto(); // 4. 엔티티 dto로 반환하기
        }
        return null;
    }

    // 수정 (
    public GoodsDto goodsupdate( GoodsDto goodsDto) {
        Optional<GoodsEntity> goodsEntity = goodsRepository.findById(goodsDto.getGno()); // 수정할 엔티티를 조회한다.
        if (goodsEntity.isPresent()) { // 존재하면
            GoodsEntity entity = goodsEntity.get(); // 영속화된 엔티티 꺼내기
            entity.setGname(goodsDto.getGname());
            entity.setGdesc(goodsDto.getGdesc());
            entity.setGprice(goodsDto.getGprice());
            return entity.toDto();
        }
        return goodsDto;
    }

    // 삭제
    public boolean goodsdelete(int gno) {
        if (goodsRepository.existsById(gno) ){
            goodsRepository.deleteById(gno);
            return true;
        }
        return false;
    }

}
