package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.demo.service.DemoService;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	DemoService service;

	@Test
	public void checkThatOutputMatchesExpectedOutput1(){
		String input = "Ahoj, jak se máš?";
		String expectedOutput = "?šÁm es kaj ,jOha";
		testDemoo(input, expectedOutput);
	}
	@Test
	public void checkThatOutputMatchesExpectedOutput2(){
		String input = "Je mi fajn.";
		String expectedOutput = ".NjaF iM ej";
		testDemoo(input, expectedOutput);
	}

	private void testDemoo(String input, String expectedOutput) {
		final String demo = service.demo(input);
		System.out.println("Expected: "+expectedOutput);
		System.out.println("Result: "+demo);
		Assert.isTrue(expectedOutput.equals(demo), "Result didnt't match expected result");
	}

}
