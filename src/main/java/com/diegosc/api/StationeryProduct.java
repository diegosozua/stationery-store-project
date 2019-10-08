package com.diegosc.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StationeryProduct {
    @JsonProperty
    private int id;
    @JsonProperty
    private String barcode;
    @JsonProperty
    private String name;
    @JsonProperty
    private String description;
    @JsonProperty
    private int quantity;
    @JsonProperty
    private String category;

    public StationeryProduct() {}

    public StationeryProduct(int id, String barcode, String name, String description, int quantity, String category) {
        this.id = id;
        this.barcode = barcode;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.category = category;
    }

    public StationeryProduct(String barcode, String name, String description, int quantity, String category) {
        this.barcode = barcode;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }
}
