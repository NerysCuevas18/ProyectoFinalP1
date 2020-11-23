package logico;

import java.util.ArrayList;
import java.util.Date;

public class Cliente extends Persona {
	private boolean estado;
	private ArrayList<Factura> facturasMensual;
	private String tel;
	private Plan PlanC;
	private Factura facturaMensual;
	private Date registro;
	private String estad;
	
	public Cliente(String cedula, String nombres, String apellidos, ArrayList<String> telefonos, String correo,
			int edad, char sexo, Date nacimiento, String nacionalidad, String nombreReferencia,
			String telefonoReferencia, boolean estado, ArrayList<Factura> facturasMensual, String tel, Plan planC,
			Factura facturaMensual, Date registro, String estad) {
		super(cedula, nombres, apellidos, telefonos, correo, edad, sexo, nacimiento, nacionalidad, nombreReferencia,
				telefonoReferencia);
		this.estado = estado;
		this.facturasMensual = facturasMensual;
		this.tel = tel;
		PlanC = planC;
		this.facturaMensual = facturaMensual;
		this.registro = registro;
		this.estad = estad;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Plan getPlanC() {
		return PlanC;
	}

	public void setPlanC(Plan planC) {
		PlanC = planC;
	}

	public Factura getFacturaMensual() {
		return facturaMensual;
	}

	public void setFacturaMensual(Factura facturaMensual) {
		this.facturaMensual = facturaMensual;
	}

	public Date getRegistro() {
		return registro;
	}

	public void setRegistro(Date registro) {
		this.registro = registro;
	}

	public String getEstad() {
		return estad;
	}

	public void setEstad(String estad) {
		this.estad = estad;
	}
	
}
