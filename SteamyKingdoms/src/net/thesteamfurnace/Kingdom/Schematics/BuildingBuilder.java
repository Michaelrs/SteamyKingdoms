package net.thesteamfurnace.Kingdom.Schematics;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
	private ArrayList<PendingBlock> stage1 = new ArrayList<PendingBlock>();
	private ArrayList<PendingBlock> stage2 = new ArrayList<PendingBlock>();
	private ArrayList<PendingBlock> stage3 = new ArrayList<PendingBlock>();
	private ArrayList<PendingBlock> stage4 = new ArrayList<PendingBlock>();
	private ArrayList<PendingBlock> stage5 = new ArrayList<PendingBlock>();
	private ArrayList<PendingBlock> stage6 = new ArrayList<PendingBlock>();
	private ArrayList<PendingBlock> stage7 = new ArrayList<PendingBlock>();
	private ArrayList<PendingBlock> stage8 = new ArrayList<PendingBlock>();
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
		InitializeBlocks();
		StartSlowpaste();
		}
	
	
	public void Pause(){
		paused = true;
	}
	
	public void Resume(){
		paused = false;
	}
	
	public void InitializeBlocks(){
		for(int x = 0;x < clipboard.getWidth();x++){
			for(int z = 0;z < clipboard.getLength();z++){
					for(int y = 0;y < clipboard.getHeight();y++){
					BaseBlock base = clipboard.getPoint(new Vector(x,y,z));
					if (base != null){
					int type = base.getType();
					int data = base.getData();
					Block block = world.getBlockAt(basex+x, basey+y, basez+z);
					switch(type){
					case 0:
						if(block.getType() != Material.AIR);
						block.setType(Material.AIR);
						break;
					case 1:
						if(block.getType() != Material.STONE);
						block.setType(Material.STONE);
						break;
					case 3:
						if(block.getType() != Material.DIRT);
						block.setType(Material.DIRT);
						break;
					case 2://GRASS
						stage1.add(new PendingBlock(block,type,(byte) data));
						break;
					case 17://LOG
						stage2.add(new PendingBlock(block,type,(byte) data));
						break;
					case 5://WOOD
						stage3.add(new PendingBlock(block,type,(byte) data));
						break;
					case 98://STONE BRICK
					case 35:
						stage4.add(new PendingBlock(block,type,(byte) data));
						break;
					case 47://BOOKSHELF
					case 85://FENCE
					case 89://GLOWSTONE
					case 61:// OFF FURNACE
					case 62:// ON FURNACE
					case 58:// WORKBENCH
					case 54:// CHEST
					case 380://CAULDRON
					case 117://BREWING STAND
					case 84://JUKEBOX
						stage5.add(new PendingBlock(block,type,(byte) data));
						break;
						
					case 134:
					case 135:
					case 136:
					case 43:
					case 44:
					case 139:
					case 20:
					case 102:
						stage6.add(new PendingBlock(block,type,(byte) data));
						break;
					case 63:
					case 64:
					case 71:
					case 355:
						stage8.add(new PendingBlock(block,type,(byte) data));
						break;
						
					default:
						stage7.add(new PendingBlock(block,type,(byte) data));
						break;
						
						
						
					}
					}
				}
			}
		}
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
			
		if(!stage1.isEmpty()){
			PendingBlock pendingblock = stage1.get(0);
			pendingblock.Place();
			stage1.remove(pendingblock);
		}else if(!stage2.isEmpty()){
			PendingBlock pendingblock = stage2.get(0);
			pendingblock.Place();
			stage2.remove(pendingblock);
		}else if(!stage3.isEmpty()){
			PendingBlock pendingblock = stage3.get(0);
			pendingblock.Place();
			stage3.remove(pendingblock);
		}else if(!stage4.isEmpty()){
			PendingBlock pendingblock = stage4.get(0);
			pendingblock.Place();
			stage4.remove(pendingblock);
		}else if(!stage2.isEmpty()){
			PendingBlock pendingblock = stage4.get(0);
			pendingblock.Place();
			stage4.remove(pendingblock);
		}else if(!stage5.isEmpty()){
			PendingBlock pendingblock = stage5.get(0);
			pendingblock.Place();
			stage5.remove(pendingblock);
		}else if(!stage6.isEmpty()){
			PendingBlock pendingblock = stage6.get(0);
			pendingblock.Place();
			stage6.remove(pendingblock);
		}else if(!stage7.isEmpty()){
			PendingBlock pendingblock = stage7.get(0);
			pendingblock.Place();
			stage7.remove(pendingblock);
		}else if(!stage8.isEmpty()){
			PendingBlock pendingblock = stage8.get(0);
			pendingblock.Place();
			stage8.remove(pendingblock);
		}else{
			Bukkit.getScheduler().cancelTask(schedulerID);
		}
			   }
			}, 1L, 1L);
	}
	
}
