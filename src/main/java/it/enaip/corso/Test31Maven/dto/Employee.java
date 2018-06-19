package it.enaip.corso.Test31Maven.dto;

import java.time.LocalDate;

public class Employee {	//dto

	private long idUser;
	private String name;
	private String surname;
	private LocalDate date;

	public Employee(long idUser, String name, String surname, LocalDate date) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.surname = surname;
		this.date = date;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + (int) (idUser ^ (idUser >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (idUser != other.idUser)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Employee [id= " + idUser + ", name= " + name + ", surname= " + surname + ", date= " + date + "]";
	}
	
	
	//Metodi getter
	public long getIdUser() {
		return idUser;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public LocalDate getDate() {
		return date;
	}
	
	//Metodi setter
	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

}
