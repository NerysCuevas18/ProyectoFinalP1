package logico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Empresa implements Serializable { 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7486287422009782825L;
	private ArrayList<Empleado> empleados;
	private ArrayList<Cliente> clientes;
	private ArrayList<Plan> planes;
	private ArrayList<Factura> facturas;
	private static Empresa altice = null;
	private Empleado loginUser;
	private boolean facturasGeneradas;
	private int codFacturas = 1;
	private int codPlan = 1;
	private boolean conexion;
	
	private Empresa() {
		super();
		this.empleados = new ArrayList<Empleado>();
		this.clientes = new ArrayList<Cliente>();
		this.planes = new ArrayList<Plan>();
		this.facturas = new ArrayList<Factura>();
		this.facturasGeneradas = false;
		this.setConexion(false);
	}
	
	public static Empresa getInstance() {
		if(altice == null) {
			altice = new Empresa();
		}
		return altice;
	}

	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Plan> getPlanes() {
		return planes;
	}

	public void setPlanes(ArrayList<Plan> planes) {
		this.planes = planes;
	}

	public ArrayList<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}

	public static Empresa getAltice() {
		return altice;
	}

	public static void setAltice(Empresa altice) {
		Empresa.altice = altice;
	}
	
	public void insertarEmpleado(Empleado empleado) {
		empleados.add(empleado);
	}
	
	public void insertarCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public void insertarPlan(Plan plan) {
		planes.add(plan);
		codPlan++;
	}
	
	public void insertarFactura(Factura factura) {
		facturas.add(factura);
	}
	
	public boolean isFacturasGeneradas() {
		return facturasGeneradas;
	}

	public void setFacturasGeneradas(boolean facturasGeneradas) {
		this.facturasGeneradas = facturasGeneradas;
	}

	public int getCodFacturas() {
		return codFacturas;
	}

	public void setCodFacturas(int codFacturas) {
		this.codFacturas = codFacturas;
	}
	
	public int getCodPlan() {
		return codPlan;
	}

	public void setCodPlan(int codPlan) {
		this.codPlan = codPlan;
	}

	public Empleado getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(Empleado loginUser) {
		this.loginUser = loginUser;
	}

	public boolean isConexion() {
		return conexion;
	}

	public void setConexion(boolean conexion) {
		this.conexion = conexion;
	}
	
	public void generarFacturas() {
		Date hoy = new Date();
		Calendar facturar = Calendar.getInstance();
		facturar.setTime(hoy);
		if(facturar.get(Calendar.DAY_OF_MONTH) == 25 && !facturasGeneradas) {
			for(int i = 0; i<clientes.size(); i++) {
				if(clientes.get(i).isEstado()) {
					Factura fact = new Factura("ALT"+codFacturas++, clientes.get(i));
					clientes.get(i).getFacturasMensual().add(fact);
				}
			}
			facturasGeneradas = true;
		}
	}
	
	public boolean confirmLoginAdm(String text, String text2) {
		boolean login = false;
		for (Empleado empleado : empleados) {
			if(empleado.getCedula().equals(text) && empleado.getPass().equals(text2) && empleado instanceof EmpleadoAdm){
				setLoginUser(empleado);
				login = true;
			}
		}
		return login;
	} 
	
	public boolean confirmLoginCom(String text, String text2) {
		boolean login = false;
		for (Empleado empleado : empleados) {
			if(empleado.getCedula().equals(text) && empleado.getPass().equals(text2) && empleado instanceof EmpleadoCom){
				setLoginUser(empleado);
				login = true;
			}
		}
		return login;
	}
	public Empleado findEmpleado (String ced) {
		Empleado misEmpleados = null;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i<empleados.size()){
			if(empleados.get(i).getCedula().equalsIgnoreCase(ced)) {
				misEmpleados = empleados.get(i);
				encontrado = true;
			}
			i++;
		}
		return misEmpleados;
	}
	public Plan findPlan (String codPlan) {
		Plan misPlanes = null;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i<planes.size()){
			if(planes.get(i).getCodPlan().equalsIgnoreCase(codPlan)) {
				misPlanes = planes.get(i);
				encontrado = true;
			}
			i++;
		}
		return misPlanes;
	}
	public Cliente findCliente (String ced) {
		Cliente misClientes = null;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i<clientes.size()){
			if(clientes.get(i).getCedula().equalsIgnoreCase(ced)) {
				misClientes = clientes.get(i);
				encontrado = true;
			}
			i++;
		}
		return misClientes;
	}
	public int[] cantClientePlan() {
		int[] cant = new int[planes.size()];
		for (int i = 0; i < planes.size(); i++) {
			cant[i] = 0;
		}
		for (Cliente client : clientes) {
			for (int i = 0; i < planes.size(); i++) {
				if(client.getPlanC().getCodPlan()==planes.get(i).getCodPlan()) {
					cant[i]++;
				}
			}
			
		}
		return cant;
	}
}
