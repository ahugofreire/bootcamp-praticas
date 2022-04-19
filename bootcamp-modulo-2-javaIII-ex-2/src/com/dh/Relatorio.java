package com.dh;

public class Relatorio implements Documento {
    private int numpag;
    private String autor;
    private String revisor;
    private String texto;

    public Relatorio(int numpag, String autor, String revisor, String texto) {
        this.numpag = numpag;
        this.autor = autor;
        this.revisor = revisor;
        this.texto = texto;
    }

    @Override
    public String extrairImp() {
        return "Imprimir relatório\n" +
                "Dados do relatório:\n" +
                String.format("Número de páginas: %d | Autor %s | Revisor: %s | Texto: %s\n", numpag, autor, revisor, texto);
    }
}
