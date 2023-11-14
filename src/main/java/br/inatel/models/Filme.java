package br.inatel.models;

/**
 * Model da tabela "filme".
 */
public class Filme {
    private int id;             // id do filme
    private int nCopias;        // numero de cópias do filme na locadora
    private int nDisponiveis;   // numero de copias disponiveis na locadora
    private int idLocadora;     // id da locadora que esta o filme
    private int idInfoFilme;    // id das informações do filme

    /**
     * Construtor da Classe Filme para retorno de uma query (SELECT)
     * @param id id do filme
     * @param nCopias numero de cópias do filme na locadora
     * @param nDisponiveis numero de copias disponiveis na locadora
     * @param idLocadora id da locadora que esta o filme
     * @param idInfoFilme id das informações do filme
     */
    public Filme(int id, int nCopias, int nDisponiveis, int idLocadora, int idInfoFilme) {
        this.id = id;
        this.nCopias = nCopias;
        this.nDisponiveis = nDisponiveis;
        this.idLocadora = idLocadora;
        this.idInfoFilme = idInfoFilme;
    }

    /**
     * Construtor da Classe Filme para inserção de um novo (INSERT)
     * @param nCopias numero de cópias do filme na locadora
     * @param idLocadora id da locadora que esta o filme
     * @param idInfoFilme id das informações do filme
     */
    public Filme(int nCopias, int idLocadora, int idInfoFilme) {
        this.nCopias = nCopias;
        this.idLocadora = idLocadora;
        this.idInfoFilme = idInfoFilme;
    }

    /**
     * Getter do id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Getter do nCopias
     * @return nCopias
     */
    public int getnCopias() {
        return nCopias;
    }

    /**
     * Getter do nDisponiveis
     * @return nDisponiveis
     */
    public int getnDisponiveis() {
        return nDisponiveis;
    }

    /**
     * Getter do idLocadora
     * @return idLocadora
     */
    public int getIdLocadora() {
        return idLocadora;
    }

    /**
     * Getter do idInfoFilme
     * @return idInfoFilme
     */
    public int getIdInfoFilme() {
        return idInfoFilme;
    }
}
