package net.thesteamfurnace.Kingdom;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class SteamyKingdoms extends JavaPlugin{

	public SteamyKingdoms() {
		// TODO Auto-generated constructor stub

	}
	
	@Override
	public void onEnable(){
		//TODO
	}
	
	@Override
	public void onDisable(){
		//TODO
	}
	
	public static SteamyKingdoms getPlugin(){
		return (SteamyKingdoms) Bukkit.getPluginManager().getPlugin("SteamyKingdoms");
	}
}
