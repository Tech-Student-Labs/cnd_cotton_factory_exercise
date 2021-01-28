package com.cottonfactory.products.repositories;

import com.cottonfactory.products.entities.Tie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TieRepository extends JpaRepository<Tie,Integer> {
}
