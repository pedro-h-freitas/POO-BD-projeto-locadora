package br.inatel.views.forms.funcionarios;

import br.inatel.Main;
import br.inatel.models.Funcionario;
import br.inatel.models.Locadora;
import br.inatel.views.forms.Form;

import java.util.ArrayList;
import java.util.spi.AbstractResourceBundleProvider;

public class FormTransferirFuncionario extends Form {
    private final int idFuncionario;

    public FormTransferirFuncionario(int idFuncionario) {
        super();
        this.idFuncionario = idFuncionario;
    }

    @Override
    public boolean render() {
        ArrayList<Locadora> locadoras = controller.selectAllLocadoras();
        ArrayList<Integer> idList = new ArrayList<>();

        System.out.println("---------------------------------------");
        printAzul("Transferir para:\n");
        System.out.print("---------------------------------------");
        for (Locadora l :
                locadoras) {
            if (l.getId() == Main.context.getLocadoraId()) break;
            idList.add(l.getId());

            System.out.println();
            printVerde(l.getId()+"");
            System.out.print(" - ");
            printAmarelo(l.getNome() + "\n");
            printCiano("Cidade: " + l.getCidade());
            System.out.println();
        }
        System.out.println("---------------------------------------");

        int idLocadora = inputIdLocadora(idList);

        if (idLocadora == 0) return false;

        return controller.transfereFuncioario(idFuncionario, idLocadora);
    }

    /**
     * Método auxiliar para realizar o input do ID da locadora
     * @param idList Lista de IDs válidos
     * @return valor inputado
     */
    private int inputIdLocadora(ArrayList<Integer> idList) {
        int id;

        id = intInput("Id: ");
        while (!idList.contains(id)) {
            printVermelho("ID INVÁLIDO\n");
            id = intInput("Id: ");
        }

        return id;
    }

}
