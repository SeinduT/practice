package com.seindu.ninjadojo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.seindu.ninjadojo.models.Dojo;
import com.seindu.ninjadojo.models.Ninja;
import com.seindu.ninjadojo.repositories.DojoRepository;
import com.seindu.ninjadojo.repositories.NinjaRepository;

@Service
public class AppService {
	private final DojoRepository dRepo;
	private final NinjaRepository nRepo;
	public AppService(DojoRepository dojoRepo, NinjaRepository ninjaRepo) {
		this.dRepo = dojoRepo;
		this.nRepo = ninjaRepo;
	}
	
	public Dojo createDojo(Dojo dojo) {
		return dRepo.save(dojo);
	}

	public Ninja createNinja(Ninja ninja) {
		return nRepo.save(ninja);
	}
	
	public List<Dojo> allDojos() {
		return dRepo.findAll();
	}
	
	public List<Ninja> allNinjas() {
		return nRepo.findAll();
	}
	
	public Dojo findDojo(Long id) {
		return this.dRepo.findById(id).orElse(null);
	}
	
}
