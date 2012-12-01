package net.thesteamfurnace.Kingdom.Schematics;

import javax.xml.crypto.Data;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class PendingBlock {
	private Block block;
	private int material;
	private byte data;
	
	
	
	public PendingBlock(Block block,int material,byte data){
		this.block = block;
		this.material = material;
		this.data = data;
	}
	
	public boolean AlreadyPlaced(){
		if(block.getTypeId() == material && block.getData() == data)
			return true;
		return false;
	}
	
	public boolean Place(){
		if(block == null)
			return false;
		block.setTypeId(material);
		block.setData(data);
		return true;
		
	}
}
