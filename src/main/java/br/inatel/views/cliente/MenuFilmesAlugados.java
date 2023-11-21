package br.inatel.views.cliente;

import br.inatel.controllers.userController.ClienteController;
import br.inatel.models.Aluguel;
import br.inatel.views.Menu;

public class MenuFilmesAlugados extends Menu {
    @Override
    public boolean render() {
        ClienteController controller = new ClienteController();

        Aluguel aluguel = controller.getAluguel();

        System.out.println("aluguel.Id = " + aluguel.getId());
        System.out.println("aluguel.dataLocacao = " + aluguel.getDataLocacao());
        System.out.println("aluguel.dataDevolucao = " + aluguel.getDataDevolucao());
        System.out.println("aluguel.Status = " + aluguel.getStatus());
        System.out.println("aluguel.IdCliente = " + aluguel.getIdCliente());
        System.out.println("aluguel.IdLocadora = " + aluguel.getIdLocadora());
        return false;
    }
}
