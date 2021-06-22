package com.arsuarez.com.controllers;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.arsuarez.com.controllers.dto.producto.ProductoDTO;
import com.arsuarez.com.controllers.dto.producto.ResponseProductoDTO;
import com.arsuarez.com.entity.*;
import com.arsuarez.com.service.ProductoService;
import com.arsuarez.com.service.UsuarioService;
import com.sun.istack.NotNull;


@Controller
@RequestMapping("/")
public class InventarioController {

	@Autowired
	ProductoService productoService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	ProductoService productoProducto;
	
	@GetMapping( path = {"/inventario" , ""})
	public String getInvenario(Model model) {
				
		model.addAttribute("productos" , productoService.findAll());
		model.addAttribute("usuarios" , usuarioService.findAll());
		return "index";
	}
	

	@RequestMapping( path = "/registrarProductoAcc")
	public String registrarProducto(Model model, @Validated ProductoDTO productoDTO ) {
		
		System.out.println("producto_edit" + productoDTO.getNombre());
		ResponseProductoDTO responseProductoDTO = productoProducto.guardar(productoDTO);
		
		model.addAttribute("productos" , productoService.findAll());
		model.addAttribute("usuarios" , usuarioService.findAll());
		
		model.addAttribute("result" , responseProductoDTO.getResult() );
		model.addAttribute("mensaje" , responseProductoDTO.getMensaje() );
		
		return "index";
	}
	
	@RequestMapping( path = "/editarProductoAcc")
	public String editarProducto(Model model, @Validated ProductoDTO productoDTO ) {
		System.out.println("producto_edit" + productoDTO.getNombre());
		ResponseProductoDTO responseProductoDTO = productoProducto.guardar(productoDTO);
		
		model.addAttribute("productos" , productoService.findAll());
		model.addAttribute("usuarios" , usuarioService.findAll());
		
		model.addAttribute("result" , responseProductoDTO.getResult() );
		model.addAttribute("mensaje" , responseProductoDTO.getMensaje() );
		
		return "index";
	}
	
	
    @RequestMapping(value = "/eliminarProductoAcc", method = RequestMethod.GET)
	public String eliminarProducto(
			Model model, 
			@RequestParam(value = "codigo") @NotNull Long codigo
	) {
		ResponseProductoDTO responseProductoDTO = productoProducto.eliminar(codigo);
		
		model.addAttribute("productos" , productoService.findAll());
		model.addAttribute("usuarios" , usuarioService.findAll());
		
		model.addAttribute("result" , responseProductoDTO.getResult() );
		model.addAttribute("mensaje" , responseProductoDTO.getMensaje() );
		
		return "index";
	}
	

	
	
}
