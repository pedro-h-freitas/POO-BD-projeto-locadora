package br.inatel.views.forms.funcionarios;

import br.inatel.models.Funcionario;
import br.inatel.views.forms.Form;

/**
 * Form de Edição de Funcionario
 */
public class FormEditarFuncionario extends Form {
    private final int idFuncionario;

    public FormEditarFuncionario(int idFuncionario) {
        super();
        this.idFuncionario = idFuncionario;
    }

    /**
     * Menu Form de Edição de Funcionario
     */
    @Override
    public boolean render() {
        Funcionario funcionario = controller.getFuncionario(idFuncionario);

        System.out.println("--------------- EDITAR ----------------");
        String nome = inputEditCampo("Nome", funcionario.getNome());
        String telefone = inputEditCampo("telefone", funcionario.getTelefone());
        String senha = inputEditCampo("Senha", funcionario.getSenha());
        System.out.println("---------------------------------------");

        nome = checkCampo(nome, funcionario.getNome());
        telefone = checkCampo(telefone, funcionario.getTelefone());
        senha = checkCampo(senha, funcionario.getSenha());

        boolean b = controller.updateFuncionario(new Funcionario(
                idFuncionario,
                nome,
                telefone,
                funcionario.getSalario(),
                senha,
                funcionario.getIdLocadora()
        ));

        if (b)
            printVerde("Edições concluidas\n");
        else
            printVermelho("Falha na edição\n");

        return b;
    }

    /**
     * Função auxiliar para editar campos
     * @param nomeCampo Nome do campo para exibir na tela
     * @param valAntigo valor antigo do campo
     * @return Novo valor inputado
     */
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

    /**
     * Função Auxiliar para checkar se o campo foi atualizado ou nao
     * @param valNovo Valor novo
     * @param valAntigo Valor antigo
     * @return valAntigo (se valNovo é vazio) | valNovo
     */
    private String checkCampo(String valNovo, String valAntigo) {
        if (valNovo == null)
            return valAntigo;
        return valNovo;
    }
}
