package fi.markl.lukkarit.model;

import java.util.ArrayList;

public class TimesOutput {

	private String Id = null;
	private String Name = null;
	private ArrayList<String> Time = null;
	private String Str = "";

	public TimesOutput() {
		super();
		Id = null;
		Name = null;
		Time = null;
		Str = "";
	}

	public TimesOutput(String id, String name, ArrayList<String> time, String str) {
		super();
		Id = id;
		Name = name;
		Time = time;
		Str = str;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public ArrayList<String> getTime() {
		return Time;
	}

	public void setTime(ArrayList<String> time) {
		Time = time;
	}

	public String getStr() {
		return Str;
	}

	public void setStr(String str) {
		Str = str;
	}

}
