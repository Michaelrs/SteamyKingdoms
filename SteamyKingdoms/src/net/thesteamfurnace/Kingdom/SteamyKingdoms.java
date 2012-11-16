package net.thesteamfurnace.Kingdom;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class SteamyKingdoms extends JavaPlugin{

	public SteamyKingdoms() {
		// TODO Auto-generated constructor stub

	}
	
	public static SteamyKingdoms getPlugin(){
		return (SteamyKingdoms) Bukkit.getPluginManager().getPlugin("SteamyKingdoms");
	}
}
