package projectopoo;

import java.io.*;
import java.util.*;

public abstract class Agente extends Entidade implements Serializable{

    protected int raio_visao;
    protected int estrategia;
    protected Memoria memoria;
    protected Memoria campo_visao;
    protected Memoria memoria_visao;
    protected int vida;
    protected ArrayList<int[]> passos = new ArrayList<int[]>();

    Agente(String cor1, String forma1, int[] coord2, int rv,int vida1) {
        super(cor1, forma1, coord2);
        memoria = new Memoria();
        campo_visao = new Memoria();
        memoria_visao = new Memoria();
        raio_visao = rv;
        vida = vida1;
        passos.add(coord2);
    }
    public void setVida(int vida1){
        vida = vida1;
    }
    public int getVida(){
        return vida;
    }
    public void addObjetoCV(Entidade a) {
        campo_visao.addObjeto(a);
    }

    public void addObjetoM(Entidade a) {
        memoria.addObjeto(a);
    }

    public void addObjetoMV(Entidade a) {
        memoria_visao.addObjeto(a);
    }

    public ArrayList<Entidade> getCampoVisao() {
        return campo_visao.getLista();
    }

    public ArrayList<Entidade> getMemoria() {
        return memoria.getLista();
    }

    public ArrayList<Entidade> getMemoriaVisao() {
        return memoria_visao.getLista();
    }

    public ArrayList<int[]> getListaCoord() {
        return passos;
    }

    @Override
    public String toString() {
        return super.toString() + "---- Agente de Estrategia: " + estrategia + " ----" + "\ncampo visao: " + raio_visao;
    }

    public void setCampoVisao(ArrayList<Entidade> l) {
        campo_visao.setLista(l);
    }

    public int getRaioVisao() {
        return raio_visao;
    }

    public void moverPara(int[] coord) {
        this.coord = coord;
        passos.add(coord);
        vida -=1 ;
    }

    public abstract boolean proxObjecto();

    public void naoEncontrou(int[] max) {
        int x, y;
        int[] aux = new int[2];
        Random gerador = new Random();
        do {
            x = gerador.nextInt(raio_visao * 2) - raio_visao;
            y = gerador.nextInt(raio_visao * 2) - raio_visao;
        } while (this.coord[0] + x < 0 || this.coord[0] + x > max[0] || this.coord[1] + y < 0 || this.coord[1] + y > max[1]);
        aux[0] = this.coord[0] + x;
        aux[1] = this.coord[1] + y;
        moverPara(aux);
        campo_visao.reset();

    }
    public float distanciaPercorrida(){
        float acum = 0;
        for(int i=0;i<passos.size()-1;i++){
            acum += Math.sqrt(Math.pow(passos.get(i)[0] - passos.get(i+1)[0], 2) + Math.pow(passos.get(i)[1] - passos.get(i+1)[1], 2));
        }
        return acum;
    }
    public int nObjetosDiferentes(){
        return memoria_visao.getSize();
    }
    public int nObjetos(){
        return memoria.getSize();
    }
}
