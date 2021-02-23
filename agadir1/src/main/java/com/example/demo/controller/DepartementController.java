package com.example.demo.controller;

import java.util.List;

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
import com.example.demo.service.DepartementService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Departement Contoller", description = "das ist einen Departement Controller")
public class DepartementController {

	@Autowired
	DepartementService departementService;

	@ApiOperation(value = "findAllDepartement", response = Departement.class)
	@ApiResponses(value = @ApiResponse(code = 200, message = "Success"))
	@GetMapping("/departement")
	private List<Departement> findAllDepartement() {
		return departementService.findAllDepartement();
	}

	@GetMapping("/departement/{id}")
	private Departement findDepartementById(@PathVariable long id) {
		return departementService.findDepartementById(id);
	}

	@PostMapping("/departementadd")
	private ResponseEntity<Departement> addDepartement(@RequestBody Departement dep) {
		departementService.addDepartement(dep);
		return new ResponseEntity<Departement>(dep, HttpStatus.OK);
	}

	@PutMapping("/departementupdate")
	private ResponseEntity<Departement> updateDepartement(@RequestBody Departement dep) {
		departementService.addDepartement(dep);
		return new ResponseEntity<Departement>(dep, HttpStatus.OK);
	}

	@DeleteMapping("/departementdelete/{id}")
	private ResponseEntity<Departement> deleteDep(@PathVariable long id) {
		departementService.deleteDepartementById(id);
		return new ResponseEntity<Departement>(HttpStatus.OK);
	}
}
