package br.inatel.models;

/**
 * Model da tabela "info_filme".
 */
public class InfoFilme {
    private int id;             // id das informações do filme
    private String nome;        // nome do filme
    private int anoLancamento;  // ano de lancamento do filme

    /**
     * Construtor da Classe InfoFilme para retorno de uma query (SELECT)
     * @param id id das informações do filme
     * @param nome nome do filme
     * @param anoLancamento ano de lancamento do filme
     */
    public InfoFilme(int id, String nome, int anoLancamento) {
        this.id = id;
        this.nome = nome;
        this.anoLancamento = anoLancamento;
    }

    /**
     * Construtor da ClasseInfo Filme para inserção de um novo (INSERT)
     * @param nome nome do filme
     * @param anoLancamento ano de lancamento do filme
     */
    public InfoFilme(String nome, int anoLancamento) {
        this.id = -1;
        this.nome = nome;
        this.anoLancamento = anoLancamento;
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
     * Getter do anoLancamento
     * @return anoLancamento
     */
    public int getAnoLancamento() {
        return anoLancamento;
    }
}
