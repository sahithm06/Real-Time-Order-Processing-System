package com.demo.paymentprocess.dto;

import java.io.Serializable;

public class OrderEvent implements Serializable {
    private Long orderId;
    private String product;
    private int quantity;
    private double price;
    private String status;

    // Default Constructor (Required for Kafka Deserialization)
    public OrderEvent() {}

    // All-Args Constructor
    public OrderEvent(Long orderId, String product, int quantity, double price, String status) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
    }

    // Getters & Setters
    public Long getId() { return orderId; }
    public void setId(Long orderId) { this.orderId = orderId; }

    public String getProduct() { return product; }
    public void setProduct(String product) { this.product = product; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "OrderEvent{orderId=" + orderId + ", product='" + product + "', quantity=" + quantity +
                ", price=" + price + ", status='" + status + "'}";
    }
}

