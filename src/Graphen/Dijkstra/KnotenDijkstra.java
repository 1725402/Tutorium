package Graphen.Dijkstra;

import Graphen.*;

public class KnotenDijkstra extends Knoten{
	private int distanz = Integer.MAX_VALUE;
	private KnotenDijkstra vorgänger = null;
	
	public KnotenDijkstra (int id) {
		super (id);
	}
	
	public void setDistanz (int distanz) {
		if (distanz < 0)
			throw new RuntimeException("Distanz ungültig!");
		this.distanz = distanz;
	}
	
	public int getDistanz () {
		return this.distanz;
	}
	
	public void setVorgänger (KnotenDijkstra vorgänger) {
		this.vorgänger = vorgänger;
	}
	
	public KnotenDijkstra getVorgänger () {
		return vorgänger;
	}
}
