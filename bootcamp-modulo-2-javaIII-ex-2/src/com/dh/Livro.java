package com.dh;

public class Livro implements Documento {

    private int numpag;
    private String autor;
    private String titulo;
    private String genero;

    public Livro(int numpag, String autor, String titulo, String genero) {
        this.numpag = numpag;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public String extrairImp() {
        return "Imprimir Livro\n" +
                "Dados do livro:\n" +
                String.format("Número de páginas: %d | Autor %s | Título: %s | Gênero: %s\n", numpag, autor, titulo, genero);
    }
}
