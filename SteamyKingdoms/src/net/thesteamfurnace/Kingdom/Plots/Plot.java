package net.thesteamfurnace.Kingdom.Plots;

import net.thesteamfurnace.Kingdom.Buildings.Building;

import org.bukkit.Location;

public class Plot {

	private PlotSize size;
	private PlotType type;
	private Location basetile;
	private Building currentbuilding;

	public Plot(Location basetile, PlotSize size, PlotType type) {
		this.size = size;
		this.basetile = basetile;
		this.type = type;
	}

	public PlotSize getSize() {
		return size;
	}

	public PlotType getType() {
		return type;
	}

	public Location getBasetile() {
		return basetile;
	}

	public Building getCurrentBuilding() {
		return currentbuilding;
	}
	
	
}
