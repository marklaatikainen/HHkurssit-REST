package fi.markl.lukkarit.model;

import java.util.List;

public class Variants {
	private List<String> koulutusohjelmat;
	private List<String> opetuskielet;
	private List<String> toimipisteet;
	private List<String> suoritustavat;

	public Variants() {

	}

	public Variants(List<String> koulutusohjelmat, List<String> opetuskielet, List<String> toimipisteet,
			List<String> suoritustavat) {
		super();
		this.koulutusohjelmat = koulutusohjelmat;
		this.opetuskielet = opetuskielet;
		this.toimipisteet = toimipisteet;
		this.suoritustavat = suoritustavat;
	}

	public List<String> getKoulutusohjelmat() {
		return koulutusohjelmat;
	}

	public void setKoulutusohjelmat(List<String> koulutusohjelmat) {
		this.koulutusohjelmat = koulutusohjelmat;
	}

	public List<String> getOpetuskielet() {
		return opetuskielet;
	}

	public void setOpetuskielet(List<String> opetuskielet) {
		this.opetuskielet = opetuskielet;
	}

	public List<String> getToimipisteet() {
		return toimipisteet;
	}

	public void setToimipisteet(List<String> toimipisteet) {
		this.toimipisteet = toimipisteet;
	}

	public List<String> getSuoritustavat() {
		return suoritustavat;
	}

	public void setSuoritustavat(List<String> suoritustavat) {
		this.suoritustavat = suoritustavat;
	}
}
