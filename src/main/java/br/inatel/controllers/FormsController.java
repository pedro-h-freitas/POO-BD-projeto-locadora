package br.inatel.controllers;

import br.inatel.Main;
import br.inatel.controllers.DAO.FilmeDAO;
import br.inatel.controllers.DAO.FilmeDisplayDAO;
import br.inatel.controllers.DAO.userDAO.ClienteUserDAO;
import br.inatel.models.Cliente;
import br.inatel.models.Filme;
import br.inatel.models.FilmeDisplay;

import java.util.ArrayList;

/**
 * Classe para manipular as ações na tela de Cadastro
 */
public class FormsController {
    /**
     * Realiza o cadastro de um cliente
     * @param cliente cliente a ser inserido
     * @return boolean var (true: cadastrou | false: falhou)
     */
    public int cadastroCliente(Cliente cliente) {
        ClienteUserDAO clienteUserDAO = new ClienteUserDAO();
        return clienteUserDAO.insert(cliente);
    }

    public boolean updateCliente(Cliente cliente) {
        ClienteUserDAO clienteUserDAO = new ClienteUserDAO();
        return clienteUserDAO.update(cliente);
    }

    public Cliente getCliente(int idCliente) {
        ClienteUserDAO clienteUserDAO = new ClienteUserDAO();
        return clienteUserDAO.selectById(idCliente);
    }

    public FilmeDisplay getFilmeById(int idFilme) {
        FilmeDisplayDAO filmeDisplayDAO = new FilmeDisplayDAO();
        return filmeDisplayDAO.selectById(idFilme);
    }

    public int adicionaFilmeLocadora(int idInfoFilme, int qnt) {
        FilmeDAO filmeDAO = new FilmeDAO();

        int idLocadora = Main.context.getLocadoraId();
        String idFilmeAux = "" + idLocadora + idInfoFilme;
        int idFilme = Integer.parseInt(idFilmeAux);

        if (getFilmeById(idFilme) == null)
            if (filmeDAO.insert(new Filme(qnt, idLocadora, idInfoFilme)) != -1)
                return 1;
        if (filmeDAO.addQnt(idFilme, qnt))
            return 2;

        return -1;
    }

    public int deleteFilmeLocadora(FilmeDisplay filme, int qnt) {
        FilmeDAO filmeDAO = new FilmeDAO();

        if (filme.getnCopias() - qnt == 0)
            if (filmeDAO.deleteById(filme.getId()))
                return 1;

        if (filmeDAO.removeQnt(filme.getId(), qnt))
            return 2;

        return -1;
    }

}
