package org.example2.실습.실습1;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EntityService {

    private final EntityRepository entityRepository;

    public EntityEntity bookpost( EntityEntity entityEntity){
        EntityEntity savebook = entityRepository.save(entityEntity);
        return savebook;
    }

    public List<EntityEntity> get(){
        List<EntityEntity> entityList = entityRepository.findAll();
        return entityList;
    }

    @Transactional // 트랜잭션 여러개 sql
    public EntityEntity update(EntityEntity entityEntity){
        Optional<EntityEntity> optional = entityRepository.findById(entityEntity.getBookid());
        if (optional.isPresent() ) {
            EntityEntity entity = optional.get();
            entity.setBookname(entityEntity.getBookname());
            entity.setPublisher(entityEntity.getPublisher());
            entity.setBname(entityEntity.getBname());
            return entity;
        }
        return entityEntity;
    }

    public boolean delete(int bookid ){
        entityRepository.deleteById(bookid);
        return true;

    }
}
