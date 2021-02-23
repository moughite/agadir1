package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.error.RecordNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> getFindAllEmployee(){
		return employeeRepository.findAll();
	}
	
	public Employee getFindEmployeeById(long id) {
		return employeeRepository.findById(id).orElseThrow(()-> new RecordNotFoundException(id +" this emp not found"));
	}
	
	public List<Employee> getFindEmployeeByIdAndDepartementId(long depId) {
		return employeeRepository.findEmployeeByDepartementId(depId);
	}
	
	public List<Employee> getfindByfirstname(String fn){
		return employeeRepository.findEmployeeByfirstName(fn);
	}
	
	public List<Employee> getfindByfirstnameAndLastName(String fn,String ln){
		return employeeRepository.findEmployeeByfirstNameAndlastName(fn, ln);
	}
	
	public void addEmployee(Employee emp){
		employeeRepository.save(emp);		
	}
	
	public void updateEmployee(Employee emp){
		employeeRepository.save(emp);		
	}
	
	public void deleteEmployeeById(long id){
		employeeRepository.deleteById(id);	
	}
	
	public void deleteEmployee(long  id){
		employeeRepository.deleteById(id);
	}
	
}
