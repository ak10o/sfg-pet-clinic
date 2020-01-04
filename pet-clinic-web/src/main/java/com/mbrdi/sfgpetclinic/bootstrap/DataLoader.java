package com.mbrdi.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mbrdi.sfgpetclinic.model.Owner;
import com.mbrdi.sfgpetclinic.model.PetType;
import com.mbrdi.sfgpetclinic.model.Vet;
import com.mbrdi.sfgpetclinic.model.services.OwnerService;
import com.mbrdi.sfgpetclinic.model.services.PetTypeService;
import com.mbrdi.sfgpetclinic.model.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	
	public DataLoader(OwnerService ownerService, VetService vetService,PetTypeService petTypeService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}

	@Override
	public void run(String... args) throws Exception {
		
		PetType dog = new PetType();
		dog.setName("Rusty");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("kitty");
		PetType savedcatPetType = petTypeService.save(cat);
		
		System.out.println("Loaded petType");
		
		Owner owner = new Owner();
		owner.setFirstName("Salman");
		owner.setLastName("khan");
		
		ownerService.save(owner);
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Shahrukh");
		owner1.setLastName("khan");

		ownerService.save(owner1);
		
		System.out.println("Loaded owners");
		
		Vet vet = new Vet();
		vet.setFirstName("Sam");
		vet.setLastName("Axe");
		
		vetService.save(vet);
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Jossie");
		vet1.setLastName("Porter");
		
		vetService.save(vet1);
		
		System.out.println("Loaded vets");
	}
}
