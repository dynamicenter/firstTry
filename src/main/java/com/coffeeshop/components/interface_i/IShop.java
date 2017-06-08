package com.coffeeshop.components.interface_i;

import java.util.Collection;
import com.coffeeshop.components.entity.Shop;


public interface IShop {
	public Shop searchByIdShop(int id);

	Collection<Shop> infoAboutShop(int page);

	public void addShop(Shop shop);
}
