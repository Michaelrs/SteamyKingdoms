package net.thesteamfurnace.Kingdom.Buildings;

import org.bukkit.inventory.Inventory;

public class Shop extends Building {
	private Inventory SellingInventory;
	private Inventory BuyingInventory;

	public Inventory getSellingInventory() {
		return SellingInventory;
	}

	public Inventory getBuyingInventory() {
		return BuyingInventory;
	}
	
	
}
