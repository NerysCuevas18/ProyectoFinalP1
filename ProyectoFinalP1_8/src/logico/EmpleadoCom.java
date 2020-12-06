package logico;

import java.util.ArrayList;
import java.util.Date;

public class EmpleadoCom extends Empleado {
	
	float bono;
	int cantVenta;

	public EmpleadoCom(String cedula, String nombres, String apellidos, ArrayList<String> telefonos, String correo,
			char sexo, Date nacimiento, String nacionalidad, String nombreReferencia, String telefonoReferencia,
			Date ingresoCompania, float saldo) {
		super(cedula, nombres, apellidos, telefonos, correo, sexo, nacimiento, nacionalidad, nombreReferencia,
				telefonoReferencia, ingresoCompania, saldo);
	}

	public float getBono() {
		return bono;
	}

	public void setBono() {
		int aux=0;
		float bonos = 0;
		if(cantVenta>50) {
			aux = (cantVenta-50)/5;
			bonos = (float) (0.15*saldo*aux);
		}
		this.bono = bonos;

	}

	public int getCantVenta() {
		return cantVenta;
	}

	public void setCantVenta(int cantVenta) {
		this.cantVenta = cantVenta;
	}

}
