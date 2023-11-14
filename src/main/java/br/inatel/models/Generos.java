package br.inatel.models;

/**
 * Model da tabela "generos". (Esta tabela é um campo multivalorado de "info_filme".
 */
public class Generos {
    private int id;             // id do genero do filme
    private int idInfoFilme;    // id das infos do filme referente
    private String nome;        // genero do filme

    /**
     * Construtor da Classe Generos para retorno de uma query (SELECT)
     * @param id id do genero do filme
     * @param idInfoFilme id das infos do filme referente
     * @param nome genero do filme
     */
    public Generos(int id, int idInfoFilme, String nome) {
        this.id = id;
        this.idInfoFilme = idInfoFilme;
        this.nome = nome;
    }

    /**
     * Construtor da Classe Generos para inserção de um novo (INSERT)
     * @param idInfoFilme id das infos do filme referente
     * @param nome genero do filme
     */
    public Generos(int idInfoFilme, String nome) {
        this.idInfoFilme = idInfoFilme;
        this.nome = nome;
    }

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
