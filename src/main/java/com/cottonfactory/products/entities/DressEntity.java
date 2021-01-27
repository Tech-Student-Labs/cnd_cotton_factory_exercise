package com.cottonfactory.products.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DressEntity {

    @Id
    @GeneratedValue
    private int id;
    private String type;
    private Integer waistSize;
    private Integer hipSize;
    private Integer length;
    private String size;
    private String customSize; // String (read only representation of waist x length)
    private String color;
    private BigDecimal price;

}
