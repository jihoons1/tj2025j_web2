package org.example2.실습.실습1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityRepository
        extends JpaRepository< EntityEntity , Integer> {
}
