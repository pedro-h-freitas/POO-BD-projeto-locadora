package br.inatel.models;

import java.time.Year;

public class FilmeDisplay {
    private int id;
    private String nome;
    private int ano;
    private String generos;
    private int preco;
    private int nCopias;
    private int nDisponiveis;

    public FilmeDisplay(int id, String nome, int ano, String generos, int nCopias, int nDisponiveis) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
        this.generos = generos;
        this.nCopias = nCopias;
        this.nDisponiveis = nDisponiveis;

        preco = 10 - (Year.now().getValue() - this.getAno());
        if (preco < 5) preco = 5;
    }

    public FilmeDisplay(int id, String nome, int ano, String generos) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
        this.generos = generos;
        this.nCopias = -1;
        this.nDisponiveis = -1;

        preco = 10 - (Year.now().getValue() - this.getAno());
        if (preco < 5) preco = 5;
    }

    public FilmeDisplay(String nome, int ano, String generos) {
        this.nome = nome;
        this.ano = ano;
        this.generos = generos;
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

    public int getnCopias() {
        return nCopias;
    }

    public void setnCopias(int nCopias) {
        this.nCopias = nCopias;
    }

    public int getnDisponiveis() {
        return nDisponiveis;
    }

    public void setnDisponiveis(int nDisponiveis) {
        this.nDisponiveis = nDisponiveis;
    }
}
