package com.arsuarez.com.entity;

import java.util.Date;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*@Data
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)*/

@Entity
@Table(name = "producto")


public class Producto {
	
	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "codigo")
    public Long codigo;
    
	public String nombre;
	
	public Integer cantidad;
	
    @Column(name = "fecha_ingreso")
    public Date fechaIngreso;
	
	@Column(name = "creador_codigo")
	@JoinColumn(name="fk_creador")
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

	public Date getFechaIngreso() {
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

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public void setCreadorCodigo(Integer creadorCodigo) {
		this.creadorCodigo = creadorCodigo;
	}

	public Producto(Long codigo, String nombre, Integer cantidad, Date fechaIngreso, Integer creadorCodigo) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.fechaIngreso = fechaIngreso;
		this.creadorCodigo = creadorCodigo;
	}

	public Producto() {
	}
	

	


}
