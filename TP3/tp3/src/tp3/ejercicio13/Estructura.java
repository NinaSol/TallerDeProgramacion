package tp3.ejercicio13;

import java.util.ArrayList;

public class Estructura {
	private ArrayList<Integer> numeros1;
	private ArrayList<Integer> numeros2;

	public Estructura() {
		this.numeros1 = new ArrayList<Integer>();
		this.numeros2 = new ArrayList<Integer>();

	}

	public void agregarNumero1(int numero) {
		if (!this.numeros1.contains(numero)) {
			this.numeros1.add(numero);
		}
	}

	public void agregarNumero2(int numero) {
		if (!this.numeros2.contains(numero)) {
			this.numeros2.add(numero);
		}
	}

//	public void masAntiguoAlMasModerno() {
//		if (this.numeros1.size() > this.numeros2.size()) {
//			for (int i = 0; i < this.numeros1.size(); i++) {
//				if (i < this.numeros1.size() - 1) {
//					if (this.numeros1.get(i) < this.numeros2.get(i)) {
//						System.out.println(this.numeros1.get(i));
//						System.out.println(this.numeros2.get(i));
//					} else if (this.numeros2.get(i) < this.numeros1.get(i)) {
//						System.out.println(this.numeros1.get(i));
//						System.out.println(this.numeros2.get(i));
//					}
//				}
//			}
//		} else {
//			for (int i = 0; i < this.numeros2.size(); i++) {
//				if (i < this.numeros2.size() - 1) {
//					if (this.numeros2.get(i) < this.numeros1.get(i)) {
//						System.out.println(this.numeros2.get(i));
//						System.out.println(this.numeros1.get(i));
//					} else if (this.numeros1.get(i) < this.numeros2.get(i)) {
//						System.out.println(this.numeros1.get(i));
//						System.out.println(this.numeros2.get(i));
//					}
//				}else {
//					System.out.println(this.numeros2.get(i));
//				}
//			}
//		}
//	}

	public void masAntiguoAlMasModerno() {
		int a = 0;
		int b = 0;
		if (this.numeros1.size() < this.numeros2.size()) {
			while (a < this.numeros1.size() || b < this.numeros2.size()) {
				if (a < this.numeros1.size()) {
					if (this.numeros1.get(a) < this.numeros2.get(b)) {
						System.out.println(this.numeros1.get(a));
						a++;
					} else {
						System.out.println(this.numeros2.get(b));
						b++;
					}
				} else {
					if (b < this.numeros2.size()) {
						System.out.println(this.numeros2.get(b));
						b++;
					}
				}

			}
		}
	}

}
