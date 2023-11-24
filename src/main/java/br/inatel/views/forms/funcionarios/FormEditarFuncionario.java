package br.inatel.views.forms.funcionarios;

import br.inatel.views.forms.Form;

public class FormEditarFuncionario extends Form {
    private final int idFuncionario;

    public FormEditarFuncionario(int idFuncionario) {
        super();
        this.idFuncionario = idFuncionario;
    }

    @Override
    public boolean render() {
        return false;
    }
}
