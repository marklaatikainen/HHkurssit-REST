package fi.markl.lukkarit.model;

public class Periodi {
	private TimeInfo timeinfo;

	public Periodi() {
	}
	
	public Periodi(TimeInfo timeinfo) {
		super();
		this.timeinfo = timeinfo;
	}

	public TimeInfo getTimeinfo() {
		return timeinfo;
	}

	public void setTimeinfo(TimeInfo timeinfo) {
		this.timeinfo = timeinfo;
	}	
}
