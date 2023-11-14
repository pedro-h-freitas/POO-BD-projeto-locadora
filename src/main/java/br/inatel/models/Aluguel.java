package br.inatel.models;

/**
 * Model da tabela "aluguel"
 */
public class Aluguel {
    private int id;                 // id do aluguel
    private String data_locacao;    // data que a locação foi feita
    private String data_devolucao;  // data de devolução dos filmes
    private String status;          // "no prazo", "devolvido", "em atraso"
    private int multa;              // valor da multa caso haja
    private int id_cliente;         // id do cliente que realizou a locação
    private int id_locadora;        // id da locadora onde se realizou a locação
}
