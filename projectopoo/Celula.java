package projectopoo;
import java.io.Serializable;
import java.util.*;

public class Celula implements Serializable{
    private Entidade objeto=null;
    private int flag = 0;
    
    Celula(){       
    }
    public boolean hasObjeto(){
        if(flag == 1)
            return true;
        else
            return false;
    }
    
    public void addObjeto(Entidade obj){
        this.objeto=obj;
        flag = 1;
    }
    public void delObjeto(){
        objeto = null;
        flag = 0;
    }
    public Entidade getObjeto(){
        return(objeto);
    }
    public String toString(){
        return "objeto: "+objeto;
    }
}
