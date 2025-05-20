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

    public boolean isEmpty() {
        return head == null;
    }

    public boolean adicionarInicio(T modulo) {
        No<T> novo = new No<>(modulo);
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

        No<T> removido = atual.getProximo();
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
}
