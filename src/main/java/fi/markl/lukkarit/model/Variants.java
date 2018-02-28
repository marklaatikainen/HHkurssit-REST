package fi.markl.lukkarit.model;

import java.util.List;

public class Variants {
	private List<String> vaihtoehdot;

	public Variants() {

	}

	public Variants(List<String> vaihtoehdot) {
		super();
		this.vaihtoehdot = vaihtoehdot;
	}

	public List<String> getVaihtoehdot() {
		return vaihtoehdot;
	}

	public void setVaihtoehdot(List<String> program) {
		this.vaihtoehdot = program;
	}

}
