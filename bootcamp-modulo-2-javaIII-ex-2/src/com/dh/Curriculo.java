package com.dh;

import java.util.LinkedList;
import java.util.List;

public class Curriculo  implements  Documento{
    private Pessoa pessoa;
    private List<String> habilidades;

    public Curriculo(Pessoa pessoa) {
        this.pessoa = pessoa;
        habilidades = new LinkedList<>();
    }

    public void addHabilidades(String[] habilidade) {
        habilidades.addAll(List.of(habilidade));
    }

    @Override
    public String extrairImp() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Imprimir currículo\n");
        stringBuilder.append("Dados do currículo:\n");
        stringBuilder.append(String.format("Nome: %s, Sobrenome: %s, Telefone: %s\n",pessoa.getNome(), pessoa.getSobrenome(), pessoa.getTelefone()));
        stringBuilder.append("Habilidades: \n");
        habilidades.forEach((habilidade -> stringBuilder.append(habilidade).append("\n")));
        return stringBuilder.toString();
    }

}
