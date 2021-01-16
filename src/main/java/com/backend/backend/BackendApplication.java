package com.backend.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class BackendApplication {

	final static String serviceurl1 = "https://gist.githubusercontent.com/mshafrir/2646763/raw/8b0dbb93521f5d6889502305335104218454c2bf/states_hash.json";
	final static String serviceurl2 = "https://gist.githubusercontent.com/mshafrir/2646763/raw/8b0dbb93521f5d6889502305335104218454c2bf/states_titlecase.json";
	
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	
	public static String reqProcessedData(int urlId) {
		
		String url = null;
		if(urlId == 1) {
			url = serviceurl1;
		}else if(urlId == 2) {
			url = serviceurl2;
		}else {
			return "Error";
		}
		
		RestTemplate rest = new RestTemplate();
		String result = rest.getForEntity(url, String.class).getBody();
		System.out.println("result "+result);
		return result;
	}
	
	@GetMapping("/")
	public static String Hello() {
		return "HELLO";
	} 
	
	@GetMapping("/readDataForCode")
	public static String reqcodedata(){
		return reqProcessedData(1);
	}
	
	@GetMapping("/readDataForState")
	public static String reqStatedata(){
		return reqProcessedData(2);
	}

}
