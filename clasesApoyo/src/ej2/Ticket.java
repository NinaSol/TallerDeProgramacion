package ej2;

public class Ticket {
private String nombreCompleto;
private double total;
private double montoCuota;

public Ticket(String nombreCompleto, double total, double montoCuota) {
	this.nombreCompleto = nombreCompleto;
	this.total = total;
	this.montoCuota = montoCuota;
}

@Override
public String toString() {
	return "Ticket [nombreCompleto=" + nombreCompleto + ", total=" + total + ", montoCuota=" + montoCuota + "]";
}



}
