package com.cottonfactory.products.repositories;

import com.cottonfactory.products.entities.DressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DressRepository extends JpaRepository<DressEntity, Long> {
}
