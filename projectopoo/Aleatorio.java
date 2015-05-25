package projectopoo;

import java.io.Serializable;
import java.util.*;

public class Aleatorio extends Agente implements Serializable{
    public Aleatorio(String cor1, String forma1, int [] coord2,int rv,int vida1){
        super(cor1,forma1,coord2,rv,vida1);
        estrategia = 1;
    }
    @Override
    public boolean proxObjecto(){ //Vai buscar o tamanho do ArrayList, calcula um nº random e seleciona um dos objectos em funçao desse numero
        Entidade escolhido;
        int tamanho,j=0,i;
        if(campo_visao.getSize() == 0)
            j=1;
        for(i = 0;i<campo_visao.getSize();i++){
            if(memoria.existeObjeto(campo_visao.getObjeto(i)))
                j = 1;
            else{
                j=0;
                break;
            }
        }
        if(j==1){
            return false;
        }
        do{
            tamanho = campo_visao.getSize();
            Random gerador = new Random();
            int random = gerador.nextInt(tamanho);
            escolhido = campo_visao.getObjeto(random); //objeto no index random
        }while(memoria.existeObjeto(escolhido));
        for( i = 0;i<tamanho;i++){
            Entidade aux = campo_visao.getObjeto(i);
            if (memoria.existeObjeto(aux) != true) {
                memoria_visao.addObjeto(aux);
            }
        }
        campo_visao.reset();
        memoria.addObjeto(escolhido);
        moverPara(escolhido.getCoord());
        return true;
    }

}
