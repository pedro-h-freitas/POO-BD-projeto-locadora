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
