package com.cottonfactory.products.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getWaistSize() {
        return waistSize;
    }

    public void setWaistSize(Integer waistSize) {
        this.waistSize = waistSize;
    }

    public Integer getHipSize() {
        return hipSize;
    }

    public void setHipSize(Integer hipSize) {
        this.hipSize = hipSize;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCustomSize() {
        return customSize;
    }

    public void setCustomSize(String customSize) {
        this.customSize = customSize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "DressEntity{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", waistSize=" + waistSize +
                ", hipSize=" + hipSize +
                ", length=" + length +
                ", size='" + size + '\'' +
                ", customSize='" + customSize + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
