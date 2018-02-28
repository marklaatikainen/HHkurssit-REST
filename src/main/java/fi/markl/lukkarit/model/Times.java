package fi.markl.lukkarit.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@IdClass(TimesKey.class)
@Table(name = "aikataulut")
public class Times {

	@Column(name = "kurssinimi")
	private String name = null;

	@Id
	@Column(name = "opintotunnus")
	private String id = null;

	@Id
	@Column(name = "ajoitus")
	private int periodi;

	@Id
	@Column(name = "maa")
	private String maa;

	@Id
	@Column(name = "tii")
	private String tii;

	@Id
	@Column(name = "kes")
	private String kes;

	@Id
	@Column(name = "tor")
	private String tor;

	@Id
	@Column(name = "per")
	private String per;

	@Id
	@Column(name = "aj_string")
	private String aj_str;

	@Transient
	private List<String> times = new ArrayList<String>();

	public Times() {
		super();
		this.id = null;
		this.name = null;
		this.periodi = 0;
		this.maa = null;
		this.tii = null;
		this.kes = null;
		this.tor = null;
		this.per = null;
		this.aj_str = null;		
	}

	public Times(String id, String name, int periodi, String maa, String tii, String kes, String tor, String per,
			String aj_str) {
		super();
		this.id = id;
		this.name = name;
		this.periodi = periodi;
		this.maa = maa;
		this.tii = tii;
		this.kes = kes;
		this.tor = tor;
		this.per = per;
		this.aj_str = aj_str;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPeriodi() {
		return periodi;
	}

	public void setPeriodi(int periodi) {
		this.periodi = periodi;
	}

	public String getMaa() {
		return maa;
	}

	public void setMaa(String maa) {
		this.maa = maa;
	}

	public String getTii() {
		return tii;
	}

	public void setTii(String tii) {
		this.tii = tii;
	}

	public String getKes() {
		return kes;
	}

	public void setKes(String kes) {
		this.kes = kes;
	}

	public String getTor() {
		return tor;
	}

	public void setTor(String tor) {
		this.tor = tor;
	}

	public String getPer() {
		return per;
	}

	public void setPer(String per) {
		this.per = per;
	}

	public String getAj_str() {
		return aj_str;
	}

	public void setAj_str(String aj_str) {
		this.aj_str = aj_str;
	}

	public void setTimes(String str) {
		if (!times.contains(str)) {
			times.add(str);
		}
	}

	public List<String> getTimes() {
		return times;
	}

}