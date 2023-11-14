package br.inatel.models;

/**
 * Model da tabela "locadora".
 */
public class Locadora {
    private int id;             // id da locadora
    private String nome;        // nome da locadora
    private String endereco;    // endereco da locadora
    private int idGerente;      // id do gerente da locadora

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
     * Getter do endereco
     * @return endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Getter do idGerente
     * @return idGerente
     */
    public int getIdGerente() {
        return idGerente;
    }
}
