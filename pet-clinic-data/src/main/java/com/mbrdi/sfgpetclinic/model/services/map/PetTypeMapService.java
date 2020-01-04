package com.mbrdi.sfgpetclinic.model.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.mbrdi.sfgpetclinic.model.PetType;
import com.mbrdi.sfgpetclinic.model.services.PetTypeService;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService{

	@Override
	public PetType save(PetType object) {
		return super.save( object);
	}
	 
	public Set<PetType> findAll(){
		return super.findAll();
	}
	
	public PetType findById(Long id) {
		return super.findById(id);
	}
	
	public void delete(PetType object) {
		super.delete(object);
	}
	
	public void deleteById(Long id) {
		super.deleteById(id);
	}
}
