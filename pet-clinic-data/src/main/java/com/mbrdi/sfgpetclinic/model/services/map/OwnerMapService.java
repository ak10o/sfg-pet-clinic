package com.mbrdi.sfgpetclinic.model.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.mbrdi.sfgpetclinic.model.Owner;
import com.mbrdi.sfgpetclinic.model.Pet;
import com.mbrdi.sfgpetclinic.model.services.OwnerService;
import com.mbrdi.sfgpetclinic.model.services.PetService;
import com.mbrdi.sfgpetclinic.model.services.PetTypeService;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService{

	private PetService petService;
	private PetTypeService petTypeService;
	
	public OwnerMapService(PetService petService, com.mbrdi.sfgpetclinic.model.services.PetTypeService petTypeService) {
		super();
		this.petService = petService;
		this.petTypeService = petTypeService;
	}

	@Override
	public Owner save(Owner object) {
		// if the petType or pet id is null then we are setting the id value and synchronizing 
		//the id among owner,pet,petType.
		if ( object != null) {
			if ( object.getPets() != null) {
				object.getPets().forEach(pet -> 
				{ 
					if (pet.getPetType() != null) {
						if (pet.getPetType().getId() == null) {
							pet.setPetType(petTypeService.save(pet.getPetType()));
						}
					} else {
						throw new RuntimeException("Pet type is required");
					}
					if ( pet.getId() == null) {
						Pet savedPet = petService.save(pet);
						pet.setId(savedPet.getId());
					}
				});
			}
			return super.save( object);
		}else {
			return null;
		}
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
