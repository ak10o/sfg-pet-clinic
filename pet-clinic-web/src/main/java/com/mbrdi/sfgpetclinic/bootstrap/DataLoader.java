package com.mbrdi.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mbrdi.sfgpetclinic.model.Owner;
import com.mbrdi.sfgpetclinic.model.Pet;
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
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedcatPetType = petTypeService.save(cat);
		
		System.out.println("Loaded petType");
		
		Owner owner = new Owner();
		owner.setFirstName("Salman");
		owner.setLastName("khan");
		owner.setAddress("Byrappa layout");
		owner.setCity("Bengaluru");
		owner.setTelephone("1234567819");
		
		Pet salmanPet = new Pet();
		salmanPet.setPetType(savedDogPetType);
		salmanPet.setOwner(owner);
		salmanPet.setBirthDate(LocalDate.now());
		salmanPet.setName("Rusty");
		
		owner.getPets().add(salmanPet);
		ownerService.save(owner);
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Shahrukh");
		owner1.setLastName("khan");
		owner1.setAddress("Vinayaka layout");
		owner1.setCity("Bengaluru");
		owner1.setTelephone("2134567819");
		
		Pet shahrukhPet = new Pet();
		shahrukhPet.setPetType(savedcatPetType);
		shahrukhPet.setOwner(owner1);
		shahrukhPet.setBirthDate(LocalDate.now());
		shahrukhPet.setName("Kitty");
		
		owner1.getPets().add(shahrukhPet);
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
