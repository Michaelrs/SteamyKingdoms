package net.thesteamfurnace.Kingdom.Buildings;

import org.bukkit.Location;

public abstract class Building {
	private String owner;
	private int level;
	
	
	public Building(){
		// TODO Initiate the Building object
		
		}
	
	public int getLevel(){
		return level;
	}
	
	public String getOwner(){
		
		return owner;
	}
	
	public void Rebuild(){
		//TODO rebuild function (refresh the schematic and repaste it)
	}
	
	public void Destroy(){
		//TODO destroy the building
	}
	
	
	
	
	
	
	



}
