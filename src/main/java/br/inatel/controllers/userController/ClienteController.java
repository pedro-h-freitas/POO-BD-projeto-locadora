package br.inatel.controllers.userController;

import br.inatel.Main;
import br.inatel.controllers.DAO.AluguelDAO;
import br.inatel.controllers.DAO.FilmeAlugadoDAO;
import br.inatel.controllers.DAO.FilmeDAO;
import br.inatel.controllers.DAO.LocadoraDAO;
import br.inatel.models.Aluguel;
import br.inatel.models.FilmeAlugado;
import br.inatel.models.FilmeAlugar;
import br.inatel.models.Locadora;

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

    public ArrayList<FilmeAlugar> getFilmes() {
        FilmeDAO filmeDAO = new FilmeDAO();
        return filmeDAO.selectFilmeAlugar(Main.context.getLocadoraId());
    }

    public boolean hasAluguel() {
        AluguelDAO aluguelDAO = new AluguelDAO();
        return aluguelDAO.hasAluguel(Main.context.getUserId());
    }

    public void alugar(ArrayList<FilmeAlugar> filmes) {
        AluguelDAO aluguelDAO = new AluguelDAO();
        FilmeAlugadoDAO filmeAlugadoDAO = new FilmeAlugadoDAO();

        Aluguel aluguel = new Aluguel(Main.context.getUserId(), Main.context.getLocadoraId());
        int aluguelId = aluguelDAO.insert(aluguel);

        for (FilmeAlugar filme :
                filmes) {
            FilmeAlugado filmeAlugado = new FilmeAlugado(aluguelId, filme.getId());
            filmeAlugadoDAO.insert(filmeAlugado);
        }
    }

}
