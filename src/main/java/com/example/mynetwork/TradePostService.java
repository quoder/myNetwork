package com.example.mynetwork;



import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.net.URI;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.mynetwork.Trade;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class TradePostService implements CommandLineRunner {

	private static void TradePostService() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Instant instant = timestamp.toInstant();
		Trade trade = new Trade("org.acme.mynetwork.Trade", "S3", "resource:org.acme.mynetwork.Trader#T2");
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Trade> request = new HttpEntity<>(trade);
		//URI location = restTemplate
		  //.postForLocation("http://localhost:3000/api/Trade", request);
//		Trade tt = restTemplate.postForObject("http://localhost:3000/api/Trade", request, Trade.class);
//		tt.getTransactionId();
		ResponseEntity<Trade> response =
		        restTemplate.postForEntity("http://localhost:3000/api/Trade", request, Trade.class);
		HttpStatus status = response.getStatusCode();
		Trade restCall = response.getBody();
		ObjectMapper mapper = new ObjectMapper();
		try {
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(restCall));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run(String... args) throws Exception {
		//TradePostService();
	}
	
	
}

