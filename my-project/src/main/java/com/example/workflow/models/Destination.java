package com.example.workflow.models;

public class Destination {
    private int id;
    private String name;
    private DestinationType type;
    private String code;
    private double price;

    // Constructors
    public Destination() {}

    public Destination(int id, String name, DestinationType type, String code, double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.code = code;
        this.price = price;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DestinationType getType() {
        return type;
    }

    public void setType(DestinationType type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Destination{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", code='" + code + '\'' +
                ", price=" + price +
                '}';
    }
}
