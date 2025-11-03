package org.example.example2실습.day01;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityRepository
        extends JpaRepository< EntityEntity , Integer> {
}
