package net.thesteamfurnace.Kingdom.Buildings;

import net.citizensnpcs.api.CitizensAPI;

import org.bukkit.entity.EntityType;
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
	
	public Shop(){
		CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, arg1)
	}
	
	
}
