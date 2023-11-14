package br.inatel.models;

/**
 * Model da tabela "aluguel"
 */
public class Aluguel {
    private int id;                 // id do aluguel
    private String dataLocacao;     // data que a locação foi feita
    private String dataDevolucao;   // data de devolução dos filmes
    private String status;          // "no prazo", "devolvido", "em atraso"
    private int multa;              // valor da multa caso haja
    private int idCliente;          // id do cliente que realizou a locação
    private int idLocadora;         // id da locadora onde se realizou a locação

    /**
     * Construtor da Classe Aluguel para retorno de uma query (SELECT)
     * @param id id do aluguel
     * @param dataLocacao data que a locação foi feita
     * @param dataDevolucao data de devolução dos filmes
     * @param status "no prazo", "devolvido", "em atraso"
     * @param multa valor da multa caso haja
     * @param idCliente id do cliente que realizou a locação
     * @param idLocadora id da locadora onde se realizou a locação
     */
    public Aluguel(int id, String dataLocacao, String dataDevolucao, String status, int multa, int idCliente, int idLocadora) {
        this.id = id;
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao;
        this.status = status;
        this.multa = multa;
        this.idCliente = idCliente;
        this.idLocadora = idLocadora;
    }

    /**
     * Construtor da Classe Aluguel para inserção de um novo (INSERT)
     * @param dataLocacao data que a locação foi feita
     * @param idCliente id do cliente que realizou a locação
     * @param idLocadora id da locadora onde se realizou a locação
     */
    public Aluguel(String dataLocacao, int idCliente, int idLocadora) {
        this.dataLocacao = dataLocacao;
        this.idCliente = idCliente;
        this.idLocadora = idLocadora;
    }

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
