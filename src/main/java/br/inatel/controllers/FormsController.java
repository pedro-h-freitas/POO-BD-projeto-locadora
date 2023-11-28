package br.inatel.controllers;

import br.inatel.Main;
import br.inatel.models.DAO.*;
import br.inatel.models.DAO.userDAO.ClienteUserDAO;
import br.inatel.models.*;
import br.inatel.models.DAO.userDAO.FuncionarioUserDAO;
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

    /**
     * Seleciona o cliente por id
     * @return Objeto Cliente selecionado
     */
    public Cliente getCliente(int idCliente) {
        ClienteUserDAO clienteUserDAO = new ClienteUserDAO();
        return clienteUserDAO.selectById(idCliente);
    }

    /**
     * Atualiza um cliente
     * @return boolean var (true: atualizou | false: falhou)
     */
    public boolean updateCliente(Cliente cliente) {
        ClienteUserDAO clienteUserDAO = new ClienteUserDAO();
        return clienteUserDAO.update(cliente);
    }

    /**
     * Deleta um cliente pelo id
     */
    public void deleteCliente(int idCliente) {
        ClienteUserDAO clienteUserDAO = new ClienteUserDAO();

        clienteUserDAO.delete(idCliente);
        ColorPrinter.printAzul("Usuario: ");
        ColorPrinter.printVermelho(idCliente + "");
        ColorPrinter.printAzul(" deletado\n");
    }

    /**
     * Cadastra um funcionario pelo id
     */
    public void cadastroFuncionario(Funcionario funcionario) {
        FuncionarioUserDAO funcionarioUserDAO = new FuncionarioUserDAO();
        funcionarioUserDAO.insert(funcionario);
    }

    /**
     * Seleciona o funcionario por id
     * @return Objeto Funcionario selecionado
     */
    public Funcionario getFuncionario(int idFuncionario) {
        FuncionarioUserDAO funcionarioUserDAO = new FuncionarioUserDAO();
        return funcionarioUserDAO.selectById(idFuncionario);
    }

    /**
     * Atualiza um funcionario
     * @return boolean var (true: atualizou | false: falhou)
     */
    public boolean updateFuncionario(Funcionario funcionario) {
        FuncionarioUserDAO funcionarioUserDAO = new FuncionarioUserDAO();
        return funcionarioUserDAO.update(funcionario);
    }

    /**
     * Deleta um funcionario pelo id
     */
    public void deleteFuncionario(int idFuncionario) {
        FuncionarioUserDAO funcionarioUserDAO = new FuncionarioUserDAO();

        funcionarioUserDAO.delete(idFuncionario);
        ColorPrinter.printAzul("Funcionario: ");
        ColorPrinter.printVermelho(idFuncionario + "");
        ColorPrinter.printAzul(" deletado\n");
    }

    /**
     * Aumenta o salario de um funcionario pelo id
     */
    public boolean aumentaSalario(int idFuncionario, int qnt) {
        FuncionarioUserDAO funcionarioUserDAO = new FuncionarioUserDAO();
        Funcionario funcionario = funcionarioUserDAO.selectById(idFuncionario);

        int novoSalario = funcionario.getSalario() + qnt;

        funcionario.setSalario(novoSalario);

        return funcionarioUserDAO.update(funcionario);
    }

    /**
     * Transfere um funcionario para outra locadora
     * @param idFuncionario Id do funcionario a ser transferido
     * @param idLocadora Id da locadora que o funcionario sera transferido
     * @return boolean var (true: transferiu | false: falhou)
     */
    public boolean transfereFuncioario(int idFuncionario, int idLocadora) {
        FuncionarioUserDAO funcionarioUserDAO = new FuncionarioUserDAO();
        return funcionarioUserDAO.updateLocadora(idFuncionario, idLocadora);
    }

    /**
     * Seleciona um filme pelo id
     * @return Objeto FilmeDisplay selecionado
     */
    public FilmeDisplay getFilmeById(int idFilme) {
        FilmeDisplayDAO filmeDisplayDAO = new FilmeDisplayDAO();
        return filmeDisplayDAO.selectById(idFilme);
    }

    /**
     * Adiciona uma ou mais cópias de um filme em uma locadora
     * @param idInfoFilme Id das informações do filme
     * @param qnt Quantidade de cópias
     * @return int var
     * (1: primeiro cadastro do filme na locadora | 2: adicionado mais cópia de um filme | -1: falhou)
     */
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

    /**
     * Remove uma ou mais cópias de um filme em uma locadora
     * @param filme Objeto do filme a ser deletado
     * @param qnt Quantidade de cópias a excluir
     * @return int var
     * (1: removido todas as cópias | 2: pelo menos uma cópia | -1: falhou)
     */
    public int deleteFilmeLocadora(FilmeDisplay filme, int qnt) {
        FilmeDAO filmeDAO = new FilmeDAO();

        if (filme.getnCopias() - qnt == 0)
            if (filmeDAO.deleteById(filme.getId()))
                return 1;

        if (filmeDAO.removeQnt(filme.getId(), qnt))
            return 2;

        return -1;
    }

    /**
     * Adiciona as informações de um filme ao banco de dados
     * @param filme Objeto com as informações do filme a se adicionar
     * @return id das informções do filme
     */
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

    /**
     * Remove as informações de um filme do banco de dados
     * @param idInfoFilme Id das informações
     */
    public void deleteFilmeBanco(int idInfoFilme) {
        InfoFilmeDAO infoFilmeDAO = new InfoFilmeDAO();
        infoFilmeDAO.delete(idInfoFilme);
    }

    /**
     * Seleciona um aluguel pelo id do cliente
     * @param idCliente Id do aluguel do cliente selecionado
     * @return Objeto FilmeDisplay selecionado
     */
    public int getIdAluguel(int idCliente) {
        AluguelDAO aluguelDAO = new AluguelDAO();
        return aluguelDAO.selectAluguelIdByCliente(idCliente);
    }

    /**
     * Verifica se um cliente tem alugueis ativos
     * @param idCliente Id do cliente que se deseja verificar
     * @return boolean var (true: tem aluguel ativo| false: não tem aluguel ativo)
     */
    public boolean hasAluguel(int idCliente) {
        return getIdAluguel(idCliente) != -1;
    }

    /**
     * Seleciona todas as locadoras
     * @return lista de locadoras
     */
    public ArrayList<Locadora> selectAllLocadoras() {
        LocadoraDAO locadoraDAO = new LocadoraDAO();
        return locadoraDAO.selectAll();
    }

    /**
     * Seleciona todas as locadoras que conetenham um certo filme
     * @param idInfoFilme Id das informações do filme
     * @return lista de locadoras
     */
    public ArrayList<Integer> getLocadorasIdByInfoFilme(int idInfoFilme) {
        LocadoraDAO locadoraDAO = new LocadoraDAO();
        return locadoraDAO.selectIdsByInfoFilme(idInfoFilme);
    }

}
