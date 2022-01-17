package org.iesalandalus.programacion.citasclinica.vista;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.iesalandalus.programacion.citasclinica.modelo.Cita;
import org.iesalandalus.programacion.citasclinica.modelo.Citas;
import org.iesalandalus.programacion.citasclinica.modelo.Paciente;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
	private Consola() {};
	public static void mostrarMenu() {
		System.out.println("----MENU CITAS----");
		System.out.println("1.INSERTAR CITA");
		System.out.println("2.BUSCAR CITA");
		System.out.println("3.BORRAR CITA");
		System.out.println("4.MOSTRAR TODAS LAS CITAS");
		System.out.println("5.MOSTRAR TODAS LAS CITAS DE UNA FECHA");
		System.out.println("6.SALIR");
		System.out.println("------------------");
	}
	public static Opciones elegirOpcion() {
		int opcion;
		do {
		System.out.println("ELIJE UNA OPCION (1-6):");
		opcion = Entrada.entero();
		switch (opcion) {
		case 1:
			return Opciones.INSERTAR_CITA;
		case 2:
			return Opciones.BUSCAR_CITA;
		case 3:
			return Opciones.BORRAR_CITA;
		case 4:
			return Opciones.MOSTRAR_CITAS;
		case 5:
			return Opciones.MOSTRAR_CITAS_DIA;
		case 6:
			return Opciones.SALIR;
		default:
			System.out.println("OPCION INVALIDA");
			break;
		}
		}while(opcion > 6 || opcion < 1);
		return null;
	}
	public static Cita leerCita() {
		
		
		return null;

	}
	public static Paciente leerPaciente() {
		System.out.println("NOMBRE DEL PACIENTE:");
		String nombre = Entrada.cadena();
		System.out.println("DNI DEL PACIENTE:");
		String dni = Entrada.cadena();
		System.out.println("TELEFONO DEL PACIENTE:");
		String telefono = Entrada.cadena();
		Paciente paciente = new Paciente(nombre, dni, telefono);
		return paciente;

	}
	public static LocalDateTime leerFechaHora() {
		int valid = 0;
		LocalDateTime localdatetime1 = null;
		do {
		System.out.println("DIA:");
		int dia = Entrada.entero();
		System.out.println("MES:");
		int mes = Entrada.entero();	
		System.out.println("ANIO:");
		int anio = Entrada.entero();	
		System.out.println("HORA:");
		int hora = Entrada.entero();	
		System.out.println("MINUTOS:");
		int min = Entrada.entero();	
		
		try {
			localdatetime1 = LocalDateTime.of(anio, mes, dia, hora, min);
		} catch (DateTimeException dte) {
			System.out.println("FECHA INCORRECTA, INTRODUZCA UNA DE VERDAD:");
			valid = 1;
		}
		}while(valid == 1);
		return localdatetime1;

	}
	public static LocalDate leerFecha() {
		return null;

	}
}
