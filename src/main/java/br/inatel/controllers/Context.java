package br.inatel.controllers;

/**
 * Classe para criar o contexto da sessão
 */
public class Context extends Controller {
    // Constantes
    public static final String CLIENTE = "CLIENTE";
    public static final String FUNCIONARIO = "FUNCIONARIO";
    public static final String GERENTE = "GERENTE";

    private int userId;
    private String userType; // (CLIENTE, FUNCIONARIO, GERENTE)
    private int locadoraId;

    /**
     * Getter do id do usuario da sessao
     * @return id do usuario da sessao
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Setter do id do usuario da sessao
     * @param userId id do usuario da sessao
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Getter do tipo de usuario da sessao
     * @return tipo de usuario da sessao (Cliente, Funcionario, Gerente, Dono)
     */
    public String getUserType() {
        return userType;
    }

    /**
     * Setter do tipo de usuario da sessao
     * @param userType tipo de usuario da sessao (Cliente, Funcionario, Gerente, Dono)
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * Getter do id da locadora da sessao
     * @return id da locadora da sessao
     */
    public int getLocadoraId() {
        return locadoraId;
    }

    /**
     * Setter do id da locadora da sessao
     * @param locadoraId id da locadora da sessao
     */
    public void setLocadoraId(int locadoraId) {
        this.locadoraId = locadoraId;
    }
}
