package com.matheusrabelo.mr.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
// ele irá responder por esse endereço  (value="/categorias")
public class CategoriaResource {

	// ira obter um dado pelo method get
	@RequestMapping(method = RequestMethod.GET)
	public String Listar() {
		return "REST está funcionando";
	}

}
