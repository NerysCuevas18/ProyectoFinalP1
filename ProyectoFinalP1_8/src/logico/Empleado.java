package logico;

import java.util.ArrayList;
import java.util.Date;

public abstract class Empleado extends Persona {
	protected Date ingresoCompania;
	protected float saldo;
	protected String pass; 
	
	
	public Empleado(String cedula, String nombres, String apellidos, ArrayList<String> telefonos, String correo,
			char sexo, Date nacimiento, String nacionalidad, String nombreReferencia,String telefonoReferencia,
			Date ingresoCompania, float saldo, String pass) {
		super(cedula, nombres, apellidos, telefonos, correo, sexo, nacimiento, nacionalidad, nombreReferencia,
			telefonoReferencia);
		this.ingresoCompania = ingresoCompania;
		this.saldo = saldo;
		this.pass = pass;
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
	
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
