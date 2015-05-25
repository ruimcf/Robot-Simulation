package projectopoo;

import java.io.Serializable;


public class Secretaria extends Objeto implements Serializable{
    public Secretaria( String cor1, String forma1, int [] coord2){
        super(cor1,forma1,coord2);
        tipo = "Secretaria";
    }
    public String toString(){
        return "\n---- Objeto do Tipo "+tipo+" ----"+super.toString();
    }
    
}
