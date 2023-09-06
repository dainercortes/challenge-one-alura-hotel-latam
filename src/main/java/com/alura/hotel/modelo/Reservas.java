package com.alura.hotel.modelo;

import java.sql.Date;

/**
 * @version 1.0
 * @author Dainer Cortés
 */
public class Reservas {

	private Integer id;
	private Date fecha_entrada;
	private Date fecha_salida;
	private String forma_pago;
	private Float valor;


	/**
	 * Constructor vacio
	 */
	public Reservas() {

	}

	/**
	 * Constructor sobrecargado
	 * @param fecha_entrada
	 * @param fecha_salida
	 * @param forma_pago
	 * @param valor
	 */
	public Reservas(Date fecha_entrada, Date fecha_salida, String forma_pago, Float valor) {
		this.fecha_entrada = fecha_entrada;
		this.fecha_salida = fecha_salida;
		this.forma_pago = forma_pago;
		this.valor = valor;
	}

	/**
	 * Constructor sobrecargado
	 *
	 * @param id
	 * @param fecha_entrada
	 * @param fecha_salida
	 * @param forma_pago
	 * @param valor
	 */
	public Reservas(Integer id, Date fecha_entrada, Date fecha_salida, String forma_pago, Float valor) {
		this.id = id;
		this.fecha_entrada = fecha_entrada;
		this.fecha_salida = fecha_salida;
		this.forma_pago = forma_pago;
		this.valor = valor;
	}

	/**
	 * Devuelve el id de la reserva
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Guarda el id de la reserva
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Devuelve la fecha de entrada
	 * @return
	 */
	public Date getFecha_entrada() {
		return fecha_entrada;
	}

	/**
	 * Guarda la fecha de entrada
	 * @param fecha_entrada
	 */
	public void setFecha_entrada(Date fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
	}


	/**
	 * Devuelve la fecha de salida
	 * @return
	 */
	public Date getFecha_salida() {
		return fecha_salida;
	}

	/**
	 * Guarda la fecha de salida
	 * @param fecha_salida
	 */
	public void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}

	/**
	 * Devuelve el formato de pago elegido
	 * @return
	 */
	public String getForma_pago() {
		return forma_pago;
	}

	/**
	 * Guarda el formato de pago elegido
	 * @param forma_pago
	 */
	public void setForma_pago(String forma_pago) {
		this.forma_pago = forma_pago;
	}

	/**
	 * Devuelve el valor a pagar
	 * @return
	 */
	public Float getValor() {
		return valor;
	}

	/**
	 * Guarda el valor a pagar
	 * @param valor
	 */
	public void setValor(Float valor) {
		this.valor = valor;
	}
	
}
