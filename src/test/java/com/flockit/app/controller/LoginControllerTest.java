package com.flockit.app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flockit.app.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTest {

	@Autowired
    private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	public void givenCredentials_whenFind_thenStatus200() throws Exception {
		User user = new User();
		user.setUsername("bordam");
		user.setPassword("s3cr3tPass");

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/login").contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
			      .accept(MediaType.ALL_VALUE).param("username", "mborda").param("password", "s3cr3tPass")).andReturn();

		Integer status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		var u = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), User.class);
		
		assert u.getName().equals("maxi");

	}
}
