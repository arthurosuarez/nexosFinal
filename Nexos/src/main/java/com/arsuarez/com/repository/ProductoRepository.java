package com.arsuarez.com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import  com.arsuarez.com.entity.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto , Long> {

	public Producto findByNombre(String nombre);
}
