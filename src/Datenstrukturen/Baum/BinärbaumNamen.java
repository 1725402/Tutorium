package Datenstrukturen.Baum;

public class BinärbaumNamen {
	private KnotenString wurzel = null;
	
	public BinärbaumNamen (String s) {
		wurzel = new KnotenString (s);
	}
	
	public int getHöhe () {
		return getHöheRekursion(0, wurzel);
			
	}

	private int getHöheRekursion(int aktHöhe, KnotenString k) {
		if(k != null) {
			return Math.max(
					getHöheRekursion (aktHöhe+1, k.getLinks()),
					getHöheRekursion(aktHöhe+1, k.getRechts())
					);
		}
		return aktHöhe;
	}

	public String getKleinster () {
		KnotenString k = getKleinster (wurzel);
		if (k == null)
			return null;
		else
			return k.getData();
	}
	
	public KnotenString getKleinster(KnotenString start) {
		if (start != null) 
			while (start.getLinks() != null)
				start = start.getLinks();
		return start;
	}
	
	public String getGrößter () {
		KnotenString k = getGrößter (wurzel);
		if (k == null)
			return null;
		else
			return k.getData();
	}
	
	public KnotenString getGrößter (KnotenString start) {
		if (start != null)
			while (start.getRechts() != null)
				start = start.getRechts();
		return start;
	}
	
	public KnotenString getKnoten (String s) {
		return getKnotenRekursion (wurzel, s);
	}
	
	public KnotenString getKnotenRekursion (KnotenString k, String s) {
		if (k == null)
			return null;
		if ((s.compareTo(k.getData())) == 0)
			return k;
		if ((s.compareTo(k.getData())) < 0) {
			if (k.getLinks() == null)
				return null;
			return getKnotenRekursion (k.getLinks(),s);
		}
		if ((s.compareTo(k.getData())) > 0) {
			if (k.getRechts() == null)
				return null;
			return getKnotenRekursion (k.getRechts(),s);
		}
		return null;
	}

	public String inOrderAusgabe () {
		return inOrderRekursion (wurzel);
	}
	
	private String inOrderRekursion (KnotenString k) {
		String s = "";
		if (k == null)
			return "<leer>";
		if (k.getLinks() != null)
			s = inOrderRekursion (k.getLinks());
		s += k.getData() + " ";
		if (k.getRechts() != null)
			s += inOrderRekursion (k.getRechts());
		return s;
	}

	public void einfügen (String s) {
		if (wurzel == null)
			wurzel = new KnotenString (s);
		this.einfügenRekursion (wurzel,s);
	}
	
	private void einfügenRekursion (KnotenString k, String s) {
		if (k == null)
			k = new KnotenString (s);
		if (wurzel == null)
			wurzel = k;
		else {
			if((s.compareTo(k.getData()))<0)
				if(k.getLinks() != null)
					einfügenRekursion (k.getLinks(), s);
				else
					k.setLinks(new KnotenString (s));
			if (s.compareTo(k.getData()) > 0)
				if (k.getRechts() != null)
					einfügenRekursion (k.getRechts(), s);
				else
					k.setRechts(new KnotenString (s));
		}
	}

	public boolean löschen (String s) {
		return löschenRekursion (wurzel, s, null, false);
	}

	private boolean löschenRekursion (KnotenString k, String s, KnotenString vater, boolean binLinksVomVater) {
		if (k == null)
			return false;
		if (s.compareTo(k.getData()) == 0) {
			//Zu löschender Knoten gefunden
			if ((k.getLinks() == null) && (k.getRechts() == null)) {
				if (vater == null)
					wurzel = null;
				else
					hängeUnterVater (vater, binLinksVomVater, null);
				return true;
			}
			//k hat nur rechten Unterknoten
			if ((k.getLinks() == null) && (k.getRechts() != null)) {
				if (vater == null)
					wurzel = k.getRechts();
				else
					hängeUnterVater (vater, binLinksVomVater, k.getRechts());
				return true;
			}
			//k hat nur linken Unterknoten
			if ((k.getLinks() != null) && (k.getRechts() == null)) {
				if (vater == null)
					wurzel = k.getLinks();
				else
					hängeUnterVater (vater, binLinksVomVater, k.getLinks());
				return true;
			}
			// k hat zwei Unterknoten
			KnotenString x = getKleinster (k.getRechts());
			System.out.println("X: "+ x);
			löschen (x.getData());
			if (vater == null) {
				x.setLinks(wurzel.getLinks());
				x.setRechts(wurzel.getRechts());
				wurzel = x;
			}else {
				x.setLinks (k.getLinks());
				x.setRechts (k.getRechts());
				hängeUnterVater (vater, binLinksVomVater, x);
			}
		}
		//nicht gefunden, links weitersuchen
		if (s.compareTo(k.getData()) < 0) {
			if (k.getLinks() == null)
				return false;
			return löschenRekursion (k.getLinks(), s, k, true);
		}
		
		//nicht gefunden, rechts weitersuchen
		if (s.compareTo(k.getData()) > 0) {
			if (k.getRechts() == null)
				return false;
			return löschenRekursion (k.getRechts(), s, k, true);
		}
		return false;
	}

	private void hängeUnterVater(KnotenString vater, boolean links, KnotenString k) {
		if (links)
			vater.setLinks(k);
		else
			vater.setRechts(k);
	}
}
