package br.inatel.views.forms;

import br.inatel.models.Cliente;

public class FormEditarCliente extends Form {
    private final int idCliente;
    public FormEditarCliente(int idCliente) {
        super();
        this.idCliente = idCliente;
    }

    @Override
    public boolean render() {
        Cliente cliente = controller.getCliente(idCliente);

        System.out.println("--------------- EDITAR ----------------");
        String nome = inputEditCampo("Nome", cliente.getNome());
        String cpf = inputEditCampo("Cpf", cliente.getCpf());
        String senha = inputEditCampo("Senha", cliente.getSenha());
        String endereco = inputEditCampo("Endereco", cliente.getEndereco());
        String telefone = inputEditCampo("Telefone", cliente.getTelefone());
        String email = inputEditCampo("Email", cliente.getEmail());
        System.out.println("---------------------------------------");

        nome = checkCampo(nome, cliente.getNome());
        cpf = checkCampo(cpf, cliente.getCpf());
        senha = checkCampo(senha, cliente.getSenha());
        endereco = checkCampo(endereco, cliente.getEndereco());
        telefone = checkCampo(telefone, cliente.getTelefone());
        email = checkCampo(email, cliente.getEmail());

        boolean b = controller.updateCliente(new Cliente(
                idCliente,
                nome,
                cpf,
                senha,
                endereco,
                telefone,
                email
        ));

        if (b)
            printVerde("Edições concluidas\n");
        else
            printVermelho("Falha na edição\n");

        return b;
    }

    private String inputEditCampo(String nomeCampo, String valAntigo) {
        String campo;
        String label;

        if (valAntigo == null)
            label = nomeCampo + " (opcional): ";
        else
            label = nomeCampo + " (" + valAntigo + "): ";

        campo = stringInput(label);
        if (campo.isEmpty()) {
            campo = null;
        }

        return campo;
    }

    private String checkCampo(String valNovo, String valAntigo) {
        if (valNovo == null)
            return valAntigo;
        return valNovo;
    }
}
