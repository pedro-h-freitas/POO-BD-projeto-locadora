package br.inatel.controllers.userController;

import br.inatel.Main;
import br.inatel.controllers.DAO.LocadoraDAO;

public class FuncionarioController {

    public String getNomeLocadora() {
        LocadoraDAO locadoraDAO = new LocadoraDAO();
        return locadoraDAO.selectNome(Main.context.getLocadoraId());
    }

}
