package ej2;

public class Posnet {
	private final int INCREMENTO = 3;
	private final int MIN_CUOTAS = 1;
	private final int MAX_CUOTAS = 6;

	private boolean datosValidos(double monto,int cantCuotas) {
		return monto > 0 && cantCuotas >= this.MIN_CUOTAS && cantCuotas <= this.MAX_CUOTAS;
	}
	
	public double incrementoPorCuota(int cuotas,double total) {
		return INCREMENTO * (cuotas - 1) * total / 100;
	}
	
	public Ticket efectuarPago(Tarjeta tarjeta, double total, int cuotas) {
		Ticket ticket = null;
		String nombreCompletoTitular = tarjeta.getNombreCompletoTitular();
		double montoPorCuota;

			if (datosValidos(total,cuotas)) {
				double aumento = incrementoPorCuota(cuotas,total);
				total += aumento;
				if (tarjeta.calcularSaldo(aumento)) {
					montoPorCuota = total/cuotas;
					tarjeta.cobrar(montoPorCuota);
					ticket = new Ticket(nombreCompletoTitular, total, montoPorCuota);
				}

			}

		
		return ticket;
	}
	
	
}
	

