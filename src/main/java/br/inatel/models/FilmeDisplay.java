package br.inatel.models;

import java.time.Year;

public class FilmeDisplay {
    private int id;
    private String nome;
    private int ano;
    private String generos;
    private int preco;

    public FilmeDisplay(int id, String nome, int ano, String generos) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
        this.generos = generos;

        preco = 10 - (Year.now().getValue() - this.getAno());
        if (preco < 5) preco = 5;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getGeneros() {
        return generos;
    }

    public void setGeneros(String generos) {
        this.generos = generos;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }
}
