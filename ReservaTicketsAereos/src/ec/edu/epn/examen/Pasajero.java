package ec.edu.epn.examen;

public class Pasajero {
	private String documento;
	private String nombre;
	private String direccion;
	private String nacionalidad;
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
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * @return the nacionalidad
	 */
	public String getNacionalidad() {
		return nacionalidad;
	}
	/**
	 * @param nacionalidad the nacionalidad to set
	 */
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public Pasajero(String documento, String nombre, String direccion,
			String nacionalidad) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.direccion = direccion;
		this.nacionalidad = nacionalidad;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pasajero [documento=" + documento + ", nombre=" + nombre
				+ ", direccion=" + direccion + ", nacionalidad=" + nacionalidad
				+ "]";
	}
	
	
	

}
