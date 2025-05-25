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
   public void mergeOrdenado(LinkedList<T> outra) {
        // Lista auxiliar que receberá os dados em ordem
        LinkedList<T> resultado = new LinkedList<>();
    
        Node<T> atual1 = this.head;
        Node<T> atual2 = outra.head;
    
        // Mescla os elementos em ordem
        while (atual1 != null && atual2 != null) {
            if (atual1.getDado().compareTo(atual2.getDado()) <= 0) {
                resultado.addLast(atual1.getDado());
                atual1 = atual1.getProximo();
            } else {
                resultado.addLast(atual2.getDado());
                atual2 = atual2.getProximo();
            }
        }
    
        // Adiciona o restante dos elementos
        while (atual1 != null) {
            resultado.addLast(atual1.getDado());
            atual1 = atual1.getProximo();
        }
    
        while (atual2 != null) {
            resultado.addLast(atual2.getDado());
            atual2 = atual2.getProximo();
        }
    
        // Atualiza a lista atual (this) com o resultado
        this.head = resultado.head;
        this.size = resultado.size;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }
    
        if (index == 0) {
            head = head.getProximo();
        } else {
            Node<T> anterior = head;
            for (int i = 0; i < index - 1; i++) {
                anterior = anterior.getProximo();
            }
            anterior.setProximo(anterior.getProximo().getProximo());
        }
    
        size--;
    }

    public void remove(int tipo) {
        if (tipo != 1 && tipo != 2) {
            throw new IllegalArgumentException("Tipo inválido: use 1 para ímpar, 2 para par");
        }
    
        // Começa do fim para evitar problemas com shifting de índices
        for (int i = size - 1; i >= 0; i--) {
            if ((tipo == 1 && i % 2 != 0) || (tipo == 2 && i % 2 == 0)) {
                removeAt(i);
            }
        }
    }
    public void duplica() throws Exception {
        if (isEmpty()) {
            throw new IllegalStateException("Lista está vazia");
        }
    
        ListaEncadeadaSimples<T> copia = new ListaEncadeadaSimples<>();
        Node<T> atual = head;
    
        while (atual != null) {
            copia.adicionarFim(atual.getModulo()); // Copia os dados, não os nós
            atual = atual.getProximo();
        }
    
        concatena(copia); // Junta a cópia ao final da lista original
}



}
