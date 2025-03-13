//package com.demo.paymentprocess.service;
//
//import com.demo.paymentprocess.dto.OrderEvent;
//import com.demo.paymentprocess.entity.OrderStatus;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//public class PaymentService {
//
//    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;
//
//    public PaymentService(KafkaTemplate<String, OrderEvent> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
//    public void processPayment(OrderEvent orderEvent) {
//        // Simulate Payment Success
//        boolean isPaymentSuccessful = true; // You can randomize this for testing
//
//        if (isPaymentSuccessful) {
//            orderEvent.setStatus(OrderStatus.ORDER_PAID);
//            System.out.println("Payment successful for Order ID: " + orderEvent.getOrderId());
//        } else {
//            orderEvent.setStatus(OrderStatus.PAYMENT_FAILED);
//            System.out.println("Payment failed for Order ID: " + orderEvent.getOrderId());
//        }
//
//        // Publish event to Kafka
//        kafkaTemplate.send("order-paid", orderEvent);
//    }
//}
//
