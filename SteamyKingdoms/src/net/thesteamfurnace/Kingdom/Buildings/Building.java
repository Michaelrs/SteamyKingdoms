package net.thesteamfurnace.Kingdom.Buildings;

import java.util.ArrayList;

import org.bukkit.Location;

import net.citizensnpcs.api.npc.NPC;
import net.thesteamfurnace.Kingdom.Plots.Plot;

public abstract class Building {
	private String owner;
	private int level;
	private ArrayList<NPC> holdingnpcs = new ArrayList<NPC>();
	private Plot plot;
	
	public Building(){
		// TODO Initiate the Building object
		
		}
	
	public ArrayList<NPC> getHoldingNpcs(){
		return holdingnpcs;
	}
	
	public int getLevel(){
		return level;
	}
	
	public String getOwner(){
		
		return owner;
	}
	
	public void Refresh(){
		//TODO rebuild function (refresh the schematic and repaste it)
	}
	
	public void Destroy(){
		//TODO destroy the building
	}
	
	public Location getBaseLocation(){
		return plot.getBasetile();
	}
	
	
	
	
	



}
