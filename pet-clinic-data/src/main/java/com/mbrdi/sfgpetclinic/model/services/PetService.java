package com.mbrdi.sfgpetclinic.model.services;

import java.util.Set;

import com.mbrdi.sfgpetclinic.model.Owner;
import com.mbrdi.sfgpetclinic.model.Pet;

public interface PetService {

	Pet findById(Long id);

	Set<Pet> findAll();

	Owner save(Pet pet);
}
