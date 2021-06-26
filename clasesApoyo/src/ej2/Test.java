package ej2;

public class Test {

	public static void main(String[] args) {
		Posnet posnet = new Posnet();
		Persona titular = new Persona("45698745","Juana","Gomez",1123659874,"juanagomez@gmail.com");
		Tarjeta tarjeta = new Tarjeta("Galicia","132654897895",15000,titular,Entidad.VISA);
		
		Ticket ticket;
		ticket = posnet.efectuarPago(tarjeta, 10000, 5);
		System.out.println(ticket);
		

	}

}
