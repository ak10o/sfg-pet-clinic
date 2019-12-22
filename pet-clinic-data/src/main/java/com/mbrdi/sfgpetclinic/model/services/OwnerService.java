package com.mbrdi.sfgpetclinic.model.services;

import java.util.Set;

import com.mbrdi.sfgpetclinic.model.Owner;

public interface OwnerService {

	Owner findByLastName(String name);
	
	Owner findById(Long id);
	
	Set<Owner> findAll();
	
	Owner save(Owner owner);
}
