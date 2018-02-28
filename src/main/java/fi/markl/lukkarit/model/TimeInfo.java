package fi.markl.lukkarit.model;

import java.util.List;

public class TimeInfo {
	private int periodi;
	private List<String> aika;
	
	public TimeInfo() {
		
	}
	
	public TimeInfo(int periodi, List<String> aika) {
		super();
		this.periodi = periodi;
		this.aika = aika;
	}

	public int getPeriodi() {
		return periodi;
	}

	public void setPeriodi(int periodi) {
		this.periodi = periodi;
	}

	public List<String> getAika() {
		return aika;
	}

	public void setAika(List<String> templist) {
		this.aika = templist;
	}
	
	
	
}
