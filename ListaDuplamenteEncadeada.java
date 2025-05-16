public class ListaDuplamenteEncadeada<T>{
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public ListaDuplamenteEncadeada(){
        this.head = null;
        this.tail = null;
        size = 0;
    }

    // OPERAÇÃO: size() Retorna a quantidade de nós da lista.
    public int size() {
        return size;
    }
    // OPERAÇÃO: getHead() Retorna uma referência para o nó do início da lista, caso a lista estiver vazia retorna null.
	public Node<T> getHead() {
		return head;
	}

    // OPERAÇÃO: getTail() Retorna uma referência para o nó do final da lista, caso a lista estiver vazia retorna null.
	public Node<T> getTail() {
		return tail;
	}
    // OPERAÇÃO: isEmpty() Retorna uma referência para o nó do final da lista, caso a lista estiver vazia retorna null.
	public boolean isEmpty() {
    return head == null;
    }
}