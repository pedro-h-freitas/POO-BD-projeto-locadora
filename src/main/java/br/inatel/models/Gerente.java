package br.inatel.models;

/**
 * Model da tabela "gerente".
 */
public class Gerente {
    private int idFuncionario;  // id do funcionario (Gerente)

    /**
     * Construtor da Classe Gerente para INSERT e SELECT
     * @param idFuncionario id do funcionario (Gerente)
     */
    public Gerente(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    /**
     * Getter do idFuncionario
     * @return idFuncionario
     */
    public int getIdFuncionario() {
        return idFuncionario;
    }
}
