package br.inatel.views;

import br.inatel.controllers.CadastroController;

/**
 * Tela de cadastro, cadastra cliente, funcionario ou gerente
 */
public class TelaCadastro extends Tela{
    /**
     * Exibe a tela de Cadastro
     */
    @Override
    public boolean render(){
        // TODO fazer validação dos dados
        String nome, cpf, senha, endereco, telefone, email;
        CadastroController controller = new CadastroController();

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

        if (controller.cadastroCliente(nome, cpf, senha, endereco, telefone, email)) {
            TelaCliente telaCliente = new TelaCliente();
            telaCliente.render();
        } else {
            printVermelho("Cadastro falhou\n");
            return false;
        }

        return true;
    }

    /**
     * Método auxiliar para realizar o input de um campo obrigatório
     * @param nomeCampo Label para o input
     * @return valor inputado
     */
    private String inputCampoObrigatorio(String nomeCampo) {
        String campo;

        campo = stringInput(nomeCampo + ": ");
        while (campo.isEmpty()) {
            printVermelho("CAMPO OBRIGATÓRIO\n");

            campo = stringInput(nomeCampo + ": ");
        }

        return campo;
    }

    /**
     * Método auxiliar para realizar o input de um campo obrigatório
     * @param nomeCampo Label para o input
     * @return valor inputado
     */
    private String inputCampoOpcional(String nomeCampo) {
        String campo;

        campo = stringInput(nomeCampo + " (opcional): ");
        if (campo.isEmpty()) {
            campo = null;
        }

        return campo;
    }
}
