package logico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Cliente extends Persona implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3615255257547752713L;
	private boolean estado;
	private ArrayList<Factura> facturasMensual;
	private Plan PlanC;
	private Date registro;
	
	public Cliente(String cedula, String nombres, String apellidos, ArrayList<String> telefonos, String correo,
			char sexo, Date nacimiento, String nacionalidad, String nombreReferencia,String telefonoReferencia, 
			boolean estado, Date registro) {
		super(cedula, nombres, apellidos, telefonos, correo, sexo, nacimiento, nacionalidad, nombreReferencia,
				telefonoReferencia);
		this.estado = estado;
		this.registro = registro;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public ArrayList<Factura> getFacturasMensual() {
		return facturasMensual;
	}

	public void setFacturasMensual(ArrayList<Factura> facturasMensual) {
		this.facturasMensual = facturasMensual;
	}

	public Plan getPlanC() {
		return PlanC;
	}

	public void setPlanC(Plan planC) {
		PlanC = planC;
	}

	public Date getRegistro() {
		return registro;
	}

	public void setRegistro(Date registro) {
		this.registro = registro;
	}
	
}
