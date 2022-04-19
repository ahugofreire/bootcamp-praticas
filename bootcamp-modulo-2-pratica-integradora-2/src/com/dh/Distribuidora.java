package com.dh;

import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        Produto iphone = new Produto("Iphone13", 8550.49);
        Produto macbookAir = new Produto("MacBook Air m1", 7999.99);
        Pereciveis iogurte = new Pereciveis("Iogurte Natural", 7.29, 5);
        Pereciveis camarao = new Pereciveis("Camarão",  30.55, 5);
        NaoPereciveis oleo = new NaoPereciveis("Oleo de Soja", 8.99, "Alimento");
        NaoPereciveis sal = new NaoPereciveis("Sal", 2.10, "Alimento");
        NaoPereciveis cafe = new NaoPereciveis("Café", 2.10, "Alimento");


        List<Produto> produtos = List.of(iphone, macbookAir, iogurte,camarao,oleo,sal,cafe);

        for ( Produto prod: produtos) {
            int qtde = (int) (Math.random() * 5);

            double preco = prod.calcular(qtde);
            System.out.println("Produto: " + prod.toString());
            System.out.println("Preço Total: " + preco);
            System.out.println("Quantidade: " + qtde);
        }

    }
}
