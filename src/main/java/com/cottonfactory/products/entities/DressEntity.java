package com.cottonfactory.products.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Builder
public class DressEntity {

    @Id
    @GeneratedValue
    private long id;

    private String type;
    private Integer waistSize;
    private Integer hipSize;
    private Integer length;
    private String size;
    private String customSize; // String (read only representation of waist x length)
    private String color;
    private BigDecimal price;

}
