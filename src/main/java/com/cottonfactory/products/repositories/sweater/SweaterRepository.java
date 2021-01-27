package com.cottonfactory.products.repositories.sweater;

import com.cottonfactory.products.model.sweater.Sweater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SweaterRepository extends JpaRepository<Sweater, Integer> {
}
