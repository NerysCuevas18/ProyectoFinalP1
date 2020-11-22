package logico;

import java.util.Date;

public class Empleado extends Persona {
	protected Date ingresoCompania;
	protected float saldo;
	
	public Empleado(Date ingresoCompania, float saldo) {
		super();
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
