package br.inatel.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Model da tabela "funcionario".
 */
public class Funcionario {
    private int id;             // id do funcionario
    private String nome;        // nome do funcionario
    private String telefone;    // telefone do funcionario
    private int salario;        // salario do funcionario
    private String senha;       // senha do funcionario para acessar o sistema
    private int idLocadora;     // id da locadora que o funcionario trabalha

    /**
     * Construtor da Classe Funcionario para retorno de uma query (SELECT)
     * @param id id do funcionario
     * @param nome nome do funcionario
     * @param telefone telefone do funcionario
     * @param salario salario do funcionario
     * @param senha senha do funcionario para acessar o sistema
     * @param idLocadora id da locadora que o funcionario trabalha
     */
    public Funcionario(int id, String nome, String telefone, int salario, String senha, int idLocadora) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.salario = salario;
        this.senha = senha;
        this.idLocadora = idLocadora;
    }

    /**
     * Construtor da Classe Funcionario para inserção de um novo (INSERT)
     * @param nome nome do funcionario
     * @param telefone telefone do funcionario
     * @param salario salario do funcionario
     * @param senha senha do funcionario para acessar o sistema
     * @param idLocadora id da locadora que o funcionario trabalha
     */
    public Funcionario(String nome, String telefone, int salario, String senha, int idLocadora) {
        this.nome = nome;
        this.telefone = telefone;
        this.salario = salario;
        this.senha = senha;
        this.idLocadora = idLocadora;
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

    /**
     * Função para mapear um ResultSet em um model.Funcionario
     * @param rs ResultSet de um SELECT na table Funcionario
     * @return Funcionario mapeado
     */
    public static Funcionario sqlMapper(ResultSet rs) {
        try {
            return new Funcionario(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("telefone"),
                    rs.getInt("salario"),
                    rs.getString("senha"),
                    rs.getInt("id_locadora")
            );
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
}
