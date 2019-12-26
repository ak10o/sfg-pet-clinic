package com.mbrdi.sfgpetclinic.model.services;

import com.mbrdi.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

	Owner findByLastName(String name);
}
