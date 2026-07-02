package com.example.demo.consumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PaymentRestConsumer {

    @Autowired
    private DiscoveryClient discoveryClient;

    public String getPaymentData() {

        List<ServiceInstance> instances =
                discoveryClient.getInstances("PAYMENT-SERVICE");

        if (instances == null || instances.isEmpty()) {
            return "PAYMENT-SERVICE not available";
        }

        ServiceInstance instance = instances.get(0);

        String url = instance.getUri() + "/payment/data";

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(url, String.class);
    }
}