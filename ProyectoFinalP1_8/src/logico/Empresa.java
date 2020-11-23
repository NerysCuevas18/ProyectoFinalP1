package logico;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Empresa { 
	
	private ArrayList<Empleado> empleados;
	private ArrayList<Cliente> clientes;
	private ArrayList<Plan> planes;
	private ArrayList<Factura> facturas;
	private static Empresa altice = null;
	private boolean facturasGeneradas;
	private int codFacturas = 1;
	
	private Empresa() {
		super();
		this.empleados = new ArrayList<Empleado>();
		this.clientes = new ArrayList<Cliente>();
		this.planes = new ArrayList<Plan>();
		this.facturas = new ArrayList<Factura>();
		this.facturasGeneradas = false;
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
	}
	
	public void insertarFactura(Factura factura) {
		facturas.add(factura);
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

}
