package projectopoo;

import java.io.Serializable;

public class OutroObjeto extends Objeto implements Serializable{
    
    public OutroObjeto(String cor1, String forma1, int [] coord2,String tipo1){
        super(cor1, forma1, coord2);
        this.tipo = tipo1;
    }
    public String toString(){
        return "\n---- Objeto do Tipo "+tipo+" ----"+super.toString();
    }
    
}
