package com.cottonfactory.products.services.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PantsDto {

    private String type;
    private String size;
    private String color;
    private String designer;
    private BigDecimal price;

}
