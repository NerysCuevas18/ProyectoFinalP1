package logico;

public class Plan {
	static int codPlan = 0;
	String nombreP;
	String descripcionP;
	float precioP;
	
	public Plan(String nombreP, String descripcionP, float precioP) {
		super();
		this.nombreP = nombreP;
		this.descripcionP = descripcionP;
		this.precioP = precioP;
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
	
	
	
	
	

}
