package com.javaweb.repository;

import com.javaweb.entity.RentAreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface RentAreaRepository extends JpaRepository<RentAreaEntity, Long> {
    void deleteByBuildingEntityId(Long id);
}
