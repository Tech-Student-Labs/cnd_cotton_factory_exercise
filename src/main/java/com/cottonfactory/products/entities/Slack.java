package com.cottonfactory.products.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Slack {

    private String type;
    @JsonIgnore
    private Integer inseam;
    @JsonIgnore
    private Integer waist;
    private String size;
    private String color;
    private String designer;
    private BigDecimal price;

}
