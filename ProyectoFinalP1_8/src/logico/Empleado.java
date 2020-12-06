package logico;

import java.util.ArrayList;
import java.util.Date;

public abstract class Empleado extends Persona {
	protected Date ingresoCompania;
	protected float saldo;
	
	public Empleado(String cedula, String nombres, String apellidos, ArrayList<String> telefonos, String correo,
			char sexo, Date nacimiento, String nacionalidad, String nombreReferencia,
			String telefonoReferencia, Date ingresoCompania, float saldo) {
		super(cedula, nombres, apellidos, telefonos, correo, sexo, nacimiento, nacionalidad, nombreReferencia,
				telefonoReferencia);
		this.ingresoCompania = ingresoCompania;
		this.saldo = saldo;
	}
	
	public Date getIngresoCompania() {
		return ingresoCompania;
	}
	public void setIngresoCompania(Date ingresoCompania) {
		this.ingresoCompania = ingresoCompania;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
}
