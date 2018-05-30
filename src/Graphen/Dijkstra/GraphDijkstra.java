package Graphen.Dijkstra;

import Graphen.*;
import java.util.ArrayList;

public class GraphDijkstra extends Graph{
	
	public GraphDijkstra () {
		super();
	}
	
	public void init () {
		for(Knoten knAusListe: getKnoten()) {
			KnotenDijkstra kd = (KnotenDijkstra) knAusListe;
			kd.setVorgänger(null);
			kd.setDistanz(Integer.MAX_VALUE);
		}
	}
	
	public ArrayList <KnotenDijkstra> kürzersterWeg (int start, int ende){
		init();
		KnotenDijkstra s = (KnotenDijkstra) getKnoten(start);
		KnotenDijkstra e = (KnotenDijkstra) getKnoten(ende);
		if ((s == null) || (e == null))
			return null;
		if (s == e)
			return null;
		s.setDistanz(0);
		ArrayList<KnotenDijkstra> q = new ArrayList<KnotenDijkstra>();
		for (Knoten kn : getKnoten())
			q.add((KnotenDijkstra) kn);
		do {
			KnotenDijkstra gewählt = null;
			for (KnotenDijkstra x : q) {
				if (gewählt == null)
					gewählt = x;
				if(gewählt.getDistanz() > x.getDistanz())
					gewählt = x;
			}
			q.remove(gewählt);
			for(Kante ka: gewählt.getKanten()) {
				KanteDijkstra kaD= (KanteDijkstra) ka;
				KnotenDijkstra knD = (KnotenDijkstra) ka.getAnderesEnde(gewählt);
				if (q.contains(knD)) {
					if(gewählt.getDistanz() +kaD.getDistanz() < knD.getDistanz()) {
						knD.setDistanz(gewählt.getDistanz()+kaD.getDistanz());
						knD.setVorgänger(gewählt);
					}
				}
			}
		}while (q.size()>0);
		ArrayList <KnotenDijkstra> aus =new ArrayList<KnotenDijkstra>();
		KnotenDijkstra x = e;
		do {
			aus.add(0,x);
			x = x.getVorgänger();
		}while (x != null);
		return aus;
	}
	
}
