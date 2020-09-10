package net.eduard.curso.java;


public class TesteBits {
    public static void numerosDiferenciados() {
        double gerandoUmNan = 0D / 0D;
        double gerandoUmInfinito = 1D / 0D;


        System.out.println(gerandoUmNan);
        System.out.println(gerandoUmInfinito);
    }

    public static void bitShifting() {
        // o operador >> é equivalente a dividir por 2
        // 10 >> 1 == 10 / 2
        // o operador << é o inverso equivalente a multiplicar por 2
        // 10 << 1 == 10 * 2
        // se aumentar o numerico da direta repete mais uma vez o processo
        // 10 >> 2 == 10 / 2 / 2 == 2.50
        // 100 >> 3 == 100 / 2 / 2 == 2.50


        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 5; y++) {
                System.out.printf("		%s << %s = %s", x, y, x << y);
                System.out.printf("	%s >> %s = %s", x, y, x >> y);
            }
        }
    }

    public static void xor(){
        for (int x = 2; x <= 2 ; x++) {
            for (int y = 1; y <= 100 ; y++) {
                System.out.println("x="+x +" y="+ y + " xor="+ (x ^ y ));
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(10 & 2);


    }

}
