package projectopoo;

import java.io.Serializable;
import java.util.*;

public class Mundo implements Serializable {

    private Celula[][] celula;
    private int max_x;
    private int max_y;
    private ArrayList<Agente> agentes;

    public Mundo(int x, int y) {
        this.celula = new Celula[x][y];
        this.max_x = x;
        this.max_y = y;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                this.celula[i][j] = new Celula();
            }
        }
        this.agentes = new ArrayList<Agente>();
    }

    public int getAgentesSize() {
        return agentes.size();
    }

    public void addObjeto(Entidade a) {
        int[] cd = a.getCoord();
        celula[cd[0]][cd[1]].addObjeto(a);
    }

    public void delObjeto(Entidade a) {
        int[] cd = a.getCoord();
        celula[cd[0]][cd[1]].delObjeto();
    }

    public void addAgente(Agente a) {
        agentes.add(a);
    }

    public Agente getAgente(int id) {
        int i;
        for (i = 0; i < this.getAgentesSize(); i++) {
            if (this.agentes.get(i).getID() == id) {
                return(this.agentes.get(i));
            }
        }
        return(null);
    }

    public ArrayList<Agente> getAgentes() {
        return agentes;
    }

    public void delAgente(int id) {
        int i;
        for (i = 0; i < this.getAgentesSize(); i++) {
            if (this.getAgente(i).getID() == id) {
                this.agentes.remove(i);
                break;
            }
        }
    }

    public boolean hasObjeto(int x, int y) {
        return (celula[x][y].hasObjeto());
    }

    public int[] getMaxCoor() {
        int[] max = new int[2];
        max[0] = max_x;
        max[1] = max_y;
        return max;
    }

    public Entidade getObjeto(int x, int y) {
        return (celula[x][y].getObjeto());
    }

    public Entidade procuraEntidade(int id) {
        int i, j;
        for (i = 0; i < max_x; i++) {
            for (j = 0; j < max_y; j++) {
                if (this.hasObjeto(j, j) == true) {
                    if (this.getObjeto(i, j).getID() == id) {
                        return this.getObjeto(i, j);
                    }
                }
            }
        }
        for (i = 0; i < this.getAgentesSize(); i++) {
            if (this.getAgente(i).getID() == id) {
                return getAgente(i);
            }
        }
        return null;
    }

    public ArrayList devolverObjetos(int[] coord, int raio_visao) {
        ArrayList<Entidade> aux2 = new ArrayList<Entidade>();
        int lim_horizontal = this.getMaxCoor()[0];
        int lim_vertical = this.getMaxCoor()[1];
        int i = -raio_visao;
        int j;
        double aux;
        if (coord[1] + i < 0) { //proteçao fora do mundo
            i = -coord[1];
        }
        while (i < raio_visao && coord[1] + i < lim_vertical) { //começa por a linha mais inferior do circulo e vai aumentando
            aux = Math.pow((raio_visao * raio_visao) + (i * i), 0.5);
            j = -(int) aux;
            if (coord[0] + j < 0) {           //proteçao fora do mundo
                j = -coord[0];
            }
            while (j < aux && coord[0] + j < lim_horizontal) {  //avança horizontalmente na linha atual
                if (celula[coord[0] + j][coord[1] + i].hasObjeto() && celula[coord[0] + j][coord[1] + i].getObjeto() instanceof Objeto) {
                    aux2.add(celula[coord[0] + j][coord[1] + i].getObjeto());
                }
                j++;
            }
            i++;
        }
        return (aux2);
    }

}
