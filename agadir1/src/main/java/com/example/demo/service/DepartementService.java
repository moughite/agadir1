package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Departement;
import com.example.demo.repository.DepartementRepository;

@Service
public class DepartementService {

	@Autowired
	DepartementRepository departementRepository;

	public List<Departement> findAllDepartement() {
		return departementRepository.findAll();
	}

	public Departement findDepartementById(long id) {
		return departementRepository.findById(id).orElseThrow(null);
	}

	public void addDepartement(Departement dep) {
		departementRepository.save(dep);
	}

	public void updateDepartement(Departement dep) {
		departementRepository.save(dep);
	}

	public void deleteDepartementById(long id) {
		departementRepository.deleteById(id);
	}

}
