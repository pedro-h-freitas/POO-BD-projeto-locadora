package br.inatel.controllers.userController;

import br.inatel.Main;
import br.inatel.models.DAO.AluguelDAO;
import br.inatel.models.DAO.FilmeAlugadoDAO;
import br.inatel.models.DAO.FilmeDisplayDAO;
import br.inatel.models.DAO.LocadoraDAO;
import br.inatel.models.DAO.userDAO.ClienteUserDAO;
import br.inatel.models.Aluguel;
import br.inatel.models.FilmeAlugado;
import br.inatel.models.FilmeDisplay;
import br.inatel.models.Locadora;

import java.util.ArrayList;

/**
 * Controler para clientes
 */
public class ClienteController {
    /**
     * Seleciona todas as locadoras
     * @return lista de locadoras
     */
    public ArrayList<Locadora> selectAllLocadoras() {
        LocadoraDAO locadoraDAO = new LocadoraDAO();
        return locadoraDAO.selectAll();
    }

    /**
     * Método para selecionar o nome da locadora atual da sessão
     * @return nome da locadora da sessão
     */
    public String getNomeLocadora() {
        LocadoraDAO locadoraDAO = new LocadoraDAO();
        return locadoraDAO.selectNome(Main.context.getLocadoraId());
    }

    /**
     * Método para selecionar o nome do cliente da atual da sessão
     * @return nome do cliente da sessão
     */
    public String getNomeCliente() {
        ClienteUserDAO clienteUserDAO = new ClienteUserDAO();
        return clienteUserDAO.selectNome(Main.context.getUserId());
    }

    /**
     * Seleciona todos os filmes da locadora da sessão
     * @return lista dos filmes da locadora da sessão
     */
    public ArrayList<FilmeDisplay> getFilmesByLocadora() {
        FilmeDisplayDAO filmeDAO = new FilmeDisplayDAO();
        return filmeDAO.selectByLocadora(Main.context.getLocadoraId());
    }

    /**
     * Seleciona todos os filmes alugados em um aluguel
     * @param idAluguel id do aluguel q desejar selecionar os filmes
     * @return lista de filmes do aluguel
     */
    public ArrayList<FilmeDisplay> getFilmesByAluguel(int idAluguel) {
        FilmeDisplayDAO filmeDAO = new FilmeDisplayDAO();
        return filmeDAO.selectByAluguel(idAluguel);
    }

    /**
     * Seleciona o id aluguel ativo do cliente da sessão
     * @return id do do aluguel desejado
     */
    public int getIdAluguel() {
        AluguelDAO aluguelDAO = new AluguelDAO();
        int idCliente = Main.context.getUserId();

        return aluguelDAO.selectAluguelIdByCliente(idCliente);
    }

    /**
     * Verifica se o cliente da sessão tem alugueis ativos
     * @return boolean var (true: tem aluguel ativo | false: não tem aluguel ativo)
     */
    public boolean hasAluguel() {
        return getIdAluguel() != -1;
    }

    /**
     * Deleta o usuário atual da sessão
     * @return id do cliente deletado
     */
    public int deleteUser() {
        ClienteUserDAO clienteUserDAO = new ClienteUserDAO();
        int idCliente = Main.context.getUserId();

        clienteUserDAO.delete(idCliente);

        Main.context.setUserId(-1);
        Main.context.setLocadoraId(-1);

        return idCliente;
    }

    /**
     * Realiza o aluguel dos filmes selecionados pelo cliente da sessão
     * @param filmes filmes escolhidos
     */
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

    /**
     * Realiza a devolução do aluguel do cliente da sessão
     * @param idAluguel aluguel a ser devolvido
     */
    public void devolverFilmes(int idAluguel) {
        AluguelDAO aluguelDAO = new AluguelDAO();
        aluguelDAO.devolver(idAluguel);
    }

}
