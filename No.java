public class Node <T>{
    T modulo; //valor genérico
    private Node proximo; // ponteiro apontando para o anterior
    private Node anterior; //ponteiro apontado para o próximo

    public Node (T modulo){
        this.modulo = modulo;
        this.proximo = null;
        this.anterior = null;
    }

     public T getModulo() {
        return modulo;
    }
}