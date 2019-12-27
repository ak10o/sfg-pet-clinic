package com.mbrdi.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mbrdi.sfgpetclinic.model.Owner;
import com.mbrdi.sfgpetclinic.model.Vet;
import com.mbrdi.sfgpetclinic.model.services.OwnerService;
import com.mbrdi.sfgpetclinic.model.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	
	private final VetService vetService;
	
	public DataLoader(OwnerService ownerService, VetService vetService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
	}



	@Override
	public void run(String... args) throws Exception {
		
		Owner owner = new Owner();
		owner.setId(1L);
		owner.setFirstName("Salman");
		owner.setLastName("khan");
		
		ownerService.save(owner);
		
		Owner owner1 = new Owner();
		owner1.setId(2L);
		owner1.setFirstName("Shahrukh");
		owner1.setLastName("khan");

		ownerService.save(owner1);
		
		System.out.println("Loaded owners");
		
		Vet vet = new Vet();
		vet.setId(1L);
		vet.setFirstName("Sam");
		vet.setLastName("Axe");
		
		vetService.save(vet);
		
		Vet vet1 = new Vet();
		vet1.setId(2L);
		vet1.setFirstName("Jossie");
		vet1.setLastName("Porter");
		
		vetService.save(vet1);
		
		System.out.println("Loaded vets");
	}

	
}
