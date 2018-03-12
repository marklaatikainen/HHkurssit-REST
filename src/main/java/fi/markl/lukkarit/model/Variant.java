package fi.markl.lukkarit.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Variant {
	@Id
	private String variant;

	public Variant() {

	}

	public Variant(String variant) {
		super();
		this.variant = variant;
	}

	public String getvariant() {
		return variant;
	}

	public void setvariant(String variant) {
		this.variant = variant;
	}

}