package br.inatel.models;

/**
 * Model da tabela "cliente".
 */
public class Cliente {
    private int id;             // id do cliente
    private String nome;        // nome do cliente
    private String cpf;         // cpf do cliente
    private String senha;       // senha do cliente para acessar o sistema
    private String endereco;    // endereco do cliente (opcional)
    private String telefone;    // telefone do cliente (opcional)
    private String email;       // email do cliente (opcional)
}
