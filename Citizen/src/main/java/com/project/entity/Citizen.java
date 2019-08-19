package com.project.entity;

public class Citizen {

	@id
	private Long citizenID;
	private String forenames;
	private String surname;
	private String homeAddress;
	private String dateOfBirth;
	private String placeOfBirth;
	private String sex;

	public Citizen() {

	}

	public Citizen(Long citizenID, String forenames, String surname, String homeAddress, String dateOfBirth,
			String placeOfBirth, String sex) {
		super();
		this.citizenID = citizenID;
		this.forenames = forenames;
		this.surname = surname;
		this.homeAddress = homeAddress;
		this.dateOfBirth = dateOfBirth;
		this.placeOfBirth = placeOfBirth;
		this.sex = sex;
	}

	public Long getCitizenID() {
		return citizenID;
	}

	public void setCitizenID(Long citizenID) {
		this.citizenID = citizenID;
	}

	public String getForenames() {
		return forenames;
	}

	public void setForenames(String forenames) {
		this.forenames = forenames;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
