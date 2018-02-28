package fi.markl.lukkarit.model;

import java.io.Serializable;
import java.util.Objects;

public class TimesKey implements Serializable {
	private String id = null;
	private int periodi;
	private String maa;
	private String tii;
	private String kes;
	private String tor;
	private String per;
	private String aj_str;

	private static final long serialVersionUID = 1L;

	public TimesKey() {
		
	}
	
	public TimesKey(String id, int periodi, String maa, String tii, String kes, String tor, String per, String aj_str) {
		super();
		this.id = id;
		this.periodi = periodi;
		this.maa = maa;
		this.tii = tii;
		this.kes = kes;
		this.tor = tor;
		this.per = per;
		this.aj_str = aj_str;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		TimesKey taskId1 = (TimesKey) o;
		if (periodi != taskId1.periodi)
			return false;
		return id == taskId1.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(periodi, maa, tii, kes, tor, per, aj_str);
	}
}
