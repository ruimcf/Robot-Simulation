package projectopoo;

import java.io.Serializable;

    public class Entidade implements Serializable{
        protected int id;
        protected String cor;
        protected String forma;
        protected int [] coord = new int [2];
        
        Entidade(String cor1, String forma1, int [] coord2){
            id = Simulacao.atribuirID();
            cor = cor1;
            forma = forma1;
            coord[0] = coord2[0];
            coord[1] = coord2[1];
        }
        public int getID(){  
            return id;}
        public String getCor(){
            return cor;}
        public String getForma(){
            return forma;}
        public int [] getCoord(){
            return coord;}
        public void setID(int n){
            id = n;}
        public void setCor(String c){
            cor = c;
        }
        @Override
        public String toString(){
            return "\nID: "+id+"  ||  Cor: "+cor+"\nForma: "+forma+"\nCoordenadas: ("+coord[0]+", "+coord[1]+")\n";
        }
    
}
