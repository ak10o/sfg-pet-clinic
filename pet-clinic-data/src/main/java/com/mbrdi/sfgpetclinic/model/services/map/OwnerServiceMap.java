package com.mbrdi.sfgpetclinic.model.services.map;

import java.util.Set;

import com.mbrdi.sfgpetclinic.model.Owner;
import com.mbrdi.sfgpetclinic.model.services.OwnerService;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService{

	@Override
	public Owner save(Owner object) {
		return super.save(object.getId(), object);
	}
	
	public Set<Owner> findAll(){
		return super.findAll();
	}
	
	public Owner findById(Long id) {
		return super.findById(id);
	}
	
	public void delete(Owner object) {
		super.delete(object);
	}
	
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public Owner findByLastName(String name) {
		return null;
	}

}
