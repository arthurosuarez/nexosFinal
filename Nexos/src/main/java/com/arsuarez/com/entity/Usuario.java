package com.arsuarez.com.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")

public class Usuario {

	@Id
	public Long codigo;
	public String nombre;
	
	@Column(name = "fecha_nacimiento")
	public Date fechaNacimiento;

	@Column(name = "cargo_codigo")
	public Integer cargoCodigo;
	
	@Column(name = "fecha_ingreso")
	public Date fechaIngreso;
	
	public Boolean estado;

	public Long getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public Integer getCargoCodigo() {
		return cargoCodigo;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public Boolean getEstado() {
		return estado;
	}

	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setCargoCodigo(Integer cargoCodigo) {
		this.cargoCodigo = cargoCodigo;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	
	public Usuario(Long codigo, String nombre, Date fechaNacimiento, Integer cargoCodigo, Date fechaIngreso,
			Boolean estado) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.cargoCodigo = cargoCodigo;
		this.fechaIngreso = fechaIngreso;
		this.estado = estado;
	}

	public Usuario() {
	}

	
}
