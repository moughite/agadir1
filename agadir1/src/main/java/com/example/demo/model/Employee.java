package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Required;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "Employee")
@ApiModel(value = "Employee Model", description = " das ist den Model  von Employee!")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "Id von den Employee")
	private long id;

	@NotNull(message = "not null attribut")
	@Column(name = "FirstName")
	private String firstName;

	@NotNull(message = "not null attribut")
	@Column(name = "LastName")
	private String lastName;

	@Column(name = "Salary")
	private long salary;

	@Column(name = "Adresse")
	private String adresse;
	
		
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Departement_id", nullable = false)
	@JsonIgnore
	private Departement departement;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(long id, String fistName, String lastName, long salary, String adresse, Departement dep) {
		super();
		this.id = id;
		this.firstName = fistName;
		this.lastName = lastName;
		this.salary = salary;
		this.adresse = adresse;
		this.departement = dep;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFistName() {
		return firstName;
	}

	public void setFistName(String fistName) {
		this.firstName = fistName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Departement getDep() {
		return departement;
	}

	public void setDep(Departement dep) {
		this.departement = dep;
	}

}
