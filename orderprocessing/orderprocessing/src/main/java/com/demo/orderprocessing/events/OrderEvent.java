package com.demo.orderprocessing.events;

import com.demo.orderprocessing.entity.OrderStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonSerialize
@JsonDeserialize
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderEvent {
    private Long orderId;
    private String product;
    private int quantity;
    private double price;
    private String status;  // NEW, PAID, SHIPPED

    public OrderEvent(Long id, String product, int quantity, double price, String status) {
        this.orderId = id;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.status = status;

    }

}
