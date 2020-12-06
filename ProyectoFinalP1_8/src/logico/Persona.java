package logico;

import java.util.ArrayList;
import java.util.Date;

public abstract class Persona {
	protected String cedula;
	protected String nombres;
	protected String apellidos;
	protected ArrayList<String> telefonos;
	protected String correo;
	protected char sexo;
	protected Date nacimiento;
	protected String nacionalidad;
	protected String nombreReferencia;
	protected String telefonoReferencia;
	
	public Persona(String cedula, String nombres, String apellidos, ArrayList<String> telefonos, String correo,
			char sexo, Date nacimiento, String nacionalidad, String nombreReferencia,
			String telefonoReferencia) {
		super();
		this.cedula = cedula;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefonos = telefonos;
		this.correo = correo;
		this.sexo = sexo;
		this.nacimiento = nacimiento;
		this.nacionalidad = nacionalidad;
		this.nombreReferencia = nombreReferencia;
		this.telefonoReferencia = telefonoReferencia;
	}
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public ArrayList<String> getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(ArrayList<String> telefonos) {
		this.telefonos = telefonos;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public Date getNacimiento() {
		return nacimiento;
	}
	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getNombreReferencia() {
		return nombreReferencia;
	}
	public void setNombreReferencia(String nombreReferencia) {
		this.nombreReferencia = nombreReferencia;
	}
	public String getTelefonoReferencia() {
		return telefonoReferencia;
	}
	public void setTelefonoReferencia(String telefonoReferencia) {
		this.telefonoReferencia = telefonoReferencia;
	}
	

}
