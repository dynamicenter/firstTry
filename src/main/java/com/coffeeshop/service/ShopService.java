package com.coffeeshop.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffeeshop.components.entity.Shop;
import com.coffeeshop.components.interface_i.IShop;

@Service
public class ShopService {


	@Autowired
	private IShop iShop;

	public Shop searchByIdShop(int id) {
		return iShop.searchByIdShop(id);
	}

	public Collection<Shop> infoAboutShop(int page) {
		return iShop.infoAboutShop(page);
	}

	public void addShop(Shop shop) {
		iShop.addShop(shop);
	}
}
