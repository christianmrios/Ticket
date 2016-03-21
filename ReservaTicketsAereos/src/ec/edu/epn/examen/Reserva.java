package ec.edu.epn.examen;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Reserva {
	
	private String codigo;
	private Calendar fecha;
	private String documento;
	private String nombre;
	private Vuelo vuelo;
	private List<Pasajero> pasajeros;
	private double total;
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
	/**
	 * @return the documento
	 */
	public String getDocumento() {
		return documento;
	}
	/**
	 * @param documento the documento to set
	 */
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the vuelo
	 */
	public Vuelo getVuelo() {
		return vuelo;
	}
	/**
	 * @param vuelo the vuelo to set
	 */
	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}
	/**
	 * @return the pasajeros
	 */
	public List<Pasajero> getPasajeros() {
		return pasajeros;
	}
	/**
	 * @param pasajeros the pasajeros to set
	 */
	public void setPasajeros(List<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}
	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}
	public Reserva(String codigo, Calendar fecha, String documento,
			String nombre, Vuelo vuelo, List<Pasajero> pasajeros, double total) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.documento = documento;
		this.nombre = nombre;
		this.vuelo = vuelo;
		this.pasajeros = pasajeros;
		this.total = total;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		return "Reserva [codigo=" + codigo + ", fecha=" + sdf.format(fecha.getTime())
				+ ", documento=" + documento + ", nombre=" + nombre
				+ ", vuelo=" + vuelo + ", pasajeros=" + pasajeros + ", total="
				+ total + "]";
	}
	
	
	
	
	

}
