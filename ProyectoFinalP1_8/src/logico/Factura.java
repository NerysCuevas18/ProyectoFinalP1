package logico;

import java.util.Calendar;
import java.util.Date;

public class Factura { 
	
	private String codFactura;
	private Cliente cliente;
	private Date creacionFactura;
	private Date vencimientoFactura;
	private boolean pagada;
	private float monto;
	
	public Factura(String codFactura, Cliente cliente) {
		super();
		this.codFactura = codFactura;
		this.cliente = cliente;
		this.creacionFactura = new Date();
		Calendar vence = Calendar.getInstance();
		vence.setTime(creacionFactura);
		vence.add(Calendar.DAY_OF_YEAR, 10);
		this.vencimientoFactura = vence.getTime();
		this.pagada = false;
		this.monto = montoFactura();
	}
	
	private float montoFactura(){
		float cant = cliente.getPlanC().getPrecioP();
		int cantSinPagar = 0;
		for(int i = 0; i<cliente.getFacturasMensual().size(); i++)
		if (!(cliente.getFacturas().index(i).isPagada())) cantSinPagar++;
		switch (cantSinPagar) {
		case 1: 
			cant += cant*0.05;
			break;
		case 2:
			cant += cant*0.1;
			cliente.setEstado(false);
			break;
		default:
			break;				
		}
		return cant;
	}

	public String getCodFactura() {
		return codFactura;
	}

	public void setCodFactura(String codFactura) {
		this.codFactura = codFactura;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getCreacionFactura() {
		return creacionFactura;
	}

	public void setCreacionFactura(Date creacionFactura) {
		this.creacionFactura = creacionFactura;
	}

	public Date getVencimientoFactura() {
		return vencimientoFactura;
	}

	public void setVencimientoFactura(Date vencimientoFactura) {
		this.vencimientoFactura = vencimientoFactura;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public boolean isPagada() {
		return pagada;
	}

	public void setPagada(boolean pagada) {
		this.pagada = pagada;
	}

}
