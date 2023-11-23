package br.inatel.controllers.userController;

import br.inatel.Main;
import br.inatel.controllers.DAO.AluguelDAO;
import br.inatel.controllers.DAO.FilmeDAO;
import br.inatel.controllers.DAO.FilmeDisplayDAO;
import br.inatel.controllers.DAO.LocadoraDAO;
import br.inatel.controllers.DAO.userDAO.ClienteUserDAO;
import br.inatel.controllers.DAO.userDAO.FuncionarioUserDAO;
import br.inatel.models.Cliente;
import br.inatel.models.Filme;
import br.inatel.models.FilmeDisplay;
import br.inatel.views.utils.ColorPrinter;

import java.util.ArrayList;

public class FuncionarioController {

    public String getNomeLocadora() {
        LocadoraDAO locadoraDAO = new LocadoraDAO();
        return locadoraDAO.selectNome(Main.context.getLocadoraId());
    }

    public String getNomeFuncionario() {
        FuncionarioUserDAO funcionarioUserDAO = new FuncionarioUserDAO();
        return funcionarioUserDAO.selectNome(Main.context.getUserId());
    }

    public ArrayList<Cliente> getAllClientes() {
        ClienteUserDAO clienteUserDAO = new ClienteUserDAO();
        return clienteUserDAO.selectAll();
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

    public int getIdAluguel(int idCliente) {
        AluguelDAO aluguelDAO = new AluguelDAO();

        return aluguelDAO.selectAluguelIdByCliente(idCliente);
    }

    public boolean hasAluguel(int idCliente) {
        return getIdAluguel(idCliente) != -1;
    }

    public ArrayList<FilmeDisplay> getFilmesLocadora() {
        FilmeDisplayDAO filmeDisplayDAO = new FilmeDisplayDAO();
        int locadoraId = Main.context.getLocadoraId();

        return filmeDisplayDAO.selectByLocadora(locadoraId);
    }

    public FilmeDisplay getFilmeById(int idFilme) {
        FilmeDisplayDAO filmeDisplayDAO = new FilmeDisplayDAO();
        return filmeDisplayDAO.selectById(idFilme);
    }

    public ArrayList<FilmeDisplay> getFilmesInfos() {
        FilmeDisplayDAO filmeDisplayDAO = new FilmeDisplayDAO();

        return filmeDisplayDAO.selectInfos();
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
