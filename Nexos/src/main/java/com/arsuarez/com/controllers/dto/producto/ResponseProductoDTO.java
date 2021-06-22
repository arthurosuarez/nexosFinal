package com.arsuarez.com.controllers.dto.producto;

public class ResponseProductoDTO {
	
	public ProductoDTO productoDTO;
	public Boolean result;
	public String mensaje;
	
	
	public ProductoDTO getProductoDTO() {
		return productoDTO;
	}
	public Boolean getResult() {
		return result;
	}
	public String getMensaje() {
		return mensaje;
	}
	
	
	public void setProductoDTO(ProductoDTO productoDTO) {
		this.productoDTO = productoDTO;
	}
	public void setResult(Boolean result) {
		this.result = result;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	public ResponseProductoDTO(ProductoDTO productoDTO, Boolean result, String mensaje) {
		this.productoDTO = productoDTO;
		this.result = result;
		this.mensaje = mensaje;
	}
	
	
	public ResponseProductoDTO() {
		
	}
	
	
	
	
	
}
