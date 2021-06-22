package com.arsuarez.com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.arsuarez.com.entity.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario , Long> {

}
