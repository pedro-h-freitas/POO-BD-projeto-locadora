package br.inatel.models;

/**
 * Model da tabela "generos". (Esta tabela é um campo multivalorado de "info_filme".
 */
public class Generos {
    private int idInfoFilme;    // id das infos do filme referente
    private String nome;        // genero do filme

    /**
     * Getter do idInfoFilme
     * @return idInfoFilme
     */
    public int getIdInfoFilme() {
        return idInfoFilme;
    }

    /**
     * Getter do nome
     * @return nome
     */
    public String getNome() {
        return nome;
    }
}
