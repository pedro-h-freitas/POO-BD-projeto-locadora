package br.inatel.controllers;

/**
 * Classe para criar o contexto da sessão
 */
public class Context {
    private int userId;
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
