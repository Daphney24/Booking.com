package com.data.test;

public class Visits {
	private int id;
	private String date;
	private String Prescription;
	private int pet;
	
	public Visits(int id, String date, String prescription, int pet) {
		super();
		this.id = id;
		this.date = date;
		Prescription = prescription;
		this.pet = pet;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPrescription() {
		return Prescription;
	}

	public void setPrescription(String prescription) {
		Prescription = prescription;
	}

	public int getPet() {
		return pet;
	}

	public void setPet(int pet) {
		this.pet = pet;
	}

}
