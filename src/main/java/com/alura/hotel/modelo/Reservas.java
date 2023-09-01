package com.alura.hotel.modelo;

import java.sql.Date;

public class Reservas {

	private Integer id;
	private Date fecha_entrada;
	private Date fecha_salida;
	private String forma_pago;
	private Float valor;


	public Reservas(Date fecha_entrada, Date fecha_salida, String forma_pago, Float valor) {
		this.fecha_entrada = fecha_entrada;
		this.fecha_salida = fecha_salida;
		this.forma_pago = forma_pago;
		this.valor = valor;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha_entrada() {
		return fecha_entrada;
	}


	public void setFecha_entrada(Date fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
	}


	public Date getFecha_salida() {
		return fecha_salida;
	}


	public void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}


	public String getForma_pago() {
		return forma_pago;
	}


	public void setForma_pago(String forma_pago) {
		this.forma_pago = forma_pago;
	}


	public Float getValor() {
		return valor;
	}


	public void setValor(Float valor) {
		this.valor = valor;
	}
	
}
