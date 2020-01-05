package com.mbrdi.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mbrdi.sfgpetclinic.model.Owner;
import com.mbrdi.sfgpetclinic.model.Pet;
import com.mbrdi.sfgpetclinic.model.PetType;
import com.mbrdi.sfgpetclinic.model.Speciality;
import com.mbrdi.sfgpetclinic.model.Vet;
import com.mbrdi.sfgpetclinic.model.services.OwnerService;
import com.mbrdi.sfgpetclinic.model.services.PetTypeService;
import com.mbrdi.sfgpetclinic.model.services.SpecialityService;
import com.mbrdi.sfgpetclinic.model.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;
	
	public DataLoader(OwnerService ownerService, VetService vetService,PetTypeService petTypeService,SpecialityService specialityService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
	}

	@Override
	public void run(String... args) throws Exception {
		
		// performed this changes so that it can be used with JPA and mysql implementation
		int count = petTypeService.findAll().size();
		
		if (count == 0) {
			loadData();
		}
	}

	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedcatPetType = petTypeService.save(cat);
		
		System.out.println("Loaded petType");
		
		Speciality radiology = new Speciality();
		radiology.setDescription("Radiology");
		//persisting the data to map, it will generate the id value also.
		Speciality savedRadiology = specialityService.save(radiology);

		Speciality surgery = new Speciality();
		surgery.setDescription("Surgery");
		Speciality savedSurgery = specialityService.save(surgery);
		
		Speciality dentistry = new Speciality();
		dentistry.setDescription("Dentistry");
		Speciality savedDentistry = specialityService.save(dentistry);
		
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
		vet.getSpecialities().add(savedRadiology);
		
		vetService.save(vet);
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Jossie");
		vet1.setLastName("Porter");
		vet1.getSpecialities().add(savedSurgery);
		vetService.save(vet1);
		
		System.out.println("Loaded vets");
	}
}
