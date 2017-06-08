package com.example.mynetwork;


import org.json.*;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.mynetwork.Trader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class TraderGetService implements CommandLineRunner {

	private static void traderGetById(String id) {
		RestTemplate restTemplate = new RestTemplate();
//		Trader t = r.getForObject("http://localhost:3000/api/Trader/{id}", Trader.class, id );
//		assertThat(t.getTradeId(), notNullValue());
		ResponseEntity<List<Trader>> rateResponse =
		        restTemplate.exchange("http://localhost:3000/api/Trader",
		                    HttpMethod.GET, null, new ParameterizedTypeReference<List<Trader>>() {
		            });
		List<Trader> traders = rateResponse.getBody();
		ObjectMapper mapper = new ObjectMapper();
		for(Trader t: traders){
			try {
				System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(t));
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run(String... args) throws Exception {
		
		String id = "T1";
		//traderGetById(id);
	}
	
	
}
