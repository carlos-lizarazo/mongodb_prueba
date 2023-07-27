package com.carloslizarazo.sena.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.carloslizarazo.sena.entities.Producto;

public interface ProductoRepository extends MongoRepository<Producto, String> {
    // 
}