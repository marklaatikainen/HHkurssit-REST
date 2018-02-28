package fi.markl.lukkarit.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "lukkari")
public class CourseWithHidden {

	@Id
	@Column(name = "opintotunnus")
	private String opintotunnus;
	@Column(name = "suoritustapa")
	private String suoritustapa;
	@Column(name = "exchange")
	private Boolean exchange;
	@Column(name = "ilta")
	private Boolean ilta;
	@Column(name = "kurssinimi")
	private String kurssinimi;
	@Column(name = "ala_fin")
	private String ala_fin;
	@Column(name = "ala_en")
	private String ala_en;
	@Column(name = "opetuskieli")
	private String opetuskieli;
	@Column(name = "opintopisteet")
	private int opintopisteet;
	@Column(name = "toimipiste")
	private String toimipiste;
	@Column(name = "ohjelma")
	private String ohjelma;
	@Column(name = "alkaa")
	private Date alkaa;
	@Column(name = "paattyy")
	private Date paattyy;
	@Column(name = "tyyli")
	private String tyyli;
	@Column(name = "link")
	private String linkki;
	@Column(name = "ajoitukset")
	private String ajoitukset;

	@Transient
	private List<Opettaja> opettaja;

	@Column(name = "poistettu")
	private Boolean poistettu;

	public CourseWithHidden() {
		super();
	}

	public CourseWithHidden(String opintotunnus, String suoritustapa, Boolean exchange, Boolean ilta, String kurssinimi,
			String ala_fin, String ala_en, String opetuskieli, int opintopisteet, String toimipiste, String ohjelma,
			Date alkaa, Date paattyy, String tyyli, String linkki, String ajoitukset, List<Opettaja> opettaja,
			Boolean poistettu) {
		super();
		this.opintotunnus = opintotunnus;
		this.suoritustapa = suoritustapa;
		this.exchange = exchange;
		this.ilta = ilta;
		this.kurssinimi = kurssinimi;
		this.ala_fin = ala_fin;
		this.ala_en = ala_en;
		this.opetuskieli = opetuskieli;
		this.opintopisteet = opintopisteet;
		this.toimipiste = toimipiste;
		this.ohjelma = ohjelma;
		this.alkaa = alkaa;
		this.paattyy = paattyy;
		this.tyyli = tyyli;
		this.linkki = linkki;
		this.ajoitukset = ajoitukset;
		this.opettaja = opettaja;
		this.poistettu = poistettu;
	}

	public String getOpintotunnus() {
		return opintotunnus;
	}

	public void setOpintotunnus(String opintotunnus) {
		this.opintotunnus = opintotunnus;
	}

	public String getSuoritustapa() {
		return suoritustapa;
	}

	public void setSuoritustapa(String suoritustapa) {
		this.suoritustapa = suoritustapa;
	}

	public Boolean getExchange() {
		return exchange;
	}

	public void setExchange(Boolean exchange) {
		this.exchange = exchange;
	}

	public Boolean getIlta() {
		return ilta;
	}

	public void setIlta(Boolean ilta) {
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

	public String getTyyli() {
		return tyyli;
	}

	public void setTyyli(String tyyli) {
		this.tyyli = tyyli;
	}

	public String getLinkki() {
		return linkki;
	}

	public void setLinkki(String linkki) {
		this.linkki = linkki;
	}

	public String getAjoitukset() {
		return ajoitukset;
	}

	public void setAjoitukset(String ajoitukset) {
		this.ajoitukset = ajoitukset;
	}

	public List<Opettaja> getOpettaja() {
		return opettaja;
	}

	public void setOpettaja(List<Opettaja> opettaja) {
		this.opettaja = opettaja;
	}

	public Boolean getPoistettu() {
		return poistettu;
	}

	public void setPoistettu(Boolean poistettu) {
		this.poistettu = poistettu;
	}
}
