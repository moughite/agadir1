package com.example.demo.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;

import org.hibernate.annotations.CascadeType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "Departement")
@ApiModel(value = "Departement Model", description = "das ist einen Departement Model")
public class Departement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "das ist einen auto Generierten id ", required = true)
	private long id;

	@Max(message = "muss nicht mehr als 20 charactere",value = 20)
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "departement", cascade = javax.persistence.CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Employee> employee;

	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Departement(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}

}
