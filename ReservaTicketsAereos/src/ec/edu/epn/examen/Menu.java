package ec.edu.epn.examen;

import java.io.Console;

public abstract class Menu {
	
	char opcion=' ';
	

	public void readOpcion(){
		Console consola = System.console();
		String mensaje = "Ingrese una opcion";
		String lectura = consola.readLine("%1$s", mensaje);
		try{
			opcion = lectura.charAt(0);
		}catch(StringIndexOutOfBoundsException e){
			opcion = ' ';
		}
	}
	
	public String readDatos(String mensaje){
		Console consola = System.console();
		String lectura = consola.readLine("%1$s", mensaje);
		return lectura;
	}
	
	abstract void printMenu();
	abstract void generateMenu();
	
	
}
