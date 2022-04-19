package com.dh;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Pessoa johnDoe = new Pessoa("John", "Doe", "1133161111");
        Curriculo curriculo = new Curriculo(johnDoe);

        curriculo.addHabilidades(new String[]{"Ingles", "Java", "Banco de dados", ""});

        Livro livro = new Livro(250, "Uncle Bob ", "Código Limpo", "Tecnologia");

        Relatorio relatorio = new Relatorio(10, "John Doe", "Uncle Bob", "Hello world...");

        List<Documento> documentos = List.of(curriculo, livro, relatorio);
        for ( Documento doc: documentos) {
            Impressora.imprimir(doc);
        }

    }
}
