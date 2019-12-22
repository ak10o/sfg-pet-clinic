package com.mbrdi.sfgpetclinic.model.services;

import java.util.Set;

import com.mbrdi.sfgpetclinic.model.Owner;
import com.mbrdi.sfgpetclinic.model.Vet;

public interface VetService {

	Vet findById(Long id);

	Set<Vet> findAll();

	Owner save(Vet vet);
}
