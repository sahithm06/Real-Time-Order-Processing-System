package com.demo.paymentprocess.consumer;


import com.demo.paymentprocess.dto.OrderEvent;
//import com.demo.paymentprocess.service.PaymentService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentConsumer {

    //private final PaymentService paymentService;

//    public PaymentConsumer(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }

    @KafkaListener(topics = "order-created", groupId = "payment-group", containerFactory = "kafkaListenerContainerFactory")
    public void processOrder(OrderEvent orderEvent) {
        System.out.println("✅ Payment Service received order event: " + orderEvent);
    }
}
