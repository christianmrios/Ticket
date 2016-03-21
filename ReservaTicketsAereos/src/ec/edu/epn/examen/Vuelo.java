package ec.edu.epn.examen;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Vuelo {
	private String codigo;
	private String origenDestino;
	private String aerolinea;
	private double precio;
	private Calendar fecha;
	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the origenDestino
	 */
	public String getOrigenDestino() {
		return origenDestino;
	}
	/**
	 * @param origenDestino the origenDestino to set
	 */
	public void setOrigenDestino(String origenDestino) {
		this.origenDestino = origenDestino;
	}
	/**
	 * @return the aerolinea
	 */
	public String getAerolinea() {
		return aerolinea;
	}
	/**
	 * @param aerolinea the aerolinea to set
	 */
	public void setAerolinea(String aerolinea) {
		this.aerolinea = aerolinea;
	}
	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}
	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	/**
	 * @return the fecha
	 */
	public Calendar getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	
	
	
	public Vuelo(String codigo, String origenDestino, String aerolinea,
			double precio, Calendar fecha) {
		super();
		this.codigo = codigo;
		this.origenDestino = origenDestino;
		this.aerolinea = aerolinea;
		this.precio = precio;
		this.fecha = fecha;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		return "Vuelo [codigo=" + codigo + ", origenDestino=" + origenDestino
				+ ", aerolinea=" + aerolinea + ", precio=" + precio
				+ ", fecha=" + sdf.format(fecha.getTime()) + "]";
	}
	
	
	
	

}
