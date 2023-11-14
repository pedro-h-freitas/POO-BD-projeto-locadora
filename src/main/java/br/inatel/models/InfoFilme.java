package br.inatel.models;

/**
 * Model da tabela "info_filme".
 */
public class InfoFilme {
    private int id;             // id das informações do filme
    private String nome;        // nome do filme
    private int anoLancamento;  // anoLancamento do filme

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
     * Getter do anoLancamento
     * @return anoLancamento
     */
    public int getAnoLancamento() {
        return anoLancamento;
    }
}
