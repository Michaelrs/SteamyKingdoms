package net.thesteamfurnace.Kingdom.Schematics;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

import com.sk89q.worldedit.CuboidClipboard;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.blocks.BaseBlock;
import com.sk89q.worldedit.data.DataException;
import com.sk89q.worldedit.schematic.SchematicFormat;

import net.thesteamfurnace.Kingdom.Cons;
import net.thesteamfurnace.Kingdom.SteamyKingdoms;

public class BuildingBuilder {
	private Schematic schematic;
	private boolean paused;
	int schedulerID;
	SteamyKingdoms plugin;
	int currentblock;
	int x = 0;
	int y = 0;
	int z = 0;
	int basex;
	int basey;
	int basez;
	World world;
	File file;
	SchematicFormat format;
	CuboidClipboard clipboard;
	public BuildingBuilder(File file, SteamyKingdoms plugin, Location basetile){
		this.plugin = plugin;
		basex = basetile.getBlockX();
		basey = basetile.getBlockY();
		basez = basetile.getBlockZ();
		world = plugin.getServer().getWorld(Cons.WORLDNAME);
		this.file = file;
		format = SchematicFormat.getFormat(file);
		try {
			clipboard = format.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StartSlowpaste();
		}
	
	
	public void Pause(){
		paused = true;
	}
	
	public void Resume(){
		paused = false;
	}
	
	public void PlaceNextBlock(){
	BaseBlock base = clipboard.getPoint(new Vector(x,y,z));
	if (base == null)
		return;
	int type = base.getType();
	int data = base.getData();
	Block block = world.getBlockAt(basex+x, basey+y, basez+z);
	block.setTypeId(type);
	block.setData((byte) data);
	System.out.println("Max Z "+clipboard.getWidth()+" Y"+clipboard.getHeight());
	}
	
	public void StartSlowpaste(){
		schedulerID = plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

			   public void run() {
			
			
			if(z == clipboard.getHeight()){
					Bukkit.getScheduler().cancelTask(schedulerID);
					schedulerID = -1;
			}else if(z == clipboard.getLength()){
				z = 0;
				y++;
				x = 0;
			}else if(x == clipboard.getWidth()-1){
				x = 0;
				z++;
			}else{
				x++;
			}
			PlaceNextBlock();
			   }
			}, 1L, 1L);
	}
	
}
