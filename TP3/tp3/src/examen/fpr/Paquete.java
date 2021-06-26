package examen.fpr;

public class Paquete {
	private String codigo;
	private double kg;
	
	public Paquete(String codigo, double kg) {
		setCodigo(codigo);
		setKg(kg);
	}

	private void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	private void setKg(double kg) {
		this.kg = kg;
	}
	
	
	public double getKg() {
		return this.kg;
	}
	
	
	public boolean mismoCodigo(String codigo) {
		return this.codigo.equals(codigo);
	}
	
	
	
}
