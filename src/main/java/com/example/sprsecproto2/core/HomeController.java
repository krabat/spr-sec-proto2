package com.example.sprsecproto2.core;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
	
	@NonNull
	private final StoreService storeService;
	
	@GetMapping( "/" )
	public String index( Model model ) {
		model.addAttribute( "title", "Root - unprotected" );
		model.addAttribute( "root", storeService.update() );
		return "home";
	}
	
}
