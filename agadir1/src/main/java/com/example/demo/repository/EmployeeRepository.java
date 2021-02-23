package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	public List<Employee> findEmployeeByfirstName(String firstName);
	
	public List<Employee> findEmployeeByDepartementId(long dep_id);

	@Query("select emp from Employee emp where emp.firstName=:firstName and emp.lastName=:lastName")
	public List<Employee> findEmployeeByfirstNameAndlastName(@Param("firstName") String firstName,
			@Param("lastName") String lastName);

}
