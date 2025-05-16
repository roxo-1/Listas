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
            head = tail = null;// limpa head e tail
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
            head = tail = null; // limpa head e tail
        } else{ //senão
            head = head.getProximo();
            head.setAnterior(null);
        }
        size--;
        return true;
    }
    // OPERAÇÃO: exibirInicioFim(T modulo) Exibe do inicio ao fim
    public boolean exibirInicioFim(T modulo){
        if (isEmpty())return null;
        return true;
    }
    // OPERCAÇÃO: exibirFimInicio(T modulo) Exibe do fim ao inicio
    public boolean exibirFimInicio(T modulo){
        if (isEmpty())return null;
        return true;
    }
    // OPERAÇÃO: navegacao(T modulo) Navega para frente e para trás na lista
    public boolean navegacao(T modulo){
        if (isEmpty())return false;
        return true;
    }
}