public class MainCircular {
    public static void main(String[] args) {
        ListaCircularDuplamenteEncadeada<String> listaCircular = new ListaCircularDuplamenteEncadeada<>();

        listaCircular.adicionar("Introdução");
        listaCircular.adicionar("Algoritmos");
        listaCircular.adicionar("Estruturas de Dados");
        listaCircular.adicionar("POO");

        System.out.println("Navegação circular a partir do atual:");
        listaCircular.navegarCircular(5); // Avança 5 posições (com repetição)

        System.out.println("\nNavegação circular reversa:");
        listaCircular.navegarCircular(-3); // Retrocede 3 posições
    }
}