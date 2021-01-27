package com.cottonfactory.products.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Jacket {

    @Id
    @GeneratedValue
    private int id;
    private String season;
    private String size;
    private String color;
    private boolean adultSize;
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

    public int getId() {
        return id;
    }

}
