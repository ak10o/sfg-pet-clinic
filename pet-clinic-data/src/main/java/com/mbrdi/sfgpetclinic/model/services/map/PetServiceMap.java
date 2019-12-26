package com.mbrdi.sfgpetclinic.model.services.map;

import java.util.Set;

import com.mbrdi.sfgpetclinic.model.Pet;
import com.mbrdi.sfgpetclinic.model.services.CrudService;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long>{

	
	@Override
	public Pet save(Pet object) {
		return super.save(object.getId(), object);
	}
	
	public Set<Pet> findAll(){
		return super.findAll();
	}
	
	public Pet findById(Long id) {
		return super.findById(id);
	}
	
	public void delete(Pet object) {
		super.delete(object);
	}
	
	public void deleteById(Long id) {
		super.deleteById(id);
	}
}
