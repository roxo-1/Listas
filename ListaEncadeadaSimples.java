public class ListaEncadeadaSimples<T> {
    private No<T> head;
    private int size;

    public ListaEncadeadaSimples() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }
    public No<T> getHead(){
        return head;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean adicionarInicio(T modulo) {
        No<T> novo = new No<>(modulo);
        if(isEmpty() == true){
            head = novo;
        }
        novo.setProximo(head);
        head = novo;
        size++;
        return true;
    }

    public boolean inserirMeio(T elemento, int posicao) {
        if (posicao < 0 || posicao > size) {
            throw new IndexOutOfBoundsException("Posição inválida.");
        }

        if (posicao == 0) {
            return adicionarInicio(elemento);
        } else if (posicao == size) {
            return adicionarFim(elemento);
        } else {
            No<T> novo = new No<>(elemento);
            No<T> atual = head;

            for (int i = 0; i < posicao - 1; i++) {
                atual = atual.getProximo();
            }

            novo.setProximo(atual.getProximo());
            atual.setProximo(novo);
            size++;
            return true;
        }
    }


    public boolean adicionarFim(T modulo) {
        No<T> novo = new No<>(modulo);
        if (isEmpty()) {
            head = novo;
        } else {
            No<T> atual = head;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(novo);
        }
        size++;
        return true;
    }

    public boolean removerMeio(int posicao) {
        if (isEmpty()) return false;
        if (posicao < 0 || posicao >= size) {
            throw new IndexOutOfBoundsException("Posição inválida.");
        }

        if (posicao == 0) {
            return removerInicio();
        }

        No<T> atual = head;
        for (int i = 0; i < posicao - 1; i++) {
            atual = atual.getProximo();
        }

        No<T> removido = atual.getProximo(); //tail = atual;
        atual.setProximo(removido.getProximo());
        size--;
        return true;
    }


    public boolean removerInicio() {
        if (isEmpty()) return false;
        head = head.getProximo();
        size--;
        return true;
    }

    public boolean removerFim() {
        if (isEmpty()) return false;
    
        if (head.getProximo() == null) {
            // Só tem um elemento
            head = null;
        } else {
            Node<T> aux = head;
            // Vai até o penúltimo nó
            while (aux.getProximo().getProximo() != null) {
                aux = aux.getProximo();
            }
            // Remove o último nó
            aux.setProximo(null);
        }
    
        size--;
        return true;
    }


    public void exibir() {
        if (isEmpty()) {
            System.out.println("Lista vazia.");
            return;
        }
        No<T> atual = head;
        while (atual != null) {
            System.out.print(atual.getModulo() + " -> ");
            atual = atual.getProximo();
        }
        System.out.println("null");
    }

    public void inverte() throws Exception{
        if(isEmpty()){
            throw new IllegalStateException("Não é possível inverter, pois a lista está vazia");
        }else{
            Stack<Integer> aux = new Stack<>(size); //cria uma pilha auxiliar do tamanho da lista
            aux = head;
            for (int i = 0; i < size; i++) { // tira da lista e coloca na pilha
                aux.push(aux.modulo);
                aux = aux.next;
            }
            aux = head;
            for (int i = 0; i < size; i++) { //tira da pilha e coloca na lista invertida
                aux.modulo = aux.pop();
                aux = aux.next;
            }
        }
    }

    public void concatena(ListaEncadeadaSimplest<T> lista)throws Exception{
        if(isEmpty()){
            throw new IllegalStateException("Não é possível concatenar, pois a primeira lista está vazia");
        }
        if(lista.isEmpty()){
            throw new IllegalStateException("Não é possível concatenar, pois a segunda lista está vazia");
        }
        No<T> tail = head;
        while (tail.getProximo() != null){
            tail = tail.getProximo();
        }
        tail.setProximo(lista.getHead);
        size += lista.getSize();
    }
    public ListaEncadeadaSimples<T> mergeOrdenado(ListaEncadeadaSimples<T> outra) {
    ListaEncadeadaSimples<T> resultado = new ListaEncadeadaSimples<>();
    No<T> atual1 = this.head;
    No<T> atual2 = outra.head;

    while (atual1 != null && atual2 != null) {
        if (atual1.getModulo().compareTo(atual2.getModulo()) <= 0) {
            resultado.addLast(atual1.getModulo());
            atual1 = atual1.getProximo();
        } else {
            resultado.adicionarFim(atual2.getModulo());
            atual2 = atual2.getProximo();
        }
    }

    // Adiciona os restantes
    while (atual1 != null) {
        resultado.adicionarFim(atual1.getModulo());
        atual1 = atual1.getProximo();
    }

    while (atual2 != null) {
        resultado.adicionarFim(atual2.getModulo());
        atual2 = atual2.getProximo();
    }

    return resultado;
}

}
