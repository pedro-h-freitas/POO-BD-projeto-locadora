package br.inatel.models;

/**
 * Model da tabela "filme_alugado".
 */
public class FilmeAlugado {
    private int idAluguel;  // id de Aluguel de um ou mais filmes
    private int idFilme;    // id do Filme alugado

    /**
     * Construtor da Classe FilmeAlugado para INSERT e SELECT
     * @param idAluguel id de Aluguel de um ou mais filmes
     * @param idFilme id do Filme alugado
     */
    public FilmeAlugado(int idAluguel, int idFilme) {
        this.idAluguel = idAluguel;
        this.idFilme = idFilme;
    }

    /**
     * Getter do idAluguel
     * @return idAluguel
     */
    public int getIdAluguel() {
        return idAluguel;
    }

    /**
     * Getter do idFilme
     * @return idFilme
     */
    public int getIdFilme() {
        return idFilme;
    }
}
