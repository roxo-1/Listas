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
            } else if (pAnda.getAnterior() != head){ //inserão do meio
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
                /*aux.setLeft(pAnda);
                aux.setRight(head);
                pAnda.setRight(aux);
                head.setLeft(aux);*/
            }
        }
		size++;
		return true;
	}

    //•Inserir um elemento na ordem inversa (insertDescending()).
    public boolean insertDescending(int key, T modulo) {
    No<T> aux = new No<>(modulo); // Criação do novo nó com o dado
    if (isEmpty()) {
    head = tail = aux;
    aux.setAnterior(aux);
    aux.setProximo(aux);
    } else {
    No<T> pAnda = head;
    // Percorre enquanto a chave for menor que a do nó atual e não der a volta
    while (key < pAnda.getData().getKey() && pAnda.getProximo() != head) {
        pAnda = pAnda.getProximo();
    }
    // Inserção no início
    if (pAnda == head && key > pAnda.getData().getKey()) {
        aux.setProximo(pAnda);
        aux.setAnterior(tail);
        tail.setProximo(aux);
        pAnda.setAnterior(aux);
        head = aux;
    }
    // Inserção no final
    else if (pAnda == tail && key < pAnda.getData().getKey()) {
        aux.setProximo(head);
        aux.setAnterior(pAnda);
        pAnda.setProximo(aux);
        head.setAnterior(aux);
        tail = aux;
    }
    // Inserção no meio
    else {
        No<T> pAnt = pAnda.getAnterior();
        aux.setProximo(pAnda);
        aux.setAnterior(pAnt);
        pAnt.setProximo(aux);
        pAnda.setAnterior(aux);
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
    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }
    //•Obter um nó pela posição (get(int pos)).
    public T get(int pos){
        if(isEmpty()) return false;
        Node<T> atual = head;
        for (int i = 0; i < pos; i++) {
            atual = atual.getProximo();
        }

        return atual.getModulo();
    }
    //•Obter a representação da lista em formato string (toString()).*/
    public String toString(){
        StringBuilder stringb = new StringBuilder();
		stringb.append("(").append(count).append(") \n");

		if (head == null) {
			return stringb.toString();
		} else {
			Node atualNode = head;
			while (atualNode != null) {
				Node ant = atualNode.getAnterior();
				Node prox = atualNode.getProximo();
				String formatted = String.format("%.1f", atualNode.getModulo());
				String idAnt = (ant == null) ? "null <- (" : (ant.getId() + " <- (");
				String idProx = (prox == null) ? "null" : (prox.getId());
				stringb.append(idAnt)
						.append(atualNode.getId()).append(";")
						.append(atualNode.getNome()).append(";")
						.append(formatted).append(") -> ")
						.append(idProx).append("\n");
				atualNode = atualNode.getProximo();
			}
		}
		return stringb.toString();
	} 

    public void inverte() throws Exception{
        if(isEmpty()){
            throw new IllegalStateException("Não é possível inverte a lista, pois ela está vazia");
        } else{
            ListaEncadeadaSimples<T> aux = new ListaEncadeadaSimples();
            while(!isEmpty()){
                T valor = removeFinal();  // Supondo que você tenha esse método
                aux.inserirFinal(valor);
            }
            while (!aux.isEmpty()) { 
                T valor = aux.removeInicio();  // Supondo que você tenha esse método
                inserirFinal(valor);
            }
        }
    }

    public void concatena(DLL<T> lista)throws Exception{
        if(isEmpty()){
            throw new IllegalStateException("Não é possível concatenar as listas pois, a primeira lista está vazia");
        }
        if(lista.isEmpty()){
            throw new IllegalStateException("Não é possível concatenar as listas pois, a segunda lista está vazia");
        }
        //definir "variáveis"
        No<T> head1 = getHead();//head da lista 1
        No<T> tail1 = getTail();//tail da lista 1
        No<T> head2 = lista.getHead(); //head da lista 2
        No<T> tail2 = lista.getTail();//tail da lista 1
        //concatena as duas listas
        tail1.setProximo(head2); // o próximo do tail da lista1 deve ser o head da lista 2
        tail2.setProximo(head1); // o próximo do tail da lista2 deve ser o head da lista 1
        head1.setAnterior(tail2);// o anterior do head da lista1 deve der o tail da lista 2
        head2.setAnterior(tail1); // o anterior do head da lista2 deve ser o tail da lista 1
        this.tail = tail2; //atualiza do tail da lista concatenada
        size += lista.getSize();//atualizando o tamanho da lista depois de concatenada
    }
}