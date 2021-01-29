package com.cottonfactory.products.repositories;

import com.cottonfactory.products.entities.Skirt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SkirtsRepository extends JpaRepository<Skirt, Integer> {

}
