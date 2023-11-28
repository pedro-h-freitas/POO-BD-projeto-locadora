package br.inatel.views.forms.clientes;

import br.inatel.models.Cliente;
import br.inatel.views.forms.Form;

/**
 * Form de Cadastro de Cliente
 */
public class FormCadastroCliente extends Form {

    /**
     * Exibe Form de Cadastro de Cliente
     */
    @Override
    public boolean render(){
        // TODO fazer validação dos dados
        String nome, cpf, senha, endereco, telefone, email;

        System.out.println("-------------- CADASTRO ---------------");

        nome = inputCampoObrigatorio("Nome");
        cpf = inputCampoObrigatorio("Cpf");
        senha = inputCampoObrigatorio("Senha");

        while (true) {
            endereco = inputCampoOpcional("Endereco");
            telefone = inputCampoOpcional("Telefone");
            email = inputCampoOpcional("Email");

            if (!(endereco == null && telefone == null && email == null))
                break;

            printAmarelo("Insira pelo menos uma forma de contato\n");
        }

        int idClienteNovo = controller.cadastroCliente(new Cliente(
                nome,
                cpf,
                senha,
                endereco,
                telefone,
                email
        ));

        if (idClienteNovo == -1) {
            printVermelho("Cadastro falhou\n");
            return false;
        }

        printVerde("Usuario Cadastrado com sucesso\nID:");
        printAzul(idClienteNovo + "\n");

        return true;
    }

}
