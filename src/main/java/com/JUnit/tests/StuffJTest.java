package com.JUnit.tests;
 
 import static org.junit.Assert.assertEquals;
 import static org.junit.Assert.assertNotNull;
 import static org.junit.Assert.assertNull;
 
 import org.junit.Test;
 import org.junit.runner.RunWith;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.boot.test.context.SpringBootTest;
 import org.springframework.test.context.ContextConfiguration;
 import org.springframework.test.context.junit4.SpringRunner;
 
 import com.coffeeshop.Application;
 import com.coffeeshop.components.entity.Stuff;
 import com.coffeeshop.components.service.StuffDao;
 import com.coffeeshop.service.StuffService;
 
 @RunWith(SpringRunner.class)
 @SpringBootTest
 @ContextConfiguration(classes = { Application.class })
 public class StuffJTest {
 
 	@Autowired
 	protected StuffDao stuffDao;
 
 	@Autowired
 	protected StuffService stuffService;
 
 	@Test
 	public void testAddStuff_success() {
 		System.out.println("Creating new stuff member");
 
 		Stuff newStuff = new Stuff();
 		newStuff.setSurName("Statham");
 		newStuff.setName("Jason");
 		newStuff.setMiddleName("Michael");
 		newStuff.setDateBirth("26-07-1967");
 
 		assertNotNull(newStuff);
 
 		stuffService.addStuff(newStuff);
 		Stuff findStuff = stuffDao.searchByIdStuff(10002);
 		assertEquals("Statham", findStuff.getSurName());
 	}
 
 	@Test
 	public void testFindAndReadExistingStuffById_success() throws Exception {
 		Stuff stuff = new Stuff();
 		stuff = stuffDao.searchByIdStuff(10001);
 
 		assertEquals("LowKick", stuff.getSurName());
 		assertEquals("Sanya", stuff.getName());
 	}
 
 	@Test
 	public void TestReturnNullWhenStuffCannotBeFoundById_success() throws Exception {
 		Stuff nullStuff = new Stuff();
 		nullStuff = stuffDao.searchByIdStuff(10);
 		assertNull(nullStuff);
 	}
 }