package com.carloslizarazo.sena.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.carloslizarazo.sena.entities.Producto;
import com.carloslizarazo.sena.repositories.ProductoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ProductosController {
	
	@Autowired
	ProductoRepository productoRepository;
	
	@GetMapping("/iniciarproducto")
	public ResponseEntity<String> iniciarproducto() {
		ObjectMapper om = new ObjectMapper();
		Producto prod = new Producto();
		prod.setId("151515");
		prod.setNombre("Azucar");
		prod.setPrecio(15000.0);
		FileInputStream fis;
		try {
			fis = new FileInputStream("D:\\personal\\azucar-1024x683.jpg");
			prod.setFoto(fis.readAllBytes());			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		productoRepository.save(prod);
		return ResponseEntity.ok().body("azucar");
	}

	@GetMapping("/producto/{uuid}")
	public ResponseEntity<String> producto(@PathVariable("uuid") String uuid) {
		ObjectMapper om = new ObjectMapper();
		
		Optional<Producto> prod = productoRepository.findById(uuid);
		if (!prod.isPresent()) {
			return ResponseEntity.notFound().build();
		}
	    try {
			return ResponseEntity.ok().body(om.writeValueAsString(prod.get()));
		} catch (JsonProcessingException e) {
			return ResponseEntity.status(500).body("Error buscando " + uuid);
		}
	}
}
