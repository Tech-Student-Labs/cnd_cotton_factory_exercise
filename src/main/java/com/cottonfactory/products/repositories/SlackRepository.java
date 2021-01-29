package com.cottonfactory.products.repositories;

import com.cottonfactory.products.entities.Slack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlackRepository extends JpaRepository<Slack, Long> {
}
