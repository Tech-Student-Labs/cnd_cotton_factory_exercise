package com.cottonfactory.products.services.dtos;

import java.math.BigDecimal;

public class PantsDto {

    private String type;
    private String size;
    private String color;
    private String designer;
    private BigDecimal price;

    public PantsDto() {
    }

    public PantsDto(String type, String size, String color, String designer, BigDecimal price) {
        this.type = type;
        this.size = size;
        this.color = color;
        this.designer = designer;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
