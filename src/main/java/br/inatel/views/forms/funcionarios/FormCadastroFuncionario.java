package br.inatel.views.forms.funcionarios;

import br.inatel.Main;
import br.inatel.models.Funcionario;
import br.inatel.views.forms.Form;

public class FormCadastroFuncionario extends Form {
    @Override
    public boolean render() {
        // TODO fazer validação dos dados
        String nome;
        String telefone;
        int salario;
        String senha;
        int idLocadora;

        System.out.println("-------------- CADASTRO ---------------");

        nome = inputCampoObrigatorio("Nome");
        telefone = inputCampoObrigatorio("Telefone");
        salario = Integer.parseInt(inputCampoObrigatorio("Salario"));
        senha = inputCampoObrigatorio("Senha");
        idLocadora = Main.context.getLocadoraId();

        controller.cadastroFuncionario(new Funcionario(
                nome,
                telefone,
                salario,
                senha,
                idLocadora
        ));

        printVerde("Funcionario cadastrado com sucesso\n");

        return true;
    }
}
