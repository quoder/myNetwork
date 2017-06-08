package com.example.mynetwork;



import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.net.URI;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.mynetwork.Trader;

@Component
public class TraderPostService implements CommandLineRunner {

	private static void traderPostService() {
		Trader t = new Trader("org.acme.mynetwork.Trader", "T2", "Mishra", "Manish");
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Trader> request = new HttpEntity<>(t);
		URI location = restTemplate
		  .postForLocation("http://localhost:3000/api/Trader", request);
		assertThat(location, notNullValue());
		System.out.println("The Trader Posted is: " + t.getFirstName());
	}

	@Override
	public void run(String... args) throws Exception {
		//traderPostService();
	}
	
	
}
