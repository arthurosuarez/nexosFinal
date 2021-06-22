package com.arsuarez.com.service;

import com.arsuarez.com.controllers.dto.producto.ProductoDTO;
import com.arsuarez.com.controllers.dto.producto.ResponseProductoDTO;
import com.arsuarez.com.entity.*;
import com.arsuarez.com.repository.ProductoRepository;
import com.arsuarez.com.service.implement.IProductoService;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private ProductoRepository productoRepository;
        
    
	private String mensaje;


    
    @Override
    public List<Producto> findAll() {

        var productos = (List<Producto>) productoRepository.findAll();

        return productos;
    }


    @Override
	public ResponseProductoDTO guardar(ProductoDTO productoDTO) {
    	
    	ResponseProductoDTO responseProductoDTO = new ResponseProductoDTO();
    	System.out.println( " producto_DTO : " + productoDTO.getNombre() );

    	String mensaje = "";
    	ModelMapper modelMapper = new ModelMapper();
    	Producto producto = modelMapper.map(productoDTO, Producto.class);
    	
    	if(productoRepository.findByNombre(productoDTO.getNombre()) == null) {
	    	try {
	    		Producto res = productoRepository.save(producto);
	    		responseProductoDTO.setMensaje("Registro guardado correctamente");
	    		responseProductoDTO.setResult(true);
	    	}
	    	catch(Exception ex){
	    		responseProductoDTO.setMensaje("Error al guardar el registro");
	    		responseProductoDTO.setResult(false);	
	    	}	    		
    	}
    	else {
    		responseProductoDTO.setMensaje("Registro ya existe.");
    		responseProductoDTO.setResult(false);
	    }
    	
        return responseProductoDTO;
        
        
    }
    
    
    
    
    @Override
	public ResponseProductoDTO editar(ProductoDTO productoDTO) {
    	
    	ResponseProductoDTO responseProductoDTO = new ResponseProductoDTO();
    	System.out.println( " producto_DTO : " + productoDTO.getNombre() );

    	String mensaje = "";
    	ModelMapper modelMapper = new ModelMapper();
    	Producto producto = modelMapper.map(productoDTO, Producto.class);
    	
    	if(productoRepository.existsById(producto.getCodigo())) {
	    	try {
	    		Producto res = productoRepository.save(producto);
	    		responseProductoDTO.setMensaje("Registro editado correctamente");
	    		responseProductoDTO.setResult(true);
	    	}
	    	catch(Exception ex){
	    		responseProductoDTO.setMensaje("Error al editar el registro");
	    		responseProductoDTO.setResult(false);	
	    	}	    		
    	}
    	else {
    		responseProductoDTO.setMensaje("Registro no existe.");
    		responseProductoDTO.setResult(false);
	    }
    	
        return responseProductoDTO;
        
    }
    
    
    
    @Override
	public ResponseProductoDTO eliminar(Long codigo) {
    	
    	ResponseProductoDTO responseProductoDTO = new ResponseProductoDTO();

    	String mensaje = "";
    	
    	if(productoRepository.existsById(codigo)) {
	    	try {
	    		productoRepository.deleteById( codigo );
	    		responseProductoDTO.setMensaje("Registro Eliminado correctamente");
	    		responseProductoDTO.setResult(true);
	    	}
	    	catch(Exception ex){
	    		responseProductoDTO.setMensaje("Error al eliminar el registro");
	    		responseProductoDTO.setResult(false);	
	    	}	    		
    	}
    	else {
    		responseProductoDTO.setMensaje("Registro no existe.");
    		responseProductoDTO.setResult(false);
	    }
    	
        return responseProductoDTO;
        
       
    }
}