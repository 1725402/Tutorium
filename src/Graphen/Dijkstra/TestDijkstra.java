package Graphen.Dijkstra;

import java.util.ArrayList;
import Graphen.*;

public class TestDijkstra {
	
	public static void main (String[] args) {
		GraphDijkstra g = new GraphDijkstra();
		for (int i = 1; i <= 8; i++)
			g.addKnoten(new KnotenDijkstra (i));
		new KanteDijkstra (g.getKnoten(1), g.getKnoten(2),8);
		new KanteDijkstra (g.getKnoten(2), g.getKnoten(3),4);
		new KanteDijkstra (g.getKnoten(3), g.getKnoten(4),2);
		new KanteDijkstra (g.getKnoten(4), g.getKnoten(5),2);
		new KanteDijkstra (g.getKnoten(5), g.getKnoten(6),4);
		new KanteDijkstra (g.getKnoten(6), g.getKnoten(8),4);
		new KanteDijkstra (g.getKnoten(8), g.getKnoten(7),2);
		new KanteDijkstra (g.getKnoten(7), g.getKnoten(3),1);
		new KanteDijkstra (g.getKnoten(1), g.getKnoten(6),20);
		ArrayList <KnotenDijkstra> weg = g.kürzersterWeg(1, 6);
		System.out.println("Kürzester Weg: " + weg);
		System.out.println("Länge des Weges: " + ((KnotenDijkstra) g.getKnoten(6)).getDistanz());
	}
}
