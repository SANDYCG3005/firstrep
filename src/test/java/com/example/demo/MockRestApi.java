package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.controller.Controller;
import com.example.demo.service.ServiceLayer;

@WebMvcTest(controllers=Controller.class)
public class MockRestApi {
	
	@MockitoBean
	private ServiceLayer service;
	
	@Autowired
	private MockMvc mock;
	
	private static String endpointspecq="http://localhost:8080/surveys/questions/Survey1-Question1";
	private static String endpointallq = "http://localhost:8080/surveys/Survey1/questions";
	
	@Test
	public void testMock() throws Exception
	{
		MockHttpServletRequestBuilder reqbuild
		= MockMvcRequestBuilders.get(endpointspecq).accept(org.springframework.http.MediaType.APPLICATION_JSON);
		MvcResult mvc=mock.perform(reqbuild).andReturn();
		//System.out.println("Content type:"+mvc.getResponse().getContentAsString());
		System.out.println("Content type:"+mvc.getResponse().getStatus());		
	}
	
	@Test
	public void testAllMock() throws Exception
	{
		MockHttpServletRequestBuilder reqbuild1= MockMvcRequestBuilders.get(endpointallq).accept(org.springframework.http.MediaType.APPLICATION_JSON);
		MvcResult mvc = mock.perform(reqbuild1).andReturn();
		System.out.println("Content type:"+mvc.getResponse().getContentAsString());
		System.out.println("Content type:"+mvc.getResponse().getStatus());		
	}
}
