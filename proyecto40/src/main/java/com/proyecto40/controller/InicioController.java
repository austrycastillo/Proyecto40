package com.proyecto40.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("proyecto40")
public class InicioController {
	
	public static final String VISTA_INDEX = "index";
	public static final String VISTA_NOSOTROS = "nosotros";
	public static final String VISTA_CONTACTO = "contacto";
	
	@GetMapping("index")
	public String mostrarIndex() {
		return VISTA_INDEX;
	}
	@GetMapping("nosotros")
	public String mostrarNosotros() {
		return VISTA_NOSOTROS;
	}
	@GetMapping("contacto")
	public String mostrarContacto() {
		return VISTA_CONTACTO;
	}
	
}
