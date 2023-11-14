package br.inatel.models;

/**
 * Model da tabela "aluguel"
 */
public class Aluguel {
    private int id;                 // id do aluguel
    private String dataLocacao;    // data que a locação foi feita
    private String dataDevolucao;  // data de devolução dos filmes
    private String status;          // "no prazo", "devolvido", "em atraso"
    private int multa;              // valor da multa caso haja
    private int idCliente;         // id do cliente que realizou a locação
    private int idLocadora;        // id da locadora onde se realizou a locação

    /**
     * Getter do id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Getter da dataLocacao
     * @return dataLocacao
     */
    public String getdataLocacao() {
        return dataLocacao;
    }

    /**
     * Getter da dataDevolucao
     * @return dataDevolucao
     */
    public String getdataDevolucao() {
        return dataDevolucao;
    }

    /**
     * Getter do status
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Getter da multa
     * @return multa
     */
    public int getMulta() {
        return multa;
    }

    /**
     * Getter do idCliente
     * @return idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Getter do idLocadora
     * @return idLocadora
     */
    public int getIdLocadora() {
        return idLocadora;
    }
}
