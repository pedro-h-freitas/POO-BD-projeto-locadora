package br.inatel.views.forms.funcionarios;

import br.inatel.views.forms.Form;

public class FormAumentoFunionario extends Form {
    private final int idFuncionario;

    public FormAumentoFunionario(int idFuncionario) {
        super();
        this.idFuncionario = idFuncionario;
    }

    @Override
    public boolean render() {
        return false;
    }
}
