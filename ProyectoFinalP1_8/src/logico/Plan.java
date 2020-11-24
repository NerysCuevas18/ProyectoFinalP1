package logico;

public class Plan {
	private static int codPlan = 0;
	private String nombreP;
	private String descripcionP;
	private float precioP;
	private String tipoPlan;
	
	public Plan(String nombreP, String descripcionP, float precioP, String tipoPlan) {
		super();
		this.nombreP = nombreP;
		this.descripcionP = descripcionP;
		this.precioP = precioP;
		this.tipoPlan = tipoPlan;
	}
	
	public static int getCodPlan() {
		return codPlan;
	}

	public static void setCodPlan(int codPlan) {
		Plan.codPlan = codPlan;
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

	public float getPrecioP() {
		return precioP;
	}

	public void setPrecioP(float precioP) {
		this.precioP = precioP;
	}

	public String getTipoPlan() {
		return tipoPlan;
	}

	public void setTipoPlan(String tipoPlan) {
		this.tipoPlan = tipoPlan;
	}

		

}
