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
 import com.coffeeshop.components.entity.Customer;
 import com.coffeeshop.components.service.CustomerDao;
 import com.coffeeshop.service.CustomerService;
 
 import com.coffeeshop.Application;
 
 @RunWith(SpringRunner.class)
 @SpringBootTest
 @ContextConfiguration(classes = { Application.class })
 public class CustomerControllerIT {
 
 	private MockMvc mockMvc;
 
 	@Autowired
 	protected CustomerService customerService;
 
 	@Autowired
 	protected CustomerDao customerDao;
 
 	@Autowired
 	private WebApplicationContext wac;
 
 	@Before
 	public void setup() {
 		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
 
 	}
 
 	@Test
 	public void testVerifyCustomerById_success() throws Exception {
 		mockMvc.perform(MockMvcRequestBuilders.get("/shop/customer/view/20001").accept(MediaType.APPLICATION_JSON))
 				.andExpect(jsonPath("$.id").exists())
 				.andExpect(jsonPath("$.surName").value("Smith"))
 				.andExpect(jsonPath("$.name").value("Lul")) 				
 				.andExpect(jsonPath("$.email").value("LULWill@gmail.com"))
 				.andExpect(jsonPath("$.creditCard").value("95320586612")).andDo(print());
 	}
 
 	@Test
 	public void testAddCustomer_success() throws Exception {
 		Customer customer = new Customer(20019, "Dalas", "Fire", "DalBon@gmail.com", "3435465787533");
 		customerService.addCustomer(customer);
 		verify(customerDao, times(10)).addCustomer(customer);
 	}
 
 	@Test
 	public void testDeleteByIdWhenCustomertIsNotFound() throws Exception {
 		mockMvc.perform(delete("/shop/customer/view/{id}", 20000)).andExpect(status().isNotFound());
 	}
 }
 
 