package com.demo.orderprocessing.service;

import com.demo.orderprocessing.entity.Order;
import com.demo.orderprocessing.entity.OrderStatus;
import com.demo.orderprocessing.events.OrderEvent;
import com.demo.orderprocessing.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService {


    private final OrderRepository orderRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    private static final String ORDER_TOPIC = "order-created";

    @Autowired
    public OrderService(OrderRepository orderRepository, KafkaTemplate<String, String> kafkaTemplate) {
        this.orderRepository = orderRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public Order placeOrder(Order order) {
        order.setStatus(OrderStatus.FRESH);
        order.setOrderDate(LocalDateTime.now());
        Order savedOrder = orderRepository.save(order);

        // Publish event to Kafka
        OrderEvent orderEvent = new OrderEvent(savedOrder.getId(), savedOrder.getProduct(),
                savedOrder.getQuantity(), savedOrder.getPrice(), savedOrder.getStatus().toString());

        kafkaTemplate.send(ORDER_TOPIC, orderEvent.toString());

        return savedOrder;
    }
}