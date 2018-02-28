package fi.markl.lukkarit.model;

import fi.markl.lukkarit.Methods;

public class Options {
	private Methods method;
	private String path;
	private String description;
	
	public Options() {
		super();
		this.method = null;
		this.path = null;
		this.description = null;
	}
	
	public Options(Methods method, String path, String description) {
		super();
		this.method = method;
		this.path = path;
		this.description = description;
	}
	
	public Methods getMethod() {
		return method;
	}

	public void setMethod(Methods method) {
		this.method = method;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
