public class ListaCircularDuplamenteEncadeada<T> {
    private No<T> head;
    private No<T> tail;
    private int size;

    public ListaCircularDuplamenteEncadeada() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    // Retorna a quantidade de nós da lista
    public int size() {
        return size;
    }

    // Retorna o nó do início da lista ou lança exceção se lista vazia
    public No<T> getHead() {
        if (isEmpty()) {
            throw new IllegalStateException("A lista está vazia, não existe head.");
        }
        return head;
    }

    // Retorna o nó do final da lista ou lança exceção se lista vazia
    public No<T> getTail() {
        if (isEmpty()) {
            throw new IllegalStateException("A lista está vazia, não existe tail.");
        }
        return tail;
    }

    // Verifica se a lista está vazia
    public boolean isEmpty() {
        return head == null;
    }

    // Método para adicionar elemento — ainda não implementado, lança exceção
    public boolean adicionar(T modulo) {
        throw new UnsupportedOperationException("Método adicionar ainda não implementado.");
    }

    // Método para navegar circularmente — ainda não implementado, lança exceção
    public void navegarCircular(int passos) {
        throw new UnsupportedOperationException("Método navegarCircular ainda não implementado.");
    }
}
