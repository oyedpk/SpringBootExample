package com.rest.example.restexample;

public class Product {
    Integer id;
    String name;
    String Description;

    public Product(String name, String Description,Integer id) {
        this.Description=Description;
        this.name=name;
        this.id=id;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
