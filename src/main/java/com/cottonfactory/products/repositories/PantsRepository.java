package com.cottonfactory.products.repositories;

import com.cottonfactory.products.entities.Pants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PantsRepository extends JpaRepository<Pants, Long> {
}
