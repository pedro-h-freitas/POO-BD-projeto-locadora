package br.inatel.views.forms.clientes;

import br.inatel.views.forms.Form;

public class FormDeletarCliente extends Form {
    private final int idCliente;

    public FormDeletarCliente(int idCliente) {
        super();
        this.idCliente = idCliente;
    }

    @Override
    public boolean render() {
        if (controller.hasAluguel(idCliente)) {
            printVermelho("Há aluguéis pendentes\n");
            return false;
        }

        printAzul("Você tem crtz??");
        printVerde(" (S/N) ");
        String s;
        do {
            s = stringInput("").toLowerCase();
        } while (!(s.equals("s") || s.equals("n")));

        if (s.equals("s")) {
            controller.deleteCliente(idCliente);
            return true;
        }

        return false;
    }

}
