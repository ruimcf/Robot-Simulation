package projectopoo;

import java.io.Serializable;

public class Objeto extends Entidade implements Serializable{
    protected String tipo;
    Objeto(String cor1, String forma1, int [] coord2){
        super(cor1,forma1,coord2);
    }
    
    @Override
    public String toString(){
        return super.toString();
    }
}
