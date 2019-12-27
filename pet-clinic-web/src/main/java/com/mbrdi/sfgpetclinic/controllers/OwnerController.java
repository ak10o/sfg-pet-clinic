package com.mbrdi.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mbrdi.sfgpetclinic.model.services.OwnerService;

@Controller
@RequestMapping("/owners")
public class OwnerController {

	private OwnerService ownerService;
	
	public OwnerController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}

	@RequestMapping({"","/index","/index.html"})
	public String listOwners(Model model) {
		
		model.addAttribute("owners", ownerService.findAll());
		
		return "owners/index";
	}
}
