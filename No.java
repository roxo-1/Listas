public class No<T> {
    T modulo; //valor genérico
    private No<T> anterior; // ponteiro apontando para o anterior
    private No<T> proximo; //ponteiro apontado para o próximo

    public No(T modulo){
        this.modulo = modulo;
        this.proximo = null;
        this.anterior = null;
    }

     public T getModulo() { // pega módulo
        return modulo;
    }
    public No<T> getProximo() { //pega proximo
        return proximo;
    }

    public void setProximo(No<T> proximo) { //seta proximo
        this.proximo = proximo;
    }

    public No<T> getAnterior() { // pega anterior
        return anterior;
    }

    public void setAnterior(No<T> anterior) { //seta anterior
        this.anterior = anterior;
    }

}