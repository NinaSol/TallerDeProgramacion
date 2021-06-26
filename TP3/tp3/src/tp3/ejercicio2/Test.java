package tp3.ejercicio2;


/*
 Una compañía está compuesta por distintas áreas.
Las áreas están distribuidas en una o más oficinas.
Una oficina pertenece a una única área y en ella sólo trabajan
los empleados de dicha oficina. La compañía precisa informar
el nombre de todos sus empleados, indicando a qué área y a qué 
oficina pertenecen. ¿Qué métodos agregarías, y en qué clases?
 */
public class Test {
	public static void main(String[] args) {
		Compania empresa = new Compania("Amazon");
		
		System.out.println(empresa.crearArea("Sistemas"));
		
		
		
		
		
	}
}
