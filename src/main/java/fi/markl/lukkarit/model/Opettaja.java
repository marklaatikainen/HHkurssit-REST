package fi.markl.lukkarit.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(MyKey.class)
public class Opettaja {

	@Id
	private String op_etunimi;
	
	@Id	
	private String op_sukunimi;
	
	@Id
	private String opintotunnus;

	public Opettaja() {

	}

	public Opettaja(String op_etunimi, String op_sukunimi, String opintotunnus) {
		this.op_etunimi = op_etunimi;
		this.op_sukunimi = op_sukunimi;
		this.opintotunnus = opintotunnus;
	}

	public void setOpe_etunimi(String op_etunimi) {
		this.op_etunimi = op_etunimi;
	}

	public void setOpe_sukunimi(String op_sukunimi) {
		this.op_sukunimi = op_sukunimi;
	}

	public void setOpintotunnus(String opintotunnus) {
		this.opintotunnus = opintotunnus;
	}

	public String getOpe_etunimi() {
		return op_etunimi;
	}

	public String getOpe_sukunimi() {
		return op_sukunimi;
	}

	public String getOpintotunnus() {
		return opintotunnus;
	}
}