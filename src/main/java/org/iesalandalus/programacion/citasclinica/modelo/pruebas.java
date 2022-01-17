package org.iesalandalus.programacion.citasclinica.modelo;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.iesalandalus.programacion.citasclinica.vista.Opciones;
import org.iesalandalus.programacion.utilidades.Entrada;

public class pruebas {

	public static void main(String[] args) {
//		int opcion;
//		do {
//			System.out.println("ELIJE UNA OPCION (1-6):");
//			opcion = Entrada.entero();
//			switch (opcion) {
//			case 1:
//				System.out.println("1");
//			case 2:
//				System.out.println("2");	
//			case 3:
//				System.out.println("3");	
//			case 4:
//				System.out.println("4");	
//			case 5:
//				System.out.println("5");	
//			case 6:
//				System.out.println("6");	
//			default:
//				System.out.println("OPCION INVALIDA");
//				break;
//			}
//		}while(opcion > 6 || opcion < 1);
		LocalDateTime localdatetime1 = LocalDateTime.now();
		try {
			localdatetime1 = LocalDateTime.of(2018, 80, 10, 11, 25);
		} catch (DateTimeException dte) {
			// TODO Auto-generated catch block
			System.out.println("FECHA INCORRECTA");
		}
		System.out.println(localdatetime1);
	}
		
}
