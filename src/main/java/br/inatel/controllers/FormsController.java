package br.inatel.controllers;

import br.inatel.Main;
import br.inatel.models.DAO.*;
import br.inatel.models.DAO.userDAO.ClienteUserDAO;
import br.inatel.models.*;
import br.inatel.views.utils.ColorPrinter;

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

    public int getIdAluguel(int idCliente) {
        AluguelDAO aluguelDAO = new AluguelDAO();
        return aluguelDAO.selectAluguelIdByCliente(idCliente);
    }

    public boolean hasAluguel(int idCliente) {
        return getIdAluguel(idCliente) != -1;
    }

    public void deleteCliente(int idCliente) {
        ClienteUserDAO clienteUserDAO = new ClienteUserDAO();

        clienteUserDAO.delete(idCliente);
        ColorPrinter.printAzul("Usuario: ");
        ColorPrinter.printVermelho(idCliente + "");
        ColorPrinter.printAzul(" deletado\n");

        Main.context.setUserId(-1);
        Main.context.setUserType(null);
        Main.context.setLocadoraId(-1);
    }

    public int adicionaFilmeBanco(FilmeDisplay filme) {
        InfoFilmeDAO infoFilmeDAO = new InfoFilmeDAO();
        GenerosDAO generosDAO = new GenerosDAO();

        int idInfoFilme = infoFilmeDAO.insert(new InfoFilme(
                filme.getNome(),
                filme.getAno()
        ));

        String[] generos = filme.getGeneros().split(",");
        for (String genero :
                generos) {
            generosDAO.insert(new Generos(
                    idInfoFilme,
                    genero
            ));
        }

        return idInfoFilme;
    }
}
