package org.iesalandalus.programacion.citasclinica.modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Cita{
	private static final String FORMATO_FECHA_HORA = "dd/MM/yyyy HH:mm";
	private LocalDateTime fechaHora;
	private Paciente paciente;
	
	public Cita(Paciente paciente,LocalDateTime fechaHora) {
		
		setPaciente(paciente);
		setFechaHora(fechaHora);
	}
	
	private void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	};
	
	public Paciente getPaciente() {
		return new Paciente(this.paciente);
		
	}
	
	public void setFechaHora(LocalDateTime fechaHora) {
		if(fechaHora == null) {
			throw new NullPointerException("FECHA VACIA");
		}else {
			DateTimeFormatter Formato = DateTimeFormatter.ofPattern(FORMATO_FECHA_HORA);
			this.fechaHora = LocalDateTime.parse(fechaHora.format(Formato));
		}
		
	}
	
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(fechaHora, paciente);
		return result;
	}

	/**
	 * FALTA COMPARAR
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cita other = (Cita) obj;
		return Objects.equals(fechaHora, other.fechaHora);
	}

	@Override
	public String toString() {
		return "CITA [FECHA HORA=" + fechaHora + ", " + paciente + "]";
	}
	
	
	
	
}
