package com.demo.orderprocessing.events;

import com.demo.orderprocessing.entity.OrderStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
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
