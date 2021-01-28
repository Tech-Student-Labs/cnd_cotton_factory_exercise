package com.cottonfactory.products.entities.sweater;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Sweater {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String type;
    private Integer sleeve;
    private Integer neck;
    private Integer chest;
    private String size;
    private String customSize;//  (read only representation of chest x neck x sleeve)
    private String color;
    private Boolean longSleeve;
    private BigDecimal price;
}
