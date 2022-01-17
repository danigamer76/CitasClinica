package org.iesalandalus.programacion.citasclinica.modelo;

import java.time.LocalDateTime;
import java.util.Arrays;

public class pruebas {

	public static void main(String[] args) {
		String prueba = "  daniel     guardia     fernandezldasdads   dalsdasldad  ";
		//SE ENCARGA DE ELIMINAR TODOS LOS ESPACIOS SOBRANTES Y LOS PONE EN MINUSCULA.
		prueba = prueba.replaceAll("\\s+"," ").trim().toLowerCase();
		String nuevaprueba = "";
		//SE ENCARGA DE PONER EN MAYUSCULA LA PRIMERA LETRA DE CADA PALABRA
		nuevaprueba += prueba.substring(0,1).toUpperCase();
		for (int i = 1; i < prueba.length(); i++) {
			if(prueba.charAt(i-1) == ' ') {
				nuevaprueba += prueba.substring(i,i+1).toUpperCase();
			}else {
//				nuevaprueba += prueba.substring(i,i+1);
			}
		}
		System.out.println(nuevaprueba);
		
		Paciente paciente = new Paciente("daniel guardia fernandez", "77158131P", "667204475");
		Cita cita = new Cita(paciente, LocalDateTime.now());
		System.out.println(cita.toString());
		
		int[] array1 = {2, 4, 6, 8, 10};
		
//		Arrays.asList(array1).indexOf(8);
		int N = array1.length;
		array1 = Arrays.copyOf(array1, N + 1);
		array1[N] = 6;
        System.out.println(Arrays.toString(array1));
	}

}
