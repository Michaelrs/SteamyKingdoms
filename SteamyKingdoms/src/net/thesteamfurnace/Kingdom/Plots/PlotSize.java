package net.thesteamfurnace.Kingdom.Plots;

public class PlotSize {
	int x;
	int y;
	int z;
	public final static PlotSize TINY = new PlotSize(5,30,8);
	public final static PlotSize SMALL = new PlotSize(16,30,12);
	public final static PlotSize NORMAL = new PlotSize(26,30,23);
	public final static PlotSize BIG = new PlotSize(40,50,35);
	public final static PlotSize HUGE = new PlotSize(80,50,70);
	
	public PlotSize(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
