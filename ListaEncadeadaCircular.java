public class ListaEncadeadaCircular{
    private No<T> head;
    private int size;

    public ListaEncadeadaCircular(){
        head = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public boolean adicionarInicio(T modulo){
        No<T> aux = new No<>(modulo);
        if (isEmpty() == true){
            head = tail = aux;
            aux.setProximo(head);
        } else{
            aux.setProximo(head);
            tail.setProximo(aux);
            head = aux;
        }
         size++;
        return true;
    }

    public boolean adicionarMeio(T modulo){
        // 1. Valida a posição de inserção
        if (posicao < 0 || posicao > size) {
            throw new IndexOutOfBoundsException("Posição inválida."); // Lança exceção para posições fora dos limites
        }

        // 2. Trata inserção no início (posição 0)
        if (posicao == 0) {
            return adicionarInicio(elemento); // Delega para um método existente que lida com a inserção no início
        }
        // 3. Trata inserção no final (posição igual ao tamanho atual)
        else if (posicao == size) {
            return adicionarFim(elemento); // Delega para um método existente que lida com a inserção no final
        }
        // 4. Trata inserção no meio (posições entre 0 e size, exclusivas)
        else {
            // Cria o novo nó a ser inserido
            No<T> novo = new No<>(elemento);
            // Inicia um ponteiro auxiliar no cabeça da lista
            No<T> atual = head;

            // Percorre a lista até o nó ANTERIOR à posição desejada
            for (int i = 0; i < posicao - 1; i++) {
                atual = atual.getProximo();
            }

            // Ajusta os ponteiros para inserir o novo nó
            novo.setProximo(atual.getProximo()); // O novo nó aponta para o que vinha depois de 'atual'
            atual.setProximo(novo); // 'atual' agora aponta para o novo nó

            // Incrementa o tamanho da lista
            size++;
            return true; // Inserção realizada com sucesso
        }
    }

    public boolean adicionarFim(T modulo){
        No<t> aux = new No<>(modulo);
        if (isEmpty() == true){
            head = tail = aux;
            aux.setProximo(head);
        } else{
            tail.setProximo(aux);
            aux.setProximo(head);
            tail = aux;
    
        }
        size++;
        return true;
    }

    public boolean removerInicio(T modulo){
        if(isEmpty() == true) return false;
        else if(size == 1){ // Caso especial: removendo o único elemento [1]
            head = null; // A lista fica vazia [1]
            tail = null; // A lista fica vazia [1]
        }else{
            tail.setProximo(head.getProximo());
            head = head.getProximo;
        }
        size--;
        return true;
    }

    public boolean removerFim(T modulo){
        if (isEmpty()==true) return false;
        else if(size == 1){
            head = null;
            tail = null;
        }else{
            tail = tail.getAnterior();
            tail.setProximo(head);
        }
        size--;
        return true;
    }

    public void inverte()throws Exception{
        if(isEmpty()){
            throw new IllegalStateException("Não é possível inverter, pois a lista está vazia");
        }else{
            Stack<Integer> aux = new Stack<>(size); //cria uma pilha auxiliar do tamanho da lista
            while(!isEmpty()){ // tira da lista e coloca na pilha
                int valor = removeHead();
                aux.push(valor);
            }
            while(!aux.isEmpty()){ //tira da pilha e coloca na lista invertida
                int valor = aux.pop();
                inserirFinal(valor);
            }
        }
    }

    public void concatena(CircleLinkedLIst<T> lista)throws Exception{
        if(isEmpty()){
            throw new IllegalStateException("Não é possível concatenar, pois a primeira lista está vazia");
        }
        if(lista.isEmpty()){
            throw new IllegalStateException("Não é possível concatenar, pois a segunda lista está vazia");
        }
        No<T> head2 = lista.getHead();
        No<T> tail2 = head2;
        while (tail2.getProximo() != head2){
            tail2 = tail2.getProximo();
        }
        No<T> head = getHead();
        No<T> tail = head;
        while (tail.getProximo() != head){
            tail = tail.getProximo();
        }
        tail.setProximo(head2);
        tail2.setProximo(head);
        size += lista.getSize();
    }
}