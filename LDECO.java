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
        No<T> aux = new No<>(modulo);
	    if (isFull()) return false;
        else if (isEmpty()){
            head = tail = aux;
            aux.setProximo(aux);
            aux.setAnterior(aux);
        } else{
            Node <T> pAnda=head, pAnt=null;
            while (pAnda.getData().getKey() <= key && pAnda.getProx() != head) {
                pAnt = pAnda;
                pAnda = pAnda.getProx();
            }
            if (pAnt == null){ //inserção cabeça 
                    head = aux;
                    aux.setRight(pAnda);
                    pAnda.getLeft().setRight(aux);
                    aux.setLeft(pAnda.getLeft());
                    pAnda.setLeft(aux);
            } else if (pAnda.get() != head){ //inserão do meio
                    aux.setRight(pAnda);
                    aux.setLeft(pAnt);
                    pAnda.setLeft(aux);
                    pAnt.setRight(aux);
            } else {
                pAnda.getRight().setLeft(aux);
                aux.setRight(pAnda.getRight());
                pAnda.setRight(aux);
                aux.setLeft(pAnda);
                // solução do professor
                aux.setLeft(pAnda);
                aux.setRight(head);
                pAnda.setRight(aux);
                head.setLeft(aux);
            }
        }
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
    public boolean remove(T Key){
        if(isEmpty()) return false;
        Node<T> aux = head;
        int count = 0;
        while(count<size){
            if(aux.getModulo().equals(key)){
                Node<T> pAnt = aux.getAnterior();
                Node<T> pProx = aux.getProximo();
                pAnt.setProximo(pProx);
                pProx.setAnterior(pAnt);
                if (aux == head) head = pProx;
                if (aux == tail) tail = pAnt;
                aux.setAnterior(null);
                aux.setProximo(null);
                size--; 
                return true;
            }
            aux = aux.getProximo();
            count++;
        }
        return false;
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