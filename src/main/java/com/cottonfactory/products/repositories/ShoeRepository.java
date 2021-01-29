package com.cottonfactory.products.repositories;

import com.cottonfactory.products.entities.ShoeProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoeRepository extends JpaRepository<ShoeProduct, Long> {
}
