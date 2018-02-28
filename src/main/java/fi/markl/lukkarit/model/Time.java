package fi.markl.lukkarit.model;

import java.util.ArrayList;

public class Time {
	private String opintotunnus;
	private String kurssinimi;
	private ArrayList<TimeInfo> timeinfo;
	
	public Time() {
		
	}

	public Time(String opintotunnus, String kurssinimi, ArrayList<TimeInfo> timeinfo) {
		super();
		this.opintotunnus = opintotunnus;
		this.kurssinimi = kurssinimi;
		this.timeinfo = timeinfo;
	}

	public String getKurssinimi() {
		return kurssinimi;
	}

	public void setKurssinimi(String kurssinimi) {
		this.kurssinimi = kurssinimi;
	}

	public String getOpintotunnus() {
		return opintotunnus;
	}

	public void setOpintotunnus(String opintotunnus) {
		this.opintotunnus = opintotunnus;
	}

	public ArrayList<TimeInfo> getAikataulut() {
		return timeinfo;
	}

	public void setAikataulut(ArrayList<TimeInfo> timeinfo) {
		this.timeinfo = timeinfo;
	}
	
}
