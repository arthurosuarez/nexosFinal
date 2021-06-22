package com.arsuarez.com.service.implement;

import com.arsuarez.com.controllers.dto.producto.ProductoDTO;
import com.arsuarez.com.controllers.dto.producto.ResponseProductoDTO;
import com.arsuarez.com.entity.Producto;



import java.util.List;

public interface IProductoService {

    public List<Producto> findAll();

	public ResponseProductoDTO guardar(ProductoDTO productoDTO);
	
	public ResponseProductoDTO editar(ProductoDTO productoDTO);

	public ResponseProductoDTO eliminar(Long codigo);

}