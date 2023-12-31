package br.inatel.views;

import br.inatel.Main;
import br.inatel.views.utils.ColorPrinter;

/**
 * Classe abstrata para toda Tela
 */
public abstract class Tela extends ColorPrinter {

    /**
     * Método abstrado para exibir uma Tela
     * @return (true: renderizar novamente | false: encerrar execução)
     */
    public abstract boolean render();

    /**
     * Mostra um Input de string
     * @param label texto a ser exibido
     */
    protected String stringInput(String label) {
        printAzul(label);
        return Main.sc.nextLine();
    }

    /**
     * Mostra um Input de int com a label padrão: "Opção: "
     * @return int inputado
     */
    protected Integer intInput() {
        return intInput("Opção: ");
    }

    /**
     * Mostra um Input de int
     * @param label texto a ser exibido
     * @return int inputado
     */
    protected Integer intInput(String label) {
        while (true) {
            try {
                return Integer.parseInt(stringInput(label));
            } catch (Exception e) {
                printVermelho("Insira um número\n");
            }
        }
    }

    /**
     * Mostra um Input de int
     * @param label texto a ser exibido
     * @return float inputado
     */
    protected float floatInput(String label) {
        while (true) {
            try {
                return Float.parseFloat(stringInput(label).replace(",", "."));
            } catch (Exception e) {
                printVermelho("Insira um número\n");
            }
        }
    }
}
