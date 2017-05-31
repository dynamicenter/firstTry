package com.coffeeshop.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coffeeshop.components.entity.Coffee;
import com.coffeeshop.service.CoffeeService;

@RestController
@RequestMapping("/coffee")
public class CoffeeController {
	
	@Autowired
	private CoffeeService coffeeService;
	
	/**
	 * Get coffee by id from DB
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public Coffee searchOneCoffee(@PathVariable("id") Long id) {
		return CoffeeService.searchById(id);
				
	}	
		}
