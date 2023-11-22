package br.inatel.views.forms;

import br.inatel.controllers.FormsController;
import br.inatel.models.Cliente;

public class FormEditarCliente extends Form {
    private final int idCliente;
    public FormEditarCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public boolean render() {
        return false;
    }
}
