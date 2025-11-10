package org.example2.실습.실습4;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PracticeService {

    private final PracticeRepository practiceRepository;

    // 저장
    public PracticeDto practicesave(PracticeDto practiceDto){
        PracticeEntity practiceEntity = practiceDto.toEntity();
        PracticeEntity entitysave = practiceRepository.save(practiceEntity);
        if (entitysave.getPid() >= 0){ return entitysave.toDto(); }
        return practiceDto;
    }
    // 조회
    public List<PracticeDto> practiceget(){
        List<PracticeEntity> practiceEntityList = practiceRepository.findAll();
        List<PracticeDto> practicelist = practiceRepository.findAll()
                .stream().map( PracticeEntity :: toDto )
                .collect(Collectors.toList() );
        return practicelist;
    }

    public PracticeDto practiceupdate( PracticeDto practiceDto){
        Optional<PracticeEntity> practiceEntity = practiceRepository.findById(practiceDto.getPid());
        if (practiceEntity.isPresent()){
            PracticeEntity entity = practiceEntity.get(); // 영속
            entity.setPcontent(practiceDto.getPcontent());
            entity.setPtitle(practiceDto.getPtitle());
            return entity.toDto();
        }
        return practiceDto;
    }
}
