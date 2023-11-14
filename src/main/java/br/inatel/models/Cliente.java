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

    /**
     * Construtor da Classe Cliente para retorno de uma query (SELECT)
     * @param id id do cliente
     * @param nome nome do cliente
     * @param cpf cpf do cliente
     * @param senha senha do cliente para acessar o sistema
     * @param endereco endereco do cliente
     * @param telefone telefone do cliente
     * @param email email do cliente
     */
    public Cliente(int id, String nome, String cpf, String senha, String endereco, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    /**
     * Construtor da Classe Cliente para inserção de um novo (INSERT)
     * @param nome nome do cliente
     * @param cpf cpf do cliente
     * @param senha senha do cliente para acessar o sistema
     * @param endereco endereco do cliente
     * @param telefone telefone do cliente
     * @param email email do cliente
     */
    public Cliente(String nome, String cpf, String senha, String endereco, String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
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
     * Getter do cpf
     * @return cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Getter do senha
     * @return senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Getter do endereco
     * @return endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Getter do telefone
     * @return telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Getter do email
     * @return email
     */
    public String getEmail() {
        return email;
    }
}
