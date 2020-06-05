package net.eduard.curso.java;

public class TesteOperadorAnd {

    public static void main(String[] args) {
            int max = 10;
        for (int x= 1;x<=max;x++){

            for (int y= 1;y<=max;y++){
                System.out.println(""+x+" & "+y +" = "+ (x & y)+" | "+ (y & x)+" x= "+x +" y= "+y);
            }
        }
    }

}
