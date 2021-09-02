package com.data.test;


public class Pets {
	private String id;
	private String name;
	private String birthDate;
	private Type type;
	private Owner owner;
	private Visits visits;
	public Pets(String id, String name, String birthDate, Type type, Owner owner, Visits visits) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.visits = visits;
		this.type = type;
		this.owner = owner;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public Visits getVisits() {
		return visits;
	}
	public void setVisits(Visits visits) {
		this.visits = visits;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	

}
