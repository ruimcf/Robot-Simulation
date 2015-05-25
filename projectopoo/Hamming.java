package projectopoo;

import java.io.Serializable;
import java.util.Random;

public class Hamming extends Agente implements Serializable{

    public Hamming(String cor1, String forma1, int[] coord2, int rv,int vida1) {
        super(cor1, forma1, coord2, rv,vida1);
        estrategia = 2;
    }

    protected int diferenca(Entidade aux, Entidade aux2) {
        int contador = 0;
        if (aux.getCor().equalsIgnoreCase(aux2.getCor()) != true) {
            contador++;
        }
        if (aux.getForma().equalsIgnoreCase(aux2.getForma()) != true) {
            contador++;
        }
        if ((aux.getClass() != aux2.getClass())) {
            contador++;
        }
        return contador;
    }

    @Override
    public boolean proxObjecto() {
        int j = 0, i, acum = 0;
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
        Entidade escolhido = campo_visao.getObjeto(0);

        if (memoria.getSize() != 0) {
            for (i = 0; i < memoria.getSize(); i++) {
                for (j = 0; j < campo_visao.getSize(); j++) {
                    if (diferenca(memoria.getObjeto(i), campo_visao.getObjeto(j)) > acum && memoria.existeObjeto(campo_visao.getObjeto(j)) != true) {
                        escolhido = campo_visao.getObjeto(j);
                        acum = diferenca(memoria.getObjeto(i), campo_visao.getObjeto(j));
                    }
                }
            }
        } else {
            do {
                int tamanho = campo_visao.getSize();
                Random gerador = new Random();
                int random = gerador.nextInt(tamanho);
                escolhido = campo_visao.getObjeto(random); //objeto no index random
            } while (memoria.existeObjeto(escolhido));
        }

        for (i = 0; i < campo_visao.getSize(); i++) {
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
