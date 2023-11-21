package br.inatel.controllers.userController;

import br.inatel.Main;
import br.inatel.controllers.DAO.AluguelDAO;
import br.inatel.controllers.DAO.FilmeAlugadoDAO;
import br.inatel.controllers.DAO.FilmeDAO;
import br.inatel.controllers.DAO.LocadoraDAO;
import br.inatel.controllers.DAO.userDAO.ClienteUserDAO;
import br.inatel.models.Aluguel;
import br.inatel.models.FilmeAlugado;
import br.inatel.models.FilmeDisplay;
import br.inatel.models.Locadora;
import br.inatel.views.utils.ColorPrinter;

import java.util.ArrayList;

public class ClienteController {
    public ArrayList<Locadora> selectAllLocadoras() {
        LocadoraDAO locadoraDAO = new LocadoraDAO();
        return locadoraDAO.selectAll();
    }

    public String getNomeLocadora() {
        LocadoraDAO locadoraDAO = new LocadoraDAO();
        return locadoraDAO.selectNome(Main.context.getLocadoraId());
    }

    public ArrayList<FilmeDisplay> getFilmes() {
        FilmeDAO filmeDAO = new FilmeDAO();
        return filmeDAO.selectFilmeDisplayByIdLocadora(Main.context.getLocadoraId());
    }

    public boolean hasAluguel() {
        AluguelDAO aluguelDAO = new AluguelDAO();
        return aluguelDAO.hasAluguel(Main.context.getUserId());
    }

    public void deleteUser() {
        ClienteUserDAO clienteUserDAO = new ClienteUserDAO();
        int userId = Main.context.getUserId();

        clienteUserDAO.delete(userId);
        ColorPrinter.printAzul("Usuario: " + userId + " deletado");

        Main.context.setUserId(-1);
        Main.context.setUserType(null);
        Main.context.setLocadoraId(-1);
    }

    public void alugar(ArrayList<FilmeDisplay> filmes) {
        AluguelDAO aluguelDAO = new AluguelDAO();
        FilmeAlugadoDAO filmeAlugadoDAO = new FilmeAlugadoDAO();

        Aluguel aluguel = new Aluguel(Main.context.getUserId(), Main.context.getLocadoraId());
        int aluguelId = aluguelDAO.insert(aluguel);

        for (FilmeDisplay filme :
                filmes) {
            FilmeAlugado filmeAlugado = new FilmeAlugado(aluguelId, filme.getId());
            filmeAlugadoDAO.insert(filmeAlugado);
        }
    }

}
