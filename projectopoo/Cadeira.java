package projectopoo;

import java.io.Serializable;

public class Cadeira extends Objeto implements Serializable{
    public Cadeira( String cor1, String forma1, int [] coord2){
        super(cor1,forma1,coord2);
        tipo = "Cadeira";
    }
    public String toString(){
        return "\n---- Objeto do Tipo "+tipo+" ----"+super.toString();
    }
}
