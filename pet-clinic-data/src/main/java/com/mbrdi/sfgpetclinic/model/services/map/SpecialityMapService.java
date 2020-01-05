package com.mbrdi.sfgpetclinic.model.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.mbrdi.sfgpetclinic.model.Speciality;
import com.mbrdi.sfgpetclinic.model.services.SpecialityService;

@Service
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialityService{

	@Override
	public Speciality save(Speciality object) {
		return super.save( object);
	}
	
	public Set<Speciality> findAll(){
		return super.findAll();
	}
	
	public Speciality findById(Long id) {
		return super.findById(id);
	}
	
	public void delete(Speciality object) {
		super.delete(object);
	}
	
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}
