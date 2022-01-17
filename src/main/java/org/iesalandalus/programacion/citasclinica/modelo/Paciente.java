package org.iesalandalus.programacion.citasclinica.modelo;

import java.util.Objects;

import org.iesalandalus.programacion.utilidades.Entrada;

public class Paciente {
	private static final String ER_DNI = "\\d{8}[A-Za-z]";
	private static final String ER_TELEFONO = "\\d{9}";
	private String nombre;
	private String dni;
	private String telefono;
	
	//CONSTRUCTOR CON PARAMETROS
	public Paciente(String nombre, String dni, String telefono) {
		setNombre(nombre);
		setDni(dni);
		setTelefono(telefono);
	}
	
	//CONSTRUCTOR COPIA
	public Paciente(Paciente paciente) {
		setNombre(paciente.getNombre());
		setDni(paciente.getDni());
		setTelefono(paciente.getTelefono());
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		if(nombre == "" || nombre == null) {
			throw new NullPointerException("NOMBRE DE PACIENTE VACIO");
		}else {
			this.nombre = formateaNombre(nombre);
		}
	}
	
	private String formateaNombre(String nombre) {
		//SE ENCARGA DE ELIMINAR TODOS LOS ESPACIOS SOBRANTES Y LOS PONE EN MINUSCULA.
		nombre = nombre.replaceAll("\\s+"," ").trim().toLowerCase();
		String nuevonombre = "";
		//SE ENCARGA DE PONER EN MAYUSCULA LA PRIMERA LETRA DE CADA PALABRA
		nuevonombre += nombre.substring(0,1).toUpperCase();
		for (int i = 1; i < nombre.length(); i++) {
			if(nombre.charAt(i-1) == ' ') {
				nuevonombre += nombre.substring(i,i+1).toUpperCase();
			}else {
				nuevonombre += nombre.substring(i,i+1);
			}
		}
		return nuevonombre;
	}
	
	public String getDni() {
		return dni;
	}
	
	private void setDni(String dni) {
		if(dni == "" || dni == null) {
			throw new NullPointerException("DNI DE PACIENTE VACIO");
		}else {
			if(dni.matches(ER_DNI) == false) {
				throw new IllegalArgumentException("LONGITUD DE DNI INCORRECTA");
			}else {
				if(comprobarLetraDni(dni) == false) {
					throw new IllegalArgumentException("LETRA DNI INCORRECTA");
				}else {
					this.dni = dni;
				}
			}
		}
		
	}
	
	private boolean comprobarLetraDni(String dni) {
		char [] letras = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
		char letra = dni.charAt(8);
		int numero = Integer.parseInt(dni.substring(0, 8));
		if(letras[numero % 23] == letra) {
			return true;
		}else {
			System.out.println("Letra de DNI INVALIDA");
			return false;
		}
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		if(telefono == "" || telefono == null) {
			throw new NullPointerException("TELEFONO DE PACIENTE VACIO");
		}else {
			if(telefono.matches(ER_TELEFONO) == false) {
				throw new IllegalArgumentException("LONGITUD DE TELEFONO INCORRECTA");
			}else {
				this.telefono = telefono;
			}
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni, nombre, telefono);
	}

	@Override
	/**
	 * DUDA PREGUNTAR
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		return Objects.equals(dni, other.dni);
	}
	
		@Override
	public String toString() {
		return "Paciente - [" + getIniciales() + "] " + nombre + ", DNI=" + dni + ", TLF=" + telefono;
	}

	private String getIniciales() {
		String iniciales = "";
		iniciales += nombre.substring(0, 1);
		for (int i = 1; i < nombre.length(); i++) {
			if(nombre.charAt(i-1) == ' ') {
				iniciales += nombre.substring(i,i+1);
			}
		}
		return iniciales;
	}
	
}
