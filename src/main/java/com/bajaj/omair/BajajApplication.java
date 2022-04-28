package com.bajaj.omair;

import java.util.LinkedList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bajaj.omair.models.BajajRequest;
import com.bajaj.omair.models.BajajResponse;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/omair")
@SpringBootApplication
public class BajajApplication {

	public static void main(String[] args) {
		SpringApplication.run(BajajApplication.class, args);
	}
	
	@PostMapping("/bfhl")
	public BajajResponse getData(@RequestBody BajajRequest req) {
		
		List<String> numbers = new LinkedList<>();
		List<String> alphabets = new LinkedList<>();
		
		for(String s : req.getData()) {
			
			try{
				Integer.parseInt(s);
				numbers.add(s);
			}catch(Exception e) {
				alphabets.add(s);
			}
		}
		
		BajajResponse s = new BajajResponse();
		s.setIsSuccess(true);
		s.setUserId("PD0076");
		s.setEmail("shaikhomair1996@gmail.com");
		s.setRollNumber("210941220172");
		s.setNumbers(numbers);
		s.setAlphabets(alphabets);
		
		return s;
	}


}
