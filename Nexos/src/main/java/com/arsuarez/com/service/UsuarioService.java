package com.arsuarez.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arsuarez.com.controllers.dto.producto.ProductoDTO;
import com.arsuarez.com.entity.Producto;
import com.arsuarez.com.entity.Usuario;
import com.arsuarez.com.repository.UsuarioRepository;
import com.arsuarez.com.service.implement.IUsuarioService;


import com.arsuarez.com.entity.Usuario;

@Service
public class UsuarioService implements IUsuarioService{

	@Autowired
	UsuarioRepository usuarioRepository;
	

    @Override
    public List<Usuario> findAll() {

        var productos = (List<Usuario>) usuarioRepository.findAll();

        return productos;
    }



}
