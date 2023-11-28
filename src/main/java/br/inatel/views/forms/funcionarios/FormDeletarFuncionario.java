package br.inatel.views.forms.funcionarios;

import br.inatel.views.forms.Form;

/**
 * Form de Deletar de Funcionario
 */
public class FormDeletarFuncionario extends Form {
    private final int idFuncionario;

    public FormDeletarFuncionario(int idFuncionario) {
        super();
        this.idFuncionario = idFuncionario;
    }

    /**
     * Exibe Form de Deletar de Funcionario
     */
    @Override
    public boolean render() {
        printAzul("Você tem crtz??");
        printVerde(" (S/N) ");
        String s;
        do {
            s = stringInput("").toLowerCase();
        } while (!(s.equals("s") || s.equals("n")));

        if (s.equals("s")) {
            controller.deleteFuncionario(idFuncionario);
            return true;
        }

        return false;
    }
}
