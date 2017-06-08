package com.integration.tests;
 
 import static org.mockito.Mockito.times;
 import static org.mockito.Mockito.verify;
 import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
 import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
 import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
 import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
 
 import org.junit.Before;
 import org.junit.Test;
 import org.junit.runner.RunWith;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.boot.test.context.SpringBootTest;
 import org.springframework.http.MediaType;
 import org.springframework.test.context.ContextConfiguration;
 import org.springframework.test.context.junit4.SpringRunner;
 import org.springframework.test.web.servlet.MockMvc;
 import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
 import org.springframework.test.web.servlet.setup.MockMvcBuilders;
 import org.springframework.web.context.WebApplicationContext;
 import com.coffeeshop.components.entity.Stuff;
 import com.coffeeshop.components.service.StuffDao;
 import com.coffeeshop.service.StuffService;
 
 import com.coffeeshop.Application;
 
 @RunWith(SpringRunner.class)
 @SpringBootTest
 @ContextConfiguration(classes = { Application.class })
 public class StuffControllerIT {
 
 	private MockMvc mockMvc;
 
 	@Autowired
 	protected StuffService stuffService;
 
 	@Autowired
 	protected StuffDao stuffDao;
 
 	@Autowired
 	private WebApplicationContext wac;
 
 	@Before
 	public void setup() {
 		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
 
 	}
 
 	@Test
 	public void testVerifyCustomerById_success() throws Exception {
 		mockMvc.perform(MockMvcRequestBuilders.get("/shop/stuff/view/20001").accept(MediaType.APPLICATION_JSON))
 				.andExpect(jsonPath("$.id").exists())
 				.andExpect(jsonPath("$.surName").value("White"))
 				.andExpect(jsonPath("$.name").value("Rock")) 				
 				.andExpect(jsonPath("$.middleName").value("Kanady"))
 				.andExpect(jsonPath("$.dateBirth").value("13-06-1994")).andDo(print());
 	}
 
 	@Test
 	public void testAddStuff_success() throws Exception {
 		Stuff stuff = new Stuff(20019, "Carrygun", "Kriss", "Mosby", "12-04-1993");
 		stuffService.addStuff(stuff);
 		verify(stuffDao, times(10)).addStuff(stuff);
 	}
 
 	@Test
 	public void testDeleteByIdWhenStufftIsNotFound() throws Exception {
 		mockMvc.perform(delete("/shop/stuff/view/{id}", 20000)).andExpect(status().isNotFound());
 	}
 }
 
 