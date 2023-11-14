package br.inatel.models;

/**
 * Model da tabela "filme".
 */
public class Filme {
    private int id;             // id do filme
    private int nCopias;        // numero de cópias do filme na locadora
    private int nDisponiveis;   // numero de copias disponiveis na locadora
    private int idLocadora;     // id da locadora que esta o filme
    private int idInfoFilme;    // id das informações do filme
}
