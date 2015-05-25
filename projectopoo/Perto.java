package projectopoo;

import java.io.Serializable;

public class Perto extends Agente implements Serializable{

    public Perto(String cor1, String forma1, int[] coord2, int rv,int vida1) {
        super(cor1, forma1, coord2, rv,vida1);
        estrategia = 3;
    }

    @Override
    public boolean proxObjecto() {
        Entidade escolhido;
        int j = 0, i;
        float dist;
        if (campo_visao.getSize() == 0) {
            j = 1;
        }
        for (i = 0; i < campo_visao.getSize(); i++) {
            if (memoria.existeObjeto(campo_visao.getObjeto(i))) {
                j = 1;
            } else {
                j = 0;
                break;
            }
        }
        if (j == 1) {
            return false;
        }
        escolhido = campo_visao.getObjeto(campo_visao.getSize()-1);
        dist = (float) Math.sqrt(Math.pow(campo_visao.getObjeto(campo_visao.getSize()-1).getCoord()[0] - this.coord[0], 2) + Math.pow(campo_visao.getObjeto(campo_visao.getSize()-1).getCoord()[1] - this.coord[1], 2));
        for (i = 0; i < campo_visao.getSize()-1; i++) {
            int[] obj_coord = campo_visao.getObjeto(i).getCoord();
            if (Math.sqrt(Math.pow(obj_coord[0] - this.coord[0], 2) + Math.pow(obj_coord[1] - this.coord[1], 2)) < dist && (this.coord[0]!=obj_coord[0] || this.coord[1]!=obj_coord[1])) {
                if(memoria.existeObjeto(campo_visao.getObjeto(i))){
                    campo_visao.removeObjeto(campo_visao.getObjeto(i));
                    continue;
                }
                escolhido = campo_visao.getObjeto(i);
                dist = (float) Math.sqrt(Math.pow(obj_coord[0] - this.coord[0], 2) + Math.pow(obj_coord[1] - this.coord[1], 2));
            }
        }
        for( i = 0;i<campo_visao.getSize();i++){
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
