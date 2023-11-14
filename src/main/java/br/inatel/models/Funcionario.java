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
    private int id_locadora;    // id da locadora que o funcionario trabalha
}
