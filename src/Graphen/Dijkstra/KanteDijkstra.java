package Graphen.Dijkstra;

import Graphen.*;

public class KanteDijkstra extends Kante{
	private int distanz = Integer.MAX_VALUE;
	
	public KanteDijkstra (Knoten kn1, Knoten kn2) {
		super(kn1,kn2);
	}
	
	public KanteDijkstra (Knoten kn1, Knoten kn2, int distanz) {
		this (kn1,kn2);
		setDistanz (distanz);
	}
	
	public void setDistanz (int distanz) {
		if (distanz <0)
			throw new RuntimeException ("Distanz darf nicht negativ sein");
		this.distanz = distanz;
	}
	
	public int getDistanz () {
		return distanz;
	}
}
