package com.dh;

public class Pereciveis extends  Produto{
    private int diasParaVencer;


    public Pereciveis(String nome, double preco, int diasParaVencer) {
        super(nome, preco);
        this.diasParaVencer = diasParaVencer;
    }

    public int getDiasParaVencer() {
        return diasParaVencer;
    }

    public void setDiasParaVencer(int diasParaVencer) {
        this.diasParaVencer = diasParaVencer;
    }

    @Override
    public double calcular(int quantidadeProdutos) {
        double preco = super.calcular(quantidadeProdutos);

        if (diasParaVencer == 1) {
            preco /=4;
        }
        if (diasParaVencer == 2) {
            preco /=3;
        }
        if (diasParaVencer == 3) {
            preco /=3;
        }

        return preco;
    }

    @Override
    public String toString() {
        return "Pereciveis{" +
                "diasParaVencer=" + diasParaVencer +
                '}';
    }
}
