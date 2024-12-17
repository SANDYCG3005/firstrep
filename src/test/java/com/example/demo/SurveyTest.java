package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SurveyTest {
	private static String endpoint="http://localhost:8080/surveys/questions/Survey1-Question1";
	private String response=
			"""
				{
    
  "id": "Question1",
  "desc": "Most Popular Cloud Platform Today",
  "options": [
    "AWS",
    "Azure",
    "Google Cloud",
    "Oracle Cloud"
  ],
  "correctans": "AWS"

      }""";
		
	private String endpoint1 = "http://localhost:8080/surveys/Survey1/questions";
	private String response1 = 
			"""
				[
  {
    "id": "Question1",
    "desc": "Most Popular Cloud Platform Today",
    "options": [
      "AWS",
      "Azure",
      "Google Cloud",
      "Oracle Cloud"
    ],
    "correctans": "AWS"
  },
  {
    "id": "Question2",
    "desc": "Fastest Growing Cloud Platform",
    "options": [
      "AWS",
      "Azure",
      "Google Cloud",
      "Oracle Cloud"
    ],
    "correctans": "Google Cloud"
  },
  {
    "id": "Question3",
    "desc": "Most Popular DevOps Tool",
    "options": [
      "Kubernetes",
      "Docker",
      "Terraform",
      "Azure DevOps"
    ],
    "correctans": "Kubernetes"
  }
]	
					""";
	private RestTemplate res = new RestTemplate();
	
	@Test
	public void testapi() throws JSONException
	{
	
		ResponseEntity<String> resp = res.getForEntity(endpoint, String.class);
		System.out.println(resp.getBody());
		JSONAssert.assertEquals(response,resp.getBody(),true);
		System.out.println(resp.getHeaders());
		assertTrue(resp.getStatusCode().is2xxSuccessful());
		
	}
	@Test
	public void testapi2() throws JSONException
	{
		ResponseEntity<String> resp = res.getForEntity(endpoint1, String.class);
		JSONAssert.assertEquals(response1, resp.getBody(), true);
		assertTrue(resp.getStatusCode().is2xxSuccessful());
	}
	
}
