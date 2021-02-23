package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Departement;
import com.example.demo.model.Employee;
import com.example.demo.service.DepartementService;
import com.example.demo.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Employee Controller", description = "das ist einen Dischription über Employee Controller")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	DepartementService departementService;

	@ApiOperation(value = "find all Employee", response = Employee.class)

	@ApiResponses(value = { @ApiResponse(code = 500, message = "server Error"),
			@ApiResponse(code = 404, message = "service not found"), @ApiResponse(code = 200, message = "Successful") })
	@GetMapping("/employee")
	private List<Employee> findAllEmployee() {
		return employeeService.getFindAllEmployee();
	}

	@GetMapping("/employee/{id}")
	private Employee findEmployeeById(@PathVariable long id) {
		return employeeService.getFindEmployeeById(id);
	}

	@GetMapping("/dep/{dep_id}/emp")
	private List<Employee> findEmployeeByIdAndDepartementId(@PathVariable long dep_id) {
		return employeeService.getFindEmployeeByIdAndDepartementId(dep_id);
	}

	@GetMapping("/employeefnln/{fn}/{ln}")
	private List<Employee> FindEmployeeByFirstandLastName(@PathVariable String fn, @PathVariable String ln) {
		return employeeService.getfindByfirstnameAndLastName(fn, ln);
	}

	@GetMapping("/employeefn/{fn}")
	private List<Employee> FindEmployeeByFirst(@PathVariable String fn) {
		return employeeService.getfindByfirstname(fn);
	}

	@PostMapping("/empployeeadd/{id}")
	private ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee emp, @PathVariable long id) {

		Departement dep = departementService.findDepartementById(id);
		emp.setDep(dep);
		employeeService.addEmployee(emp);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

	@PutMapping("/empployeeupdate")
	private ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp, @PathVariable long id) {

		Departement dep = departementService.findDepartementById(id);
		emp.setDep(dep);

		employeeService.updateEmployee(emp);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

	@DeleteMapping("/dep/{dep_id}/emp/{emp_id}")
	private String deleteEmployee(@PathVariable long dep_id,@PathVariable long emp_id) {
		
		
		employeeService.deleteEmployeeById(emp_id);
		
//		 return assignmentRepository.findById(assignmentId)
//	                .map(assignment -> {
//	                    assignmentRepository.delete(assignment);
//	                    return "Deleted Successfully!";
//	                }).orElseThrow(() -> new NotFoundException("Contact not found!"));
		return "deleted with success";
	}

}
