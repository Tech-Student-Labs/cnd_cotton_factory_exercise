package com.cottonfactory.products.entities;


import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import org.springframework.lang.NonNull;

import com.cottonfactory.ProductConstants;


@Entity
public class Jacket {

    @Id
    @GeneratedValue
    private Long id;
    
    @NonNull
    @Pattern(regexp = "(winter|spring|summer|fall)", message = ProductConstants.MESSAGE_JACKETSEASON)
    private String season;
    
    @NonNull
    @Pattern(regexp = "(small|medium|large|extra large)", message = ProductConstants.MESSAGE_JACKETSIZE)
    private String size;
    private String color;
    private boolean adultSize;
    
    @NonNull
    @Pattern(regexp = "(denim|hooded|overcoat|bomber)", message = ProductConstants.MESSAGE_JACKETSTYLE)
    private String style;
    private BigDecimal price;

    public Jacket(String season, String size, String color, boolean adultSize, String style, BigDecimal price) {
        this.season = season;
        this.size = size;
        this.color = color;
        this.adultSize = adultSize;
        this.style = style;
        this.price = price;
    }

    public Jacket() {
    }

    public String getSeason() {
        return season;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public boolean isAdultSize() {
        return adultSize;
    }

    public String getStyle() {
        return style;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Long getId() {
        return id;
    }

}
