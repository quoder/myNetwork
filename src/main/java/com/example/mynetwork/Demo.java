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
public class Demo implements CommandLineRunner {

	
	private static void makeTraders() {
		//POSTing the Traders
		Trader t1 = new Trader("org.acme.mynetwork.Trader", "tradeId:0001", "AAAA", "BBBB");
		Trader t2 = new Trader("org.acme.mynetwork.Trader", "tradeId:0002", "CCCC", "DDDD");
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Trader> request = new HttpEntity<>(t1);
		URI location = restTemplate
		  .postForLocation("http://localhost:3000/api/Trader", request);
		
		request = new HttpEntity<>(t2);
		location = restTemplate.postForLocation("http://localhost:3000/api/Trader", request);
		
		//GETting the Traders
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
	
	private static void makeCommodity() {
		//POSTting Commodity
		Commodity c1 = new Commodity("org.acme.mynetwork.Commodity", "tradingSymbol:1000", "First Commodity", "E1", "100", "resource:org.acme.mynetwork.Trader#tradeId:0001");
		Commodity c2 = new Commodity("org.acme.mynetwork.Commodity", "tradingSymbol:1001", "Second Commodity", "E2", "500", "resource:org.acme.mynetwork.Trader#tradeId:0002");
		Commodity c3 = new Commodity("org.acme.mynetwork.Commodity", "tradingSymbol:1002", "Third Commodity", "E3", "300", "resource:org.acme.mynetwork.Trader#tradeId:0001");
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Commodity> request = new HttpEntity<>(c1);
		URI location = restTemplate.postForLocation("http://localhost:3000/api/Commodity", request);
		request = new HttpEntity<Commodity>(c2);
		location = restTemplate.postForLocation("http://localhost:3000/api/Commodity", request);
		request = new HttpEntity<Commodity>(c3);
		location = restTemplate.postForLocation("http://localhost:3000/api/Commodity", request);
		
		//GETting Commodity
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

	private static void makeTrade() {
		Trade trade = new Trade("org.acme.mynetwork.Trade", "resource:org.acme.mynetwork.Commodity#tradingSymbol:1001", "resource:org.acme.mynetwork.Trader#tradeId:0001");
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Trade> request = new HttpEntity<>(trade);
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
		makeTraders();
		makeCommodity();
		makeTrade();
	}
	
	
}

