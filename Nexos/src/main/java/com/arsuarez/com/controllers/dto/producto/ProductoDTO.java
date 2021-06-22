package com.arsuarez.com.controllers.dto.producto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import lombok.*;
import javax.validation.constraints.*;

/*@Data
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)*/

public class ProductoDTO {


    public Long codigo;
    
    @NotNull
	public String nombre;
	
    @NotNull
    @Digits(fraction = 0, integer = 5, message = "Cantidad debe ser un numero de 5 digitos o menos.")
	public Integer cantidad;
	
    @NotNull
	public String fechaIngreso;
	
    @NotNull
	public Integer creadorCodigo;

    
    
	public Long getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public Integer getCreadorCodigo() {
		return creadorCodigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public void setCreadorCodigo(Integer creadorCodigo) {
		this.creadorCodigo = creadorCodigo;
	}

	public ProductoDTO(Long codigo, String nombre,
			@Digits(fraction = 0, integer = 5, message = "Cantidad debe ser un numero de 5 digitos o menos.") Integer cantidad,
			@Pattern(regexp = "dd/MM/yyyy", message = "Fecha ") String fechaIngreso, Integer creadorCodigo) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.fechaIngreso = fechaIngreso;
		this.creadorCodigo = creadorCodigo;
	}

	
	public ProductoDTO() {}
    
	
}
