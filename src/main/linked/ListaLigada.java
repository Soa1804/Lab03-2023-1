package linked;

import static org.junit.jupiter.api.Assumptions.abort;

import list.EstruturaElementar;

public class ListaLigada implements EstruturaElementar{

    private No cabeca;

    public ListaLigada() {
        cabeca = null;

    }

    @Override
    public boolean buscaElemento(int valor) {
        No n = cabeca;
        while(n != null){
            if(n.getValor() == valor){
            return true;
            }
                n= n.getProximo();
            
        }
        return false;
        
    }

    @Override
    public int buscaIndice(int valor) {
        int v=0;

        No n = cabeca;

        for(n=cabeca; cabeca.getProximo()!=null; n= n.getProximo()){
           if(n.getValor()==valor){
                return v;

           }
           else{

               v++;
           }
           
        }
        return -v;
        }


    @Override
    public int minimo() {
        if(cabeca==null){
            return Integer.MIN_VALUE;
        }
        No n =cabeca;
        int valorMin = n.getValor();
        while(n!=null){
            if(valorMin>n.getValor()){
                valorMin = n.getValor();
            }
            n = n.getProximo();
        }
        return valorMin;
    }

    @Override
    public int maximo() {
        if(cabeca == null){
            return Integer.MAX_VALUE;
        }
        No n = cabeca;
        int valorMax = n.getValor();
        while(n!=null){
            if(valorMax<n.getValor()){
                valorMax = n.getValor();
            }
            n=n.getProximo();
        }
        return valorMax;
    }

    @Override
    public int predecessor(int valor) {
        if(cabeca.getValor()==valor||cabeca==null){
            return Integer.MIN_VALUE;
        }
        No atual = cabeca;
        while(atual.getProximo()!=null){
            if(atual.getProximo().getValor()==valor){
                return atual.getValor();
            }
            atual.getProximo();
        }
        return Integer.MIN_VALUE;
        
    }

    @Override
    public int sucessor(int valor) {
        No atual = cabeca;
        while(atual.getValor()!= valor && atual!=null){
            atual = atual.getProximo();
        }
        if(atual!=null && atual.getProximo()!= null){
            return atual.getProximo().getValor();
        }
        return Integer.MIN_VALUE;
    }

    @Override
    public void insereElemento(int valor) {
        No n = new No(valor);
        if(cabeca==null){
            cabeca=n;
        }else{
            n.setProximo(cabeca);
            cabeca=n;
        }
    }

    @Override
    public void insereElementoPosicao(int valor, int buscaIndice) {
        if(cabeca ==null){
            cabeca = new No(valor);
        }else{
            No n = cabeca;
            for(int i=0;i<buscaIndice;i++){
            n=n.getProximo();
        }
        No novoNo = new No(valor);
        novoNo.setProximo(n.getProximo());
        n.setProximo(novoNo);

        }
        
    }

    @Override
    public void insereInicio(int valor) {
        if(cabeca == null){
            cabeca = new No(valor);
        } else{
            No n = new No(valor);
            n.setProximo(this.cabeca);
            this.cabeca = n;
        }

    }

    @Override
    public void insereFim(int valor) {
        if(cabeca == null){
            cabeca = new No(valor);
        }else{
            No n = cabeca;
        while(n.getProximo()!=null){
            n= n.getProximo();
        }
        n.setProximo(new No(valor));
        }
        
    }

    @Override
    public void remove(int valor) {
        if(cabeca==null){
            return;
        }
        No antes = null;
        No atual = cabeca;

        if(atual.getValor()==valor){
            cabeca = atual.getProximo();
            return;
        }

        while(atual!= null && atual.getValor() != valor){
            antes = atual;
            atual = atual.getProximo();

        }
        if(atual!=null){
            antes.setProximo(atual.getProximo());
        }
    }

    @Override
    public void removeIndice(int indice) {
        if(cabeca==null){
            return;
        }
        if(indice ==0){
            cabeca = cabeca.getProximo();
            return;
        }
        No atual = cabeca;
        int ordenacao = 0;

        while(atual!= null && ordenacao<indice-1){
            atual = atual.getProximo();
            ordenacao++;
        }
        if(atual==null || atual.getProximo()==null){
            return;
        }

        No seguinte = atual.getProximo().getProximo();
        atual.setProximo(seguinte);
    }

    @Override
    public void removeInicio() {
        if(cabeca!=null){
            cabeca = cabeca.getProximo();
        }
    }

    @Override
    public void removeFim() {
        if(this.cabeca == null || this.cabeca.getProximo()==null){
            this.cabeca=null;
            return;
        }
        No atual = cabeca;
        No antes = null;

        while(atual.getProximo()!=null){
            antes = atual;
            atual = atual.getProximo();
        }
        antes.setProximo(null);
        
    }
    
}
