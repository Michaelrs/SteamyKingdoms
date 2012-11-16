package net.thesteamfurnace.Kingdom.Plots;

public class PlotType {
	int type;
	
	public static final PlotType House = new PlotType(1);
	public static final PlotType Countryside = new PlotType(2);
	public static final PlotType Roadside = new PlotType(3);
	public static final PlotType KingdomPlot = new PlotType(4);
	public static final PlotType CastlePlot = new PlotType(5);
	public static final PlotType Special = new PlotType(10);
	PlotType(int type){
		this.type = type;
	}
	
	
}
