package com.dh;

public class PraticaExcecoes {

    public static void main(String[] args) {
        int a = 0;
        int b = 300;

        try {
            double result = b/a;
            System.out.println(result);
        } catch(IllegalArgumentException e) {
            System.out.println("Não pode ser dividido por zero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
