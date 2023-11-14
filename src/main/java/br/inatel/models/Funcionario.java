package br.inatel.models;

/**
 * Model da tabela "funcionario".
 */
public class Funcionario {
    private int id;             // id do funcionario
    private String nome;        // nome do funcionario
    private String telefone;    // telefone do funcionario
    private int salario;        // salario do funcionario
    private String senha;       // senha do funcionario para acessar o sistema
    private int idLocadora;    // id da locadora que o funcionario trabalha

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
     * Getter do telefone
     * @return telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Getter do salario
     * @return salario
     */
    public int getSalario() {
        return salario;
    }

    /**
     * Getter do senha
     * @return senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Getter do idLocadora
     * @return idLocadora
     */
    public int getIdLocadora() {
        return idLocadora;
    }
}
