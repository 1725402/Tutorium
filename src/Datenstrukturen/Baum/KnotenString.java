package Datenstrukturen.Baum;


public class KnotenString {
	private String s = null;
	private KnotenString links = null;
	private KnotenString rechts = null;
	private boolean markiert = false;
	
	public KnotenString (String s) {
		this.setData(s);
	}
	
	public String getData() {
		return s;
	}
	
	public void setData (String s) {
		this.s = s;
	}

	public KnotenString getLinks () {
		return links;
	}
	
	public void setLinks (KnotenString k) {
		this.links = k;
	}
	
	public KnotenString getRechts () {
		return rechts;
	}
	
	public void setRechts (KnotenString s) {
		this.rechts = s;
	}
	
	public void setMarkiert (boolean markiert) {
		this.markiert = markiert;
	}
	
	public boolean isMarkiert () {
		return this.markiert;
	}
	
	@Override
	public String toString() {
		if (this.getData() == null) return null;
		return this.getData().toString();
	}
	
}
