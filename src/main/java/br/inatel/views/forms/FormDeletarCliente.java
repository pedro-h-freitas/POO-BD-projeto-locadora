package br.inatel.views.forms;

public class FormDeletarCliente extends Form {
    private final int idCliente;
    public FormDeletarCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public boolean render() {
        return false;
    }
}
