package com.cottonfactory.products.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name ="shoe_product")
@Data
@Builder
public class ShoeProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer size;
    private String height;
    private String type;
    private String material;
    private String designer;
    private Boolean laced;
    private BigDecimal price;

}
