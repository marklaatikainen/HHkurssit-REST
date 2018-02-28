package fi.markl.lukkarit.model;

import java.io.Serializable;
import java.util.Objects;

public class MyKey implements Serializable {
	private String op_etunimi;	
	private String op_sukunimi;
	private String opintotunnus;

	private static final long serialVersionUID = 1L;
	
	public MyKey() {
		
	}
	
	public MyKey(String op_etunimi, String op_sukunimi, String opintotunnus) {
		this.op_etunimi = op_etunimi;
		this.op_sukunimi = op_sukunimi;
		this.opintotunnus = opintotunnus;
	}

	@Override
	  public boolean equals(Object o) {
	      if (this == o) return true;
	      if (o == null || getClass() != o.getClass()) return false;
	      MyKey taskId1 = (MyKey) o;
	      if (opintotunnus != taskId1.opintotunnus) return false;
	      return op_sukunimi == taskId1.op_sukunimi;
	  }

	  @Override
	  public int hashCode() {
	      return Objects.hash(opintotunnus, op_etunimi, op_sukunimi);
	  }
}
