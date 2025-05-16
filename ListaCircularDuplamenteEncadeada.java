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

    // OPERAÇÃO adicionar() Adiciona um novo elemento
    public boolean adicionar(T modulo) {
        No<T> aux = new No<>(modulo); // cria novo nó
        if (isEmpty()) {// Se a lista estiver vazia, nó aponta para si mesmo
            head = tail = aux; //seta head  e tail como auxiliar;
            aux.setProximo(aux); //seta o proximo do aux para aux
            aux.setAnterior(aux);// seta o anterior do aux para aux
        } else {
            // Encadeia o novo nó no final da lista
            aux.setAnterior(tail); // seta o anterior do aux para tail;
            aux.setProximo(head); // set o proximo do aux para head
            tail.setProximo(aux); // seta o próximo do tail para aux
            head.setAnterior(aux); // seta o anterior do head para aux
            tail = aux; // seta o tail para aux
        }

        size++; // incrementa o tamanho da lista
        return true;

    }

    //OPERAÇÃO navegarCircular() navega/imprime a lista circular;
    public void navegarCircular(int passos) {
        if (isEmpty()){
            throw new IllegalStateException("Não é possível navegar na lista, pois ela está vazia");
        }
        No<T> atual = head; //seta atual como head (começa no head)
        for (int i = 0; i < passos; i++) {
        System.out.println("Passo " + (i + 1) + ": " + atual.getModulo());
        atual = atual.getProximo();
    }
        System.out.println(); //fim quando o nó atual for null.
    }
}
