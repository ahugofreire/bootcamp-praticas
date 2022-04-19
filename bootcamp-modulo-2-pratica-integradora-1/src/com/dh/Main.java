package com.dh;

public class Main {
    public static void main(String[] args) {
        Pessoa desconhecido = new Pessoa();
        Pessoa jonhDoe = new Pessoa("John Doe", 38, "VSA1234" );
        Pessoa johnTre = new Pessoa("John Tre", 17, "VSA1235", 68.5, 1.70);
//
        Integer imcJohn = johnTre.calcularIMC();

        String nivelDePeso;

        switch (imcJohn) {
            case -1 :
                nivelDePeso = "Abaixo do peso";
                break;
            case 1:
                nivelDePeso = "Sobrepeso";
                break;
            default:
                nivelDePeso = "Peso Saudável";
        }

        System.out.println("========================");
        System.out.println("Olá, " + johnTre.getNome());
        System.out.println("Seu IMC está: " + nivelDePeso);

        if (johnTre.ehMaiorIdade()) {
            System.out.println("Sua idade é: " + johnTre.getIdade());
            System.out.println("Fique atento adultos podem armazenar gordura mais rápido.");
        } else {
            System.out.println("Sua idade é: " + johnTre.getIdade());
            System.out.println("Relaxe você é jovem, mas sempre faça exercicios.");
        }

        System.out.printf("%s", johnTre.toString());
        System.out.println("\n========================");

    }
}
