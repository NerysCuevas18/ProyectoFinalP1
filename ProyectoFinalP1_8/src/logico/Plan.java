package logico;

public class Plan {
	private String codPlan;
	private String nombreP;
	private String descripcionP;
	private float precioBase;
	private float precioFinal;
	private String tipoPlan;
	
	public Plan(String codPlan, String nombreP, String descripcionP, float precioBase, String tipoPlan) {
		super();
		this.codPlan = codPlan;
		this.nombreP = nombreP;
		this.descripcionP = descripcionP;
		this.precioBase = precioBase;
		this.tipoPlan = tipoPlan;
	}
	
	public String getCodPlan() {
		return codPlan;
	}

	public void setCodPlan(String codPlan) {
		this.codPlan = codPlan;
	}

	public String getNombreP() {
		return nombreP;
	}

	public void setNombreP(String nombreP) {
		this.nombreP = nombreP;
	}

	public String getDescripcionP() {
		return descripcionP;
	}

	public void setDescripcionP(String descripcionP) {
		this.descripcionP = descripcionP;
	}

	public float getPrecioBase() {
		return precioBase;
	}
	
	public void setPrecioBase(float precioBase) {
		this.precioBase = precioBase;
	}
	
	public float getPrecioFinal() {
		return precioFinal;
	}
	
	public String getTipoPlan() {
		return tipoPlan;
	}

	public void setTipoPlan(String tipoPlan) {
		this.tipoPlan = tipoPlan;
	}
	
	public float generarImpPlan() {
		float imp = 0;
		imp = (float) (precioBase*0.3);
		this.precioFinal = precioBase + imp;
		return imp;
	}
		

}
