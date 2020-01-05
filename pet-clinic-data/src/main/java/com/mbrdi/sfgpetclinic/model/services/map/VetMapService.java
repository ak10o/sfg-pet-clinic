package com.mbrdi.sfgpetclinic.model.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.mbrdi.sfgpetclinic.model.Speciality;
import com.mbrdi.sfgpetclinic.model.Vet;
import com.mbrdi.sfgpetclinic.model.services.SpecialityService;
import com.mbrdi.sfgpetclinic.model.services.VetService;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService{

	private SpecialityService specialityService;
	
	public VetMapService(SpecialityService specialityService) {
	this.specialityService = specialityService;
}
	
@Override
	public Vet save(Vet object) {
		
		if ( object.getSpecialities().size() > 0 ) {
			// it make sures that the id is not null. if id is null then we are using getNextId
			// method of abstractMapService to generate the id.
			object.getSpecialities().forEach(speciality -> {
				if (speciality.getId() == null) {
					Speciality savedSpeciality = specialityService.save(speciality);
					speciality.setId(savedSpeciality.getId());
				}
			});
		}
		return super.save( object);
	}
	
	public Set<Vet> findAll(){
		return super.findAll();
	}
	
	public Vet findById(Long id) {
		return super.findById(id);
	}
	
	public void delete(Vet object) {
		super.delete(object);
	}
	
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}
