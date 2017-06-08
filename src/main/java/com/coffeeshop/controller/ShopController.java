package com.coffeeshop.controller;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coffeeshop.components.entity.Shop;
import com.coffeeshop.service.ShopService;

@RestController
@RequestMapping("/shop")
public class ShopController {
	@Autowired
	private ShopService shopService;

	/**
	 * Get store by id from DB
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public Shop searchByIdShop(@PathVariable("id") int id) {
		return shopService.searchByIdShop(id);
	}

	/**
	 * Get all stores from DB
	 * 
	 * @return
	 */
	@RequestMapping(value = "/information/{page}", method = RequestMethod.GET)
	public Collection<Shop> infoAboutShop(@PathVariable("page") int page) {
		return shopService.infoAboutShop(page);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String addShop(@RequestBody Shop shop) {
		shopService.addShop(shop);
		return "SUCCESS: Shop was created!";
	}
}