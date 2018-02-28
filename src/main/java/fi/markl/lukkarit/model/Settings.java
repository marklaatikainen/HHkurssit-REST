package fi.markl.lukkarit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Settings {
	String periodi1;
	String periodi2;
	String intensiiviviikko1;
	String intensiiviviikko2;
	String intensiiviviikko3;
	String intensiiviviikko4;
	@Id
	String nimi;
	Date updated;

	public Settings() {
		this.periodi1 = null;
		this.periodi2 = null;
		this.intensiiviviikko1 = null;
		this.intensiiviviikko2 = null;
		this.intensiiviviikko3 = null;
		this.intensiiviviikko4 = null;
		this.nimi = null;
		this.updated = null;
	}

	public Settings(String periodi1, String periodi2, String intensiiviviikko1, String intensiiviviikko2,
			String intensiiviviikko3, String intensiiviviikko4, String nimi, Date updated) {
		this.periodi1 = periodi1;
		this.periodi2 = periodi2;
		this.intensiiviviikko1 = intensiiviviikko1;
		this.intensiiviviikko2 = intensiiviviikko2;
		this.intensiiviviikko3 = intensiiviviikko3;
		this.intensiiviviikko4 = intensiiviviikko4;
		this.nimi = nimi;
		this.updated = updated;
	}

	public String getPeriodi1() {
		return periodi1;
	}

	public void setPeriodi1(String pediodi1) {
		this.periodi1 = pediodi1;
	}

	public String getPeriodi2() {
		return periodi2;
	}

	public void setPeriodi2(String pediodi2) {
		this.periodi2 = pediodi2;
	}

	public String getIntensiiviviikko1() {
		return intensiiviviikko1;
	}

	public void setIntensiiviviikko1(String intensiiviviikko1) {
		this.intensiiviviikko1 = intensiiviviikko1;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getIntensiiviviikko2() {
		return intensiiviviikko2;
	}

	public void setIntensiiviviikko2(String intensiiviviikko2) {
		this.intensiiviviikko2 = intensiiviviikko2;
	}

	public String getIntensiiviviikko3() {
		return intensiiviviikko3;
	}

	public void setIntensiiviviikko3(String intensiiviviikko3) {
		this.intensiiviviikko3 = intensiiviviikko3;
	}

	public String getIntensiiviviikko4() {
		return intensiiviviikko4;
	}

	public void setIntensiiviviikko4(String intensiiviviikko4) {
		this.intensiiviviikko4 = intensiiviviikko4;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

}