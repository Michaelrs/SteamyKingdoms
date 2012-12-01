package net.thesteamfurnace.Kingdom;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import net.thesteamfurnace.Kingdom.Schematics.BuildingBuilder;
import net.thesteamfurnace.Kingdom.Schematics.Schematic;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.blocks.BaseBlock;
import com.sk89q.worldedit.data.DataException;
import com.sk89q.worldedit.schematic.SchematicFormat;

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
    	   System.out.println("Starting cmd!!!");
    	   Player player = (Player)sender;
    	   String prefix = SteamyKingdoms.getPlugin().getDataFolder().getAbsolutePath()+File.separator+"schematics"+File.separator+"house.schematic";
    	   File file = new File(prefix);
    	   SchematicFormat f = SchematicFormat.getFormat(file);
    	   new BuildingBuilder(file,this, player.getLocation(),true);
    	   try {
			BaseBlock block = f.load(file).getPoint(new Vector(0,0,0));
			sender.sendMessage(ChatColor.RED+" ID = "+block.getType());
		} catch (ArrayIndexOutOfBoundsException | IOException | DataException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	   
    	 /*  try {
			new BuildingBuilder(new Schematic("house"),this, player.getLocation());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
       }
       
	return true;
}
	
	
	public static SteamyKingdoms getPlugin(){
		return (SteamyKingdoms) Bukkit.getPluginManager().getPlugin("SteamyKingdoms");
	}
}
