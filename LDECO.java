public class  LDECO<T>{
    private No<T> head;
    private No<T> tail;
    private int size;
    
    public LDECO(){
        head = null;
        tail = null;
        size = 0;
    }
    //OPERAÇÕES
    //•Obter o tamanho (getSize()).
    public  getSize(){
        return size;
    }
    //•Obter o ponteiro cabeça (getHead()).
    public getHead(){
        return head;
    }
    public getTail(){
        return tail;
    }
    //•Verificar se está vazia (isEmpty()).
    public boolean isEmpty() {
        return head == null;
    }
    
    //•Verificar se está cheia (isFull()).
    public boolean isFull() {
        Node<T> aux = new Node<T>(); // Tenta alocar]
        return aux == null;          // Verifica se a alocação resultou em null [1-4]
    }
    //•Imprimir os elementos em ordem crescente (showAscending()).
    public boolean showAscending(){
        Node<T> atual = head;
        if(isEmpty()) return false; // or head == null
        else{
            int count = 0;
            while(count<size){
               System.out.println(atual.getModulo()); 
               atual = atual.getProximo();
               count++;
            }
        }
        return true;
    }
    //•Imprimir os elementos em ordem decrescente (showDescending()) (esta operação é mencionada, mas não desenvolvida nos materiais).
    public boolean showDescending(){
        Node<T> atual = tail;
        if(isEmpty()) return false; // or head == null
        else{
            int count = size;
            while(count != 0){
               System.out.println(atual.getModulo()); 
               atual = atual.getAnterior();
               count--;
            }
        }
        return true;
    }
    //•Inserir um elemento na ordem correta (insertAscending()).
    public boolean insertAscending (int key, T data){
	    if (isFull()) return false;
		size++;
		return true;
	}
    //•Procurar um elemento (searchAscending() ou search()).
    public Node<T> search(T valor) {
        if (isEmpty()) return null;
        Node<T> atual = head;
        int count = 0;
        while (count < size) {
            if (atual.getModulo().equals(valor)) { // se o nó atual for igual ao valor pedido
                return atual; // retorne o valor atual
            }
            atual = atual.getProximo(); //passa pro próximo
            count++;//incrementa contador
        }
        return null;
    }

    //•Remover um elemento (remove(T data) ou remove(int Key) ou remove(int pos)).
    public remove(T Key){
        //pass
    }
    //•Limpar a lista (clear()).
    public clear(){
        //pass
    }
    //•Obter um nó pela posição (get(int pos)).
    public get(int pos){
        //pass
    }
    //•Obter a representação da lista em formato string (toString()).*/
    public toString(){
        //pass
    }
}