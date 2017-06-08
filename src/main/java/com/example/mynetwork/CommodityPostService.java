package com.example.mynetwork;



import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.net.URI;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.mynetwork.Commodity;

@Component
public class CommodityPostService implements CommandLineRunner {

	private static void commodityPostService() {
		//Commodity c = new Commodity("org.acme.mynetwork.Commodity", "S1", "First Commodity", "E1", "30", "T1");
		//Commodity c = new Commodity("org.acme.mynetwork.Commodity", "S2", "Second Commodity", "E2", "50", "T2");
		Commodity c = new Commodity("org.acme.mynetwork.Commodity", "S3", "Third Commodity", "E3", "100", "T1");

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Commodity> request = new HttpEntity<>(c);
		URI location = restTemplate
		  .postForLocation("http://localhost:3000/api/Commodity", request);
	}

	@Override
	public void run(String... args) throws Exception {
		//commodityPostService();
	}
	
	
}
