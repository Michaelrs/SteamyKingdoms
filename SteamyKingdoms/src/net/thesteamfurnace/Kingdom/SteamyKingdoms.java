package net.thesteamfurnace.Kingdom;

import java.io.IOException;
import java.util.ArrayList;

import net.thesteamfurnace.Kingdom.Schematics.BuildingBuilder;
import net.thesteamfurnace.Kingdom.Schematics.Schematic;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SteamyKingdoms extends JavaPlugin{
	ArrayList<BuildingBuilder> BeingBuilt = new ArrayList<BuildingBuilder>();
	
	
	public SteamyKingdoms() {
		

	}
	
	@Override
	public void onEnable(){
		//TODO
	}
	
	@Override
	public void onDisable(){
		//TODO
	}
	
	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    	
    	
    
       if(command.getName().equalsIgnoreCase("test") && sender.isOp()){
    	   Player player = (Player)sender;
    	   try {
			new BuildingBuilder(new Schematic("house"),this, player.getLocation());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       }
       
	return true;
}
	
	
	public static SteamyKingdoms getPlugin(){
		return (SteamyKingdoms) Bukkit.getPluginManager().getPlugin("SteamyKingdoms");
	}
}
