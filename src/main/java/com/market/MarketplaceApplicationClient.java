package com.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.market.helper.RemoteHelper;
import com.market.helper.RemoteHelperImpl;



@SpringBootApplication(scanBasePackages={"com.market"})// same as @Configuration @EnableAutoConfiguration @ComponentScan
@EnableDiscoveryClient
public class MarketplaceApplicationClient {

	public static final String MARKET_SERVICE_URL = "http://MARKET-MICROSERVICE-PRODUCER";
	
	public static void main(String[] args){
		SpringApplication.run(MarketplaceApplicationClient.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public RemoteHelper remoteHelper(){
		return new RemoteHelperImpl(MARKET_SERVICE_URL);
	}

}
