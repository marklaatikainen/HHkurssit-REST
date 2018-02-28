package fi.markl.lukkarit.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ryhma_kurssi")
public class Group {

	@Id
	@Column(name = "kurssi_id")
	private String kurssi_id;
	private String kurssinimi;
	private String ryhma_ID;
	private String suoritustapa;
	private boolean exchange;
	private boolean ilta;
	private String ala_fin;
	private String ala_en;
	private String opetuskieli;
	private int opintopisteet;
	private String toimipiste;
	private String ohjelma;
	private Date alkaa;
	private Date paattyy;
	private String link;
	private String tyyli;

	@Transient
	private List<Opettaja> opettaja;
	
	public Group() {
		
	}
	
	public Group(String kurssi_id, String kurssinimi, String ryhma_ID, String suoritustapa, boolean exchange, boolean ilta,
			String ala_fin, String ala_en, String opetuskieli, int opintopisteet, String toimipiste,
			String ohjelma, Date alkaa, Date paattyy, String link, String tyyli) {
		super();
		this.kurssi_id = kurssi_id;
		this.kurssinimi = kurssinimi;
		this.ryhma_ID = ryhma_ID;
		this.suoritustapa = suoritustapa;
		this.exchange = exchange;
		this.ilta = ilta;
		this.ala_fin = ala_fin;
		this.ala_en = ala_en;
		this.opetuskieli = opetuskieli;
		this.opintopisteet = opintopisteet;
		this.toimipiste = toimipiste;
		this.ohjelma = ohjelma;
		this.alkaa = alkaa;
		this.paattyy = paattyy;
		this.link = link;
		this.tyyli = tyyli;
	}

	public String getKurssi_id() {
		return kurssi_id;
	}

	public void setKurssi_id(String kurssi_id) {
		this.kurssi_id = kurssi_id;
	}

	public String getRyhma_ID() {
		return ryhma_ID;
	}

	public void setRyhma_ID(String ryhma_ID) {
		this.ryhma_ID = ryhma_ID;
	}

	public String getSuoritustapa() {
		return suoritustapa;
	}

	public void setSuoritustapa(String suoritustapa) {
		this.suoritustapa = suoritustapa;
	}

	public boolean isExchange() {
		return exchange;
	}

	public void setExchange(boolean exchange) {
		this.exchange = exchange;
	}

	public boolean isIlta() {
		return ilta;
	}

	public void setIlta(boolean ilta) {
		this.ilta = ilta;
	}

	public String getKurssinimi() {
		return kurssinimi;
	}

	public void setKurssinimi(String kurssinimi) {
		this.kurssinimi = kurssinimi;
	}

	public String getAla_fin() {
		return ala_fin;
	}

	public void setAla_fin(String ala_fin) {
		this.ala_fin = ala_fin;
	}

	public String getAla_en() {
		return ala_en;
	}

	public void setAla_en(String ala_en) {
		this.ala_en = ala_en;
	}

	public String getOpetuskieli() {
		return opetuskieli;
	}

	public void setOpetuskieli(String opetuskieli) {
		this.opetuskieli = opetuskieli;
	}

	public int getOpintopisteet() {
		return opintopisteet;
	}

	public void setOpintopisteet(int opintopisteet) {
		this.opintopisteet = opintopisteet;
	}

	public String getToimipiste() {
		return toimipiste;
	}

	public void setToimipiste(String toimipiste) {
		this.toimipiste = toimipiste;
	}

	public String getOhjelma() {
		return ohjelma;
	}

	public void setOhjelma(String ohjelma) {
		this.ohjelma = ohjelma;
	}

	public Date getAlkaa() {
		return alkaa;
	}

	public void setAlkaa(Date alkaa) {
		this.alkaa = alkaa;
	}

	public Date getPaattyy() {
		return paattyy;
	}

	public void setPaattyy(Date paattyy) {
		this.paattyy = paattyy;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTyyli() {
		return tyyli;
	}

	public void setTyyli(String tyyli) {
		this.tyyli = tyyli;
	}

	public List<Opettaja> getOpettaja() {
		return opettaja;
	}

	public void setOpettaja(List<Opettaja> opettaja) {
		this.opettaja = opettaja;
	}
	
	
}
