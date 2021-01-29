package com.cottonfactory.products.repositories;

import com.cottonfactory.products.entities.DressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DressRepository extends JpaRepository<DressEntity,Integer> {
}
