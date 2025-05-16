public class ListaDuplamenteEncadeada<T>{
    private No<T> head;
    private No<T> tail;
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
	public No<T> getHead() {
        if (isEmpty()) {
            throw new IllegalStateException("A lista está vazia, não existe head.");
        }
		return head;
	}

    // OPERAÇÃO: getTail() Retorna uma referência para o nó do final da lista, caso a lista estiver vazia retorna null.
	public No<T> getTail() {
        if (isEmpty()) {
            throw new IllegalStateException("A lista está vazia, não existe tail.");
        }
		return tail;
	}
    // OPERAÇÃO: isEmpty() Retorna uma referência para o nó do final da lista, caso a lista estiver vazia retorna null.
	public boolean isEmpty() {
        return head == null;
    }
    // OPERAÇÃO: adicionarFim(T modulo) Permite adicionar elementos no final da lista
    public boolean adicionarFim(T modulo){
        No<T> aux = new No<T> (modulo); // cria o novo nó
        if (isEmpty()){ // se estiver vazio
		    head = tail = aux; // seta head e tail para auxiliar
	    } else{ //senão
            aux.setAnterior(tail); //seta aux anterior = tail
            tail.setProximo(aux); // seta tail proximo = aux
            tail = aux;
        }
        size++;
        return true;
    }
    // OPERAÇÃO: adicionarInicio(T modulo) Permite adicionar elementos no inicio da lista
    public boolean adicionarInicio(T modulo){
        No<T> aux = new No<T> (modulo); //cria o novo nó
        if (isEmpty()){ //se estiver vazio
            head = tail = aux; // seta head e tail para auxiliar
        } else{ //senão
            aux.setProximo(head);//seta aux anterior = head
            head.setAnterior(aux);// seta head anterior = proximo
            head = aux;
        }
        size++;
        return true;
    }
    // OPERAÇÃO: removerFim(T modulo) Permite remover elementos no final da lista
    public boolean removerFim(){
        if (isEmpty())return false; // se a lista estiver vazia, ou seja, não tiver o que remover ele sai
        if(size == 1){ // se a lista tiver apenas um elemento
            throw new IllegalStateException("Não é possível remover do fim: a lista está vazia.");
        } else{ //senão
            tail = tail.getAnterior();
            tail.setProximo(null);
        }
        size--;
        return true;
    }
    // OPERAÇÃO: removerInicio(T modulo) {Permite remover elementos no inicio da lista
    public boolean removerInicio(){
        if (isEmpty())return false; // se a lista estiver vazia, não faça nada
        if(size == 1){ // se a lista tiver apenas um elemento
            throw new IllegalStateException("Não é possível remover o início: a lista está vazia.");
        } else{ //senão
            head = head.getProximo();
            head.setAnterior(null);
        }
        size--;
        return true;
    }
    // OPERAÇÃO: exibirInicioFim(T modulo) Exibe do inicio ao fim
    public void exibirInicioFim(){
        if (isEmpty()){ // se a lista estiver vazia, não faça nada
            throw new IllegalStateException("Não é possível exibir: a lista está vazia.");
        }
        No<T> atual = head; //seta atual como head (começa no head)
        while (atual != null) { // enquanto nó atual não for nulo
            System.out.print(atual.getModulo() + " "); // imprime o módulo
            atual = atual.getProximo(); // e seta o atual para o próximo
        }
        System.out.println(); //fim quando o nó atual for null.
    }
    // OPERCAÇÃO: exibirFimInicio(T modulo) Exibe do fim ao inicio
    public void exibirFimInicio(){
        if (isEmpty()){ // se a lista estiver vazia, não faça nada
            throw new IllegalStateException("Não é possível exibir: a lista está vazia.");
        }
        No<T> atual = tail; //seta atual como tail(começa no tail)
        while (atual != null) { // enquanto nó atual não for nulo
            System.out.print(atual.getModulo() + " "); // imprime o módulo
            atual = atual.getAnterior(); // e seta o atual para o Anterior
        }
        System.out.println();
    }
}