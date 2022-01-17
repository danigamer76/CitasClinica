package org.iesalandalus.programacion.citasclinica;

import org.iesalandalus.programacion.citasclinica.modelo.Citas;
import org.iesalandalus.programacion.citasclinica.vista.Consola;
import org.iesalandalus.programacion.citasclinica.vista.Opciones;

public class MainApp {
	private static final int NUM_MAX_CITAS = 50;
	private Citas citasClinica;

	public static void main(String[] args) {
		Opciones options;
		do {
		System.out.println("Programa para gestionar las citas de la Clinica.");
		Citas arrayCitas[] = new Citas[NUM_MAX_CITAS];
		Consola.mostrarMenu();
		options = Consola.elegirOpcion();
		ejecutarOpcion(options);
		}while(options != Opciones.SALIR);
	}

	private static void ejecutarOpcion(Opciones opcion) {
		switch (opcion) {
		case INSERTAR_CITA:
			System.out.println("INSERTANDO CITA");
			insertarCita();
			System.out.println("FIN DE LA INSERSION");
			break;
		case BUSCAR_CITA:
			System.out.println("BUSCANDO CITA");
			buscarCita();
			System.out.println("FIN DE LA BUSQUEDA");
			break;
		case BORRAR_CITA:
			System.out.println("BORRANDO CITA");
			borrarCita();
			System.out.println("FIN DEL BORRADO");
			break;
		case MOSTRAR_CITAS:
			System.out.println("MOSTRANDO CITAS");
			mostrarCitas();
			System.out.println("FINAL DE LAS CITAS");
			break;
		case MOSTRAR_CITAS_DIA:
			System.out.println("MOSTRANDO CITAS POR DIA");
			mostrarCitasDia();
			System.out.println("FINAL DE LAS CITAS");
			break;
		case SALIR:
			System.out.println("ADIOS");
			break;
		}
	}

	private static void insertarCita() {
		Citas arrayCitas = new Citas();
		arrayCitas.insertar(Consola.leerCita());
	}

	private static void buscarCita() {
		Citas arrayCitas = new Citas();
		arrayCitas.buscar(Consola.leerCita());
	}


	private static void borrarCita() {
		Citas arrayCitas = new Citas();
		arrayCitas.borrar(Consola.leerCita());
	}


	private static void mostrarCitasDia() {
		Citas arrayCitas = new Citas();
		System.out.println(arrayCitas.getCitas(Consola.leerFecha()));
	}


	private static void mostrarCitas() {
		Citas arrayCitas = new Citas();
		System.out.println(arrayCitas.getCitas());
	}


}
