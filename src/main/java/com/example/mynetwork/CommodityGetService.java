package com.example.mynetwork;


import org.json.*;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.mynetwork.Commodity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CommodityGetService implements CommandLineRunner {

	private static void commodityGetById() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Commodity>> rateResponse =
		        restTemplate.exchange("http://localhost:3000/api/Commodity",
		                    HttpMethod.GET, null, new ParameterizedTypeReference<List<Commodity>>() {
		            });
		List<Commodity> commodities = rateResponse.getBody();
		ObjectMapper mapper = new ObjectMapper();
		for(Commodity c: commodities){
			try {
				System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(c));
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run(String... args) throws Exception {
		
		String id = "T1";
		//commodityGetById();
	}
	
	
}
