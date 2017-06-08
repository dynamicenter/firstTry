package com.JUnit.tests;
 
 import static org.junit.Assert.assertEquals;
 import static org.junit.Assert.assertNotNull;
 
 import org.junit.Test;
 import org.junit.runner.RunWith;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.boot.test.context.SpringBootTest;
 import org.springframework.test.context.ContextConfiguration;
 import org.springframework.test.context.junit4.SpringRunner;

 import com.coffeeshop.Application;
 import com.coffeeshop.components.entity.Customer;
 import com.coffeeshop.components.service.CustomerDao;
 import com.coffeeshop.service.CustomerService;
 
 @RunWith(SpringRunner.class)
 @SpringBootTest
 @ContextConfiguration(classes = { Application.class })
 public class CustomerJTest {
 
 	@Autowired
 	protected CustomerDao customerDao;
 
 	@Autowired
 	protected CustomerService service;
 
 	@Test
 	public void testGetCustomerById_success() throws Exception {
 		Customer customer = customerDao.searchByIdCustomer(20001);
 		assertNotNull(customer);
 	}
 
 	@Test
 	public void testAddCustomer_success() {
 		System.out.println("Adding new customer");
 
 		Customer newCustomer = new Customer();
 		newCustomer.setSurname("Smith");
 		newCustomer.setName("Will");
 		newCustomer.setCreditcard("98567452127");
 		newCustomer.setEmail("WillSmith@gmail.com");
 
 		System.out.println("new customers ID: " + newCustomer.getCustomerId());
 		assertNotNull(newCustomer);
 
 		service.addCustomer(newCustomer);
 		Customer findCustomer = customerDao.searchByIdCustomer(20002);
 		assertEquals("Smith", findCustomer.getSurname());
 	}
 
 	@Test
 	public void testFindAndReadExistingCustomersById_success() throws Exception {
 		Customer Josh = new Customer();
 		Josh = customerDao.searchByIdCustomer(20001);
 
 		assertEquals("Brown", Josh.getSurname());
 		assertEquals("Josh", Josh.getName());
 		assertEquals("31987301257", Josh.getCreditcard());
 	}
 
 }