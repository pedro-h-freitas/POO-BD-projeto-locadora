package br.inatel.controllers;

import br.inatel.Main;
import br.inatel.controllers.DAO.LocadoraDAO;
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

}
