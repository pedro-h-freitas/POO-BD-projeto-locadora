package br.inatel.views.forms;

import br.inatel.models.Cliente;

/**
 * Tela de cadastro, cadastra cliente, funcionario ou gerente
 */
public class FormCadastroCliente extends Form {

    /**
     * Exibe a tela de Cadastro
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
