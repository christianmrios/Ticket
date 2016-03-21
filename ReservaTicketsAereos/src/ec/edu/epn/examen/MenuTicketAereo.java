package ec.edu.epn.examen;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class MenuTicketAereo extends Menu {

	List<Reserva> reservas = new ArrayList<Reserva>();
	
	
	@Override
	void printMenu() {
		StringBuilder s = new StringBuilder();
		s.append(" ----------------------------------- \n");
		s.append("|           M   E   N   U           |\n");
		s.append("|-----------------------------------|\n");
		s.append("|                                   |\n");
		s.append("|  v.   Consultar Vuelos            |\n");
		s.append("|  p.   Consultar Pasajeros         |\n");
		s.append("|  r.   Reservar Ticket             |\n");
		s.append("|  i.   Imprimir Ticket             |\n");
		s.append("|                                   |\n");
		s.append("|  x.   Salir                       |\n");
		s.append(" ----------------------------------- \n");
		s.append("                                     \n");
		System.out.println(s.toString());
	}
	@Override
	void generateMenu() {
		List<Vuelo> vuelosDisponibles = null;
		List<Pasajero> pasajerosRegistrados = null;
		boolean salir = false;
		do {
			printMenu();
			readOpcion();
			switch (opcion) {
			case 'v':
				vuelosDisponibles = crearVuelosDisponibles();
				printVuelosDisponibles(vuelosDisponibles);
				break;
			case 'p':
				pasajerosRegistrados = crearPasajerosRegistrados();
				printPasajerosRegistrados(pasajerosRegistrados);
				break;
			case 'r':
				Reserva reserva = crearReserva(vuelosDisponibles, pasajerosRegistrados);
				if(reserva != null && !reservas.contains(reserva)){
					reservas.add(reserva);
				}
				break;
			case 'i':
				printReservasTickets();
				printTicketAereo();
				break;
				
			case 'x':
				System.out.println("saliendo...");
				salir = true;
				break;
			default:
				System.out.println("opcion invalida...");
				break;
			}
			
		} while (!salir);
		System.out.println("Gracias por utilizar nuestro sistema reserva de tickets...");

	}
	private List<Vuelo> crearVuelosDisponibles(){
		List<Vuelo> vuelos = new ArrayList<Vuelo>();
		Vuelo v1 = new Vuelo("01", "Quito-Portoviejo", "TAME", 600.00, new GregorianCalendar(2015, 5, 12, 6, 22));
		Vuelo v2 = new Vuelo("02", "Quito-MIAMI", "Fire", 800.00, new GregorianCalendar(2015, 8, 13, 12, 5));
		Vuelo v3 = new Vuelo("03", "NewYork-Quito", "Taco", 885.00, new GregorianCalendar(2015, 8, 11, 11, 19));
		vuelos.add(v1);
		vuelos.add(v2);
		vuelos.add(v3);
		return vuelos;
	}
	private List<Pasajero> crearPasajerosRegistrados(){
		List<Pasajero> pasajeros = new ArrayList<Pasajero>();
		Pasajero p1 = new Pasajero("1254689789", "Cesar", "Solanda", "Ecuatoriana");
		Pasajero p2 = new Pasajero("1254785698", "Paul", "Ecuatoriana", "Venesolana");
		Pasajero p3 = new Pasajero("1256321458", "Maria", "Condado", "Colombiana");
		pasajeros.add(p1);
		pasajeros.add(p2);
		pasajeros.add(p3);
		return pasajeros;
	}
	private void printVuelosDisponibles(List<Vuelo> vuelosDisponibles){
		if(vuelosDisponibles!=null && vuelosDisponibles.size() > 0){
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm");
			System.out.println("--------/--------/--------/------------/----------");
			System.out.println("CODIGO  \tORIGEN -DESTINO \tAEROLINEA  \tPRECIO  \tFECHA");
			System.out.println("--------/--------/--------/------------/----------");
			for(Vuelo tmpVuelo : vuelosDisponibles){
				System.out.println(tmpVuelo.getCodigo()+"\t"+tmpVuelo.getOrigenDestino()
						+"\t"+tmpVuelo.getAerolinea()+"\t"+tmpVuelo.getPrecio()
						+"\t"+sdf.format(tmpVuelo.getFecha().getTime()) );
			}
			
		}else{
			System.out.println("No hay vuelos disponibles");
		}
	}
	
	private void printPasajerosRegistrados(List<Pasajero> pasajerosRegistrados){
		if(pasajerosRegistrados!=null && pasajerosRegistrados.size() > 0){
			System.out.println("--------/--------/--------/------------/----------");
			System.out.println("DOCUMENTO\tNOMBRE\tDIRECCION\tNACIONALIDAD");
			System.out.println("--------/--------/--------/------------/----------");
			for(Pasajero tmpPasajero : pasajerosRegistrados){
				System.out.println(tmpPasajero.getDocumento()+"\t"+tmpPasajero.getNombre()
						+"\t"+tmpPasajero.getDireccion()+"\t"+tmpPasajero.getNacionalidad() );
			}
		
		}else{
			System.out.println("No hay pasajeros registrados");
		}
	}
	
	private Reserva crearReserva(List<Vuelo> vuelosDisponibles, List<Pasajero> pasajerosRegistrados){
		Reserva reserva = null;
		Vuelo vuelo = null;
		List<Pasajero> pasajeros = new ArrayList<Pasajero>();
		printVuelosDisponibles(vuelosDisponibles);
		String codigoVuelo = readDatos("Ingrese el codigo de vuelo: ");
		for(Vuelo tmpVuelo : vuelosDisponibles){
			if(tmpVuelo.getCodigo().equalsIgnoreCase(codigoVuelo)){
				vuelo = tmpVuelo;
				break;
			}
		}
		int numeroTickets = Integer.parseInt(readDatos("Ingrese el numero de tickets a reservar: "));
		printPasajerosRegistrados(pasajerosRegistrados);
		
		int contador = 1;
		String documentoPasajero;
		while(contador <= numeroTickets){
			documentoPasajero = readDatos("Ingrese el documento del Pasajero "+contador+": ");
			for(Pasajero tmpPasajero : pasajerosRegistrados){
				if(tmpPasajero.getDocumento().equalsIgnoreCase(documentoPasajero)){
					pasajeros.add(tmpPasajero);
					break;
				}
			}
			contador++;
		}
		String documentoReserva = readDatos("Ingrese el documento del cliente de la reserva: ");
		String nombreReserva = readDatos("Ingrese el nombre del cliente de la reserva: ");
		reserva = new Reserva(
				MenuTicketAereo.obtenerSerial(),
				Calendar.getInstance(),
				documentoReserva,
				nombreReserva,
				vuelo,
				pasajeros, 
				vuelo.getPrecio() * numeroTickets);
		return reserva;
	}
	private void printReservasTickets(){
		if(reservas!=null && reservas.size() > 0){
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm");
			System.out.println("CODIGO\tORIGEN-DESTINO\tFECHA-VUELO");
			for(Reserva tmpReserva : reservas){
				System.out.println( tmpReserva.getCodigo()+"\t"+tmpReserva.getVuelo().getOrigenDestino()+"\t"+sdf.format(tmpReserva.getFecha().getTime()) );
			}
		}else{
			System.out.println("No existen reservas de tickets aereos.");
		}
	}
	private void printTicketAereo(){
		String codigoReserva = readDatos("Ingrese el codigo de reserva de ticket: ");
		if(reservas!=null && reservas.size() > 0){
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
			for(Reserva r : reservas){
				if(r.getCodigo().equalsIgnoreCase(codigoReserva)){
					System.out.println("--------/--------/--------/-----");
					System.out.println("            T I C K E T        ");
					System.out.println("--------/--------/--------/-----");r
					System.out.println("CODIGO: "+r.getCodigo()+"\t\tFECHA: "+sdf.format(r.getFecha().getTime()));
					System.out.println("VUELO: "+r.getVuelo().getCodigo()+"\t\tFECHA: "+sdf.format(r.getFecha().getTime()));
					List<Pasajero> tmpPasajeros = r.getPasajeros();
					if(tmpPasajeros!=null && tmpPasajeros.size() > 0){
						for(Pasajero tmpPasajero : tmpPasajeros){
							System.out.println("---------------------------------");
							System.out.println("Documento Pasajero: "+tmpPasajero.getDocumento());
							System.out.println("Nombre Pasajero: "+tmpPasajero.getNombre());
							System.out.println("Nacionalidad Pasajero: "+tmpPasajero.getNacionalidad());
						}
					}
				}
			}
		}else{
			System.out.println("No existen reservas de tickets aereos.");
		}
	}
	public static String obtenerSerial(){
		Calendar fechaHoy = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");
		return sdf.format(fechaHoy.getTime());
	} 
	

}
