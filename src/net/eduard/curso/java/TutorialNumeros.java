package net.eduard.curso.java;

public class TutorialNumeros {

	public static void main(String[] args) {
		double gerandoUmNan = 0D / 0D;
		double gerandoUmInfinito = 1D / 0D;


		System.out.println(gerandoUmNan);
		System.out.println(gerandoUmInfinito);
	}

	public static void numerosBugados() {
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 5; y++) {
				System.out.printf("		%s << %s = %s", x, y, x << y);
				System.out.printf("	%s >> %s = %s", x, y, x >> y);
			}
		}
	}
}
