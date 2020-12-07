package logico;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class EmpleadoAdm extends Empleado {
	
	int expAnios;

	public EmpleadoAdm(String cedula, String nombres, String apellidos, ArrayList<String> telefonos, String correo,
			char sexo, Date nacimiento, String nacionalidad, String nombreReferencia,String telefonoReferencia,
			Date ingresoCompania, float saldo, String pass) {
		super(cedula, nombres, apellidos, telefonos, correo, sexo, nacimiento, nacionalidad, nombreReferencia,
				telefonoReferencia, ingresoCompania, saldo, pass);
		this.expAnios = expAnios;
	}

	public int getExpAnios() {
		return expAnios;
	}

	public void expAnios() {
		int anio=0;
		Date fecha = new Date();
		anio = (int) (ingresoCompania.getTime()-fecha.getTime());
		this.expAnios = anio;
	}
	

}
