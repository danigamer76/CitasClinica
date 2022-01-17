package org.iesalandalus.programacion.citasclinica.modelo;

import java.time.LocalDate;
import java.util.Arrays;

public class Citas {
	private int capacidad;
	private int tamano;
	Cita Citas[]= new Cita[capacidad];
	
	public Cita[] getCitas() {
		return Citas;
	}
	public Cita[] getCitas(LocalDate fecha) {
		Cita NewCitas[]=new Cita[1];
		int N;
		for (int i = 0; i < Citas.length; i++) {
			N = NewCitas.length;
			if(Citas[i].getFechaHora().toLocalDate() == fecha) {
				NewCitas = Arrays.copyOf(NewCitas, N + 1);
				NewCitas[N] = Citas[i];
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
		int N = Citas.length;
		Citas = Arrays.copyOf(Citas, N + 1);
		Citas[N] = cita;
	}
	
	private int buscarIndice(Cita cita) {
		int indice = Arrays.asList(Citas).indexOf(cita);
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
			return Citas[buscarIndice(cita)];
		}
	}
	
	private void desplazarUnaPosicionHaciaIzquierda(int indice) {
		for (int i = indice; i < Citas.length; i++) {
			Citas[i] = Citas[i+1];
		}
		Citas[Citas.length] = null;
	}
	
	public void borrar(Cita cita) {
		desplazarUnaPosicionHaciaIzquierda(buscarIndice(cita));
	}
}
