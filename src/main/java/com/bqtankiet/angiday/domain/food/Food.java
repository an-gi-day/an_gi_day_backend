package com.bqtankiet.angiday.domain.food;

import com.bqtankiet.angiday.domain.brand.Brand;
import com.bqtankiet.angiday.domain.category.Category;

/**
 * POJO Food model
 *
 * @author bqtankiet
 */
public class Food {

    private String id;
    private String name;
    private String imageUrl;
    private String description;
    private Double basePrice;
    private Category category;
    private Brand brand;
    private Integer soldCount;

    public Food() {}

    // Getter & Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Integer getSoldCount() {
        return soldCount;
    }

    public void setSoldCount(Integer soldCount) {
        this.soldCount = soldCount;
    }
}
