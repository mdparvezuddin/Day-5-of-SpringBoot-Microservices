package com.example.demo.consumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.DiscoveryClient;

@Component

public class CartRestConsumer {
	@Autowired
	private org.springframework.cloud.client.discovery.DiscoveryClient discoverClient;
	public String getCartData() {
		
//	
		List<ServiceInstance> instances = discoverClient.getInstances("CART-SERVICE");
				
				if(instances==null || instances.isEmpty()) {
					return "CART-SERVICE not available now";
				}
//		Pick First Available instance
		ServiceInstance instance =  instances.get(0);
//		Create URL to call Cart Service
		String url = instance.getUri() + "/cart/getData";
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(url, String.class);
	}

}
