package com.bqtankiet.angiday.domain.brand;

/**
 * POJO Brand model
 * @author bqtankiet
 */
public class Brand {

    private String id;
    private String name;
    private String imageUrl;

    public Brand() {
    }

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
}
