import No;
import Lista;

public class Main{
    public static void main(String[] args){
        ListaDuplamenteEncadeada<String> lista = new ListaDuplamenteEncadeada<>();

        // Adicionando módulos
        lista.adicionarFim("Introdução");
        lista.adicionarFim("Algoritmos");
        lista.adicionarFim("Estruturas de Dados");
        lista.adicionarInicio("Pré-requisitos");

        System.out.println("Lista (do início ao fim):");
        lista.exibirInicioFim();

        System.out.println("\nLista (do fim ao início):");
        lista.exibirFimInicio();

        // Remoção de elementos
        lista.removerInicio(); // Remove "Pré-requisitos"
        lista.removerFim();    // Remove "Estruturas de Dados"

        System.out.println("\nApós remoções:");
        lista.exibirInicioFim();
    }
}