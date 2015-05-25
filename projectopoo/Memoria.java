package projectopoo;

import java.io.Serializable;
import java.util.*;

public class Memoria implements Serializable{
    private ArrayList <Entidade> listaDeObjetos = new ArrayList <Entidade>();
    
    void addObjeto(Entidade a){
        listaDeObjetos.add(a);
    }
    public void setLista(ArrayList<Entidade> l){
        this.listaDeObjetos =l;}
    public ArrayList<Entidade> getLista(){
        return this.listaDeObjetos;}
    public int getSize(){
        return listaDeObjetos.size();
    }
    public Entidade getObjeto(int i){
        return listaDeObjetos.get(i);
    }
    public void reset(){
        listaDeObjetos.clear();
    }
    public Entidade procuraObjeto(int[] coord){
        for(int i=0;i<listaDeObjetos.size();i++){
            if(listaDeObjetos.get(i).getCoord()==coord)
                return listaDeObjetos.get(i);
        }
        return null;
    }
    public boolean existeObjeto(Entidade obj){
        for(int i=0;i<listaDeObjetos.size();i++){
            if(listaDeObjetos.get(i)==obj)
                return true;
        }
        return false;
    }
    public void removeObjeto(Entidade obj){
        listaDeObjetos.remove(obj);
    } 
}
