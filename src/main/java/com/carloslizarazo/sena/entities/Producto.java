package com.carloslizarazo.sena.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Producto {
	@Id
	private String id;
	private String nombre;
	private String [] alias;
	private String [] categorias;
	private byte [] foto;
	private Double precio;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String[] getAlias() {
		return alias;
	}
	public void setAlias(String[] alias) {
		this.alias = alias;
	}
	public String[] getCategorias() {
		return categorias;
	}
	public void setCategorias(String[] categorias) {
		this.categorias = categorias;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
}
