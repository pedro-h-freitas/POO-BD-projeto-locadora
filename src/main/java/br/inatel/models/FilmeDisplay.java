package br.inatel.models;

import java.time.Year;

/**
 * Model para exibir infos do filme
 */
public class FilmeDisplay {
    private int id;
    private String nome;
    private int ano;
    private String generos;
    private int preco;
    private int nCopias;
    private int nDisponiveis;

    /**
     * Construtor para mostrar Filmes
     */
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

    /**
     * Construtor para mostrar InfoFilmes
     */
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

    /**
     * Construtor para criar novo InfoFilmes
     */
    public FilmeDisplay(String nome, int ano, String generos) {
        this.nome = nome;
        this.ano = ano;
        this.generos = generos;
    }

    /**
     * Getter do id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter do id
     * @param id id novo
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Getter do nome
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Setter do nome
     * @param nome nome novo
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Getter do ano
     * @return ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * Getter dos generos
     * @return generos
     */
    public String getGeneros() {
        return generos;
    }
    
    /**
     * Getter do preco
     * @return preco
     */
    public int getPreco() {
        return preco;
    }
    
    /**
     * Getter do numero de copias
     * @return numero de copias
     */
    public int getnCopias() {
        return nCopias;
    }
    
    /**
     * Getter de quantidade de copias disponiveis
     * @return quantidade de copias disponiveis
     */
    public int getnDisponiveis() {
        return nDisponiveis;
    }

}
