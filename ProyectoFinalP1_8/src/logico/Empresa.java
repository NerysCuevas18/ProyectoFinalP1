package logico;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
	private int facture;
	private float[] cant;
	
	private Empresa() {
		super();
		this.empleados = new ArrayList<Empleado>();
		this.clientes = new ArrayList<Cliente>();
		this.planes = new ArrayList<Plan>();
		this.facturas = new ArrayList<Factura>();
		this.setConexion(false);
		this.facture = 0;
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
	
	public float[] getCant() {
		return cant;
	}
	
	public void setCant(float[] cant) {
		this.cant = cant;
	}
	public void generarFacturas() {
			Date hoy = new Date();
			Calendar facturar = Calendar.getInstance();
			facturar.setTime(hoy);
			
			if(((facturar.get(Calendar.DAY_OF_MONTH))==15) && !facturasGeneradas) {
				for(int i = 0; i<clientes.size(); i++) {
					if(clientes.get(i).isEstado() && clientes.get(i).getPlanC() != null) {
						Factura fact = new Factura("ALT"+(1000+codFacturas), clientes.get(i));
						codFacturas++;
						clientes.get(i).addFactura(fact);
						Empresa.getInstance().insertarFactura(fact);
						
						File archivo = new File ("Facturas/FacturaAltice"+facture+".txt");
						fact.setFact("Facturas/FacturaAltice"+facture+".txt");
						facture++;
				        FileWriter escritor;
				        try {
				        	Date today = new Date();
							escritor = new FileWriter(archivo);
							Calendar calendar = Calendar.getInstance();
							calendar.setTime(today);
							ArrayList<String> info = new ArrayList<String>();
							info.add("| - - - - - - - - - - - - - - - - - - - -|   Altice Rep. Dom  | - - - - - - - - - - - - - - - - - - -|");
							info.add("");
							info.add("    ~ ~ ~ ~ ~ ~ ~ ~ ~ Cliente ~ ~ ~ ~ ~ ~ ~ ~ ~            ~ ~ ~ ~ Factura "+fact.getCodFactura()+"~ ~ ~ ~ ~ ~ ~ ~ ~");
							info.add("    + Nombre: "+clientes.get(i).getNombres());
							info.add("    + Apellido: "+clientes.get(i).getApellidos());
							info.add("    + Cédula: "+clientes.get(i).getCedula()+"                                + Fecha: "+calendar.getTime());
							info.add("    + Teléfono: "+clientes.get(i).getTelefonos()+"           + Vencimiento: "+fact.getVencimientoFactura());
							info.add("    + Correo: "+clientes.get(i).getCorreo());
							info.add("    ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~            ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
							info.add("");
							info.add("");
							info.add("                                                  +-+-+");
							info.add("");
							info.add("                          Plan             Nombre                 Precio");
							String volumen = clientes.get(i).getPlanC().getNombreP();
						    while(volumen.length()<23) volumen+=" ";
							info.add("                          "+clientes.get(i).getPlanC().getCodPlan()+"           "+volumen+"RD$"+clientes.get(i).getPlanC().getPrecioFinal());
							info.add("");
							info.add("");
							info.add("                                                  +-+-+");
							info.add("                                          Total: RD$"+clientes.get(i).getPlanC().getPrecioFinal());
							info.add("");
							info.add("");
							info.add("                                    Altice: Hechos de vida, hechos de fibra");
							info.add("");
							info.add("| - - - - - - - - - - - - - - - - - - - - - - - |   Factura   | - - - - - - - - - - - - - - - - - - - - - - -|");
									
							for (int j=0; j<info.size(); j++) {
					        for (int n=0; n<info.get(j).length(); n++)
					            escritor.write(info.get(j).charAt(n));
					            escritor.write('\n');
							}
					        escritor.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						
					}
				}
				facturasGeneradas = true;
			} else if (((facturar.get(Calendar.DAY_OF_MONTH))!=15) && facturasGeneradas) {
				facturasGeneradas = false;
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
	public Factura findFactura (String codFac) {
		Factura misFacturas = null;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i<facturas.size()){
			if(facturas.get(i).getCodFactura().equalsIgnoreCase(codFac)) {
				misFacturas = facturas.get(i);
				encontrado = true;
			}
			i++;
		}
		return misFacturas;
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
	
	public void eliminarCliente(Cliente aux) {
		int index = getIndexCliente(aux.getCedula());
		clientes.remove(index);		
	}
	
	public void eliminarEmpleado(Empleado aux) {
		int index = getIndexEmpleado(aux.getCedula());
		empleados.remove(index);		
	}
	
	public void eliminarPlan(Plan aux) {
		int index = getIndexPlan(aux.getCodPlan());
		planes.remove(index);		
	}
		
	public int getIndexCliente(String id) {
		int aux = -1;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i<clientes.size()){
			if(clientes.get(i).getCedula().equalsIgnoreCase(id)) {
				aux = i;
				encontrado = true;
			}
			i++;
		}
		return aux;
	}
	
	public int getIndexEmpleado(String id) {
		int aux = -1;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i<empleados.size()){
			if(empleados.get(i).getCedula().equalsIgnoreCase(id)) {
				aux = i;
				encontrado = true;
			}
			i++;
		}
		return aux;
	}
	
	public int getIndexPlan(String id) {
		int aux = -1;
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i<planes.size()){
			if(planes.get(i).getCodPlan().equalsIgnoreCase(id)) {
				aux = i;
				encontrado = true;
			}
			i++;
		}
		return aux;
	}
	public void totalPagoMes(Factura fact, Date date) {
		
		float[] cant1 = new float[12];
		Calendar facturar = Calendar.getInstance();
		facturar.setTime(date);
		
		if(facturar.get(Calendar.MONTH)==0) {
			cant1[0]= cant1[0]+fact.getMonto();
			
		}else if(facturar.get(Calendar.MONTH)==1) {
			cant1[1]= cant1[1]+fact.getMonto();

		}else if(facturar.get(Calendar.MONTH)==2) {
			cant1[2]= cant1[2]+fact.getMonto();

		}else if(facturar.get(Calendar.MONTH)==3) {
			cant1[3]= cant1[3]+fact.getMonto();

		}else if(facturar.get(Calendar.MONTH)==4) {
			cant1[4]= cant1[4]+fact.getMonto();

		}else if(facturar.get(Calendar.MONTH)==5) {
			cant1[5]= cant1[5]+fact.getMonto();

		}else if(facturar.get(Calendar.MONTH)==6) {
			cant1[6]= cant1[6]+fact.getMonto();

		}else if(facturar.get(Calendar.MONTH)==7) {
			cant1[7]= cant1[7]+fact.getMonto();

		}else if(facturar.get(Calendar.MONTH)==8) {
			cant1[8]= cant1[8]+fact.getMonto();

		}else if(facturar.get(Calendar.MONTH)==9) {
			cant1[9]= cant1[9]+fact.getMonto();

		}else if(facturar.get(Calendar.MONTH)==10) {
			cant1[10]= cant1[10]+fact.getMonto();

		}else if(facturar.get(Calendar.MONTH)==11) {
			cant1[11]= cant1[11]+fact.getMonto();

		}
		this.cant = cant1;	
	}
}
