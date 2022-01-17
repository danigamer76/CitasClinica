package org.iesalandalus.programacion.citasclinica.modelo;

import java.time.LocalDate;
import java.util.Arrays;

public class Citas{
	private int capacidad;
	private int tamano;
	Cita coleccionCitas[];
	
	public Cita[] getCitas() {
		return coleccionCitas;
	}
	public Cita[] getCitas(LocalDate fecha) {
		Cita NewCitas[]=new Cita[1];
		int N;
		for (int i = 0; i < coleccionCitas.length; i++) {
			N = NewCitas.length;
			if(coleccionCitas[i].getFechaHora().toLocalDate() == fecha) {
				NewCitas = Arrays.copyOf(NewCitas, N + 1);
				NewCitas[N] = coleccionCitas[i];
				return NewCitas;
			}
		}
		return null;
	
	}
	public int getCapacidad() {
		return capacidad;
	}
	public int getTamano() {
		return tamano;
	}
	
	public void insertar(Cita cita) {
		int N = coleccionCitas.length;
		coleccionCitas = Arrays.copyOf(coleccionCitas, N + 1);
		coleccionCitas[N] = cita;
	}
	
	private int buscarIndice(Cita cita) {
		int indice = Arrays.asList(coleccionCitas).indexOf(cita);
		if(indice == -1) {
			indice = tamano+1;
		}
		return indice;
	}
	
	private boolean tamanoSuperado(int tamano) {
		if(tamano > this.tamano) {
			return true;
		}else {
			return false;
		}
	}
	
	private boolean capacidadSuperada(int capacidad) {
		if(capacidad > this.capacidad) {
			return true;
		}else {
			return false;
		}
	}
	

	public Cita buscar(Cita cita) {
		if(buscarIndice(cita) == -1) {
			throw new IllegalArgumentException("NO SE PUDO ENCONTRAR CITA");
		}else {
			return coleccionCitas[buscarIndice(cita)];
		}
	}
	
	private void desplazarUnaPosicionHaciaIzquierda(int indice) {
		for (int i = indice; i < coleccionCitas.length; i++) {
			coleccionCitas[i] = coleccionCitas[i+1];
		}
		coleccionCitas[coleccionCitas.length] = null;
	}
	
	public void borrar(Cita cita) {
		desplazarUnaPosicionHaciaIzquierda(buscarIndice(cita));
	}
}
