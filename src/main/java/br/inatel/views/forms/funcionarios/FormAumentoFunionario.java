package br.inatel.views.forms.funcionarios;

import br.inatel.models.Funcionario;
import br.inatel.views.forms.Form;

/**
 * Form de Aumento de salario de Funcionario
 */
public class FormAumentoFunionario extends Form {
    private final int idFuncionario;

    public FormAumentoFunionario(int idFuncionario) {
        super();
        this.idFuncionario = idFuncionario;
    }

    /**
     * Exibe Form de Aumento de salario de Funcionario
     */
    @Override
    public boolean render() {
        Funcionario funcionario = controller.getFuncionario(idFuncionario);

        System.out.println("--------------- AUMENTO ---------------");
        printVerde(funcionario.getId() + "");
        System.out.print(" - ");
        printAmarelo(funcionario.getNome() + "\n");
        printCiano("Salario: R$" + (funcionario.getSalario() / 100.00f) + "\n");
        System.out.println("---------------------------------------");
        printVerde("0");
        System.out.print(" - ");
        printAmarelo("Cancelar\n");
        System.out.println("---------------------------------------");

        float qnt = floatInput("Quanto será o aumento? R$ ");

        if (qnt == 0) return false;

        if (!controller.aumentaSalario(idFuncionario, (int) (qnt*100))) {
            printVermelho("Falha ao dar aumento");
            return false;
        }

        printVerde("Slario de: ");
        printVermelho(idFuncionario + "");
        printVerde(" aumentado em: R$ ");
        printVermelho(qnt + "");
        printVerde(", com sucesso\n");

        return true;
    }
}
