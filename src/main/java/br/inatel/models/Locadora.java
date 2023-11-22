package br.inatel.models;

/**
 * Model da tabela "locadora".
 */
public class Locadora {
    private int id;             // id da locadora
    private String nome;        // nome da locadora
    private String cidade;    // cidade da locadora
    private int idGerente;      // id do gerente da locadora

    /**
     * Construtor da Classe Locadora para retorno de uma query (SELECT)
     * @param id id da locadora
     * @param nome nome da locadora
     * @param cidade cidade da locadora
     * @param idGerente id do gerente da locadora
     */
    public Locadora(int id, String nome, String cidade, int idGerente) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.idGerente = idGerente;
    }

    /**
     * Construtor da Classe Locadora para inserção de um novo (INSERT)
     * @param nome nome da locadora
     * @param cidade cidade da locadora
     * @param idGerente id do gerente da locadora
     */
    public Locadora(String nome, String cidade, int idGerente) {
        this.nome = nome;
        this.cidade = cidade;
        this.idGerente = idGerente;
    }

    /**
     * Getter do id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Getter do nome
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Getter do cidade
     * @return cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * Getter do idGerente
     * @return idGerente
     */
    public int getIdGerente() {
        return idGerente;
    }

    @Override
    public String toString() {
        return "Id: " + id + ",\n" +
                "Nome: " + nome + ",\n" +
                "Cidade: " + cidade;
    }
}
