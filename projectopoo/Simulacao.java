package projectopoo;

import gui.*;

import java.io.*;
import java.util.*;

public class Simulacao {

    protected static int prox_id;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        
        Mundo a = carregarMundo("teste.dat");
        Menu lol = new Menu(a,"teste.dat");
        lol.setVisible(true);
        
        /*
        while(true){
            System.out.println("---------------------------------");
            int opcao = pedeOpcao();
            menu(opcao,a);
        }
                */
    }

//menu
    private static int pedeOpcao() {
        int res = -1;
        Scanner sc = new Scanner(System.in);
        while (res < 0 || res > 9) {
            System.out.println("1-Adicionar entidade");
            System.out.println("2-Remover entidade");
            System.out.println("3-Ver memoria agente");
            System.out.println("4-Ver percepcao agente");
            System.out.println("5-Ver passos agente");
            System.out.println("6-Ver distancia percorria agente");
            System.out.println("7-Numero de objetos diferentes aprendidos");
            System.out.println("8-Numero de objetos aprendidos");
            System.out.println("9-Inicar simulacao(Necessaria antes das opcoes 3 a 8)");
            System.out.println("0-Sair");

            res = Integer.parseInt(sc.nextLine());
        }
        return res;
    }

    private static void menu(int opcao,Mundo a) throws IOException, ClassNotFoundException {
        String dest=null;
        Scanner sc = new Scanner(System.in);
        switch (opcao) {
            case 1:
                Entidade ent = adicionarEntidades();
                if (ent instanceof Agente) {
                    a.addAgente((Agente) ent);
                } else {
                    a.addObjeto((Objeto)ent);
                }
                break;
            case 2:
                ArrayList<Agente> aux;
                aux = a.getAgentes();
                System.out.println(aux);
                for (int i = 0; i < a.getMaxCoor()[0]; i++) {
                    for (int j = 0; j < a.getMaxCoor()[1]; j++) {
                        if (a.hasObjeto(i, j)) {
                            System.out.println(a.getObjeto(i, j));
                        }
                    }
                }
                System.out.println("ID:");
                int id = Integer.parseInt(sc.nextLine());
                Entidade ent2 = a.procuraEntidade(id);
                if (ent2 instanceof Agente) {
                    a.delAgente(id);
                } else {
                    a.delObjeto(ent2);
                }
                break;
            case 3:
                ArrayList<Agente> aux2;
                aux2 = a.getAgentes();
                System.out.println(aux2);
                System.out.println("ID:");
                int id2 = Integer.parseInt(sc.nextLine());
                Agente ent3 = (Agente) a.procuraEntidade(id2);
                verObjetos(1, ent3);
                break;
            case 4:
                ArrayList<Agente> aux3;
                aux3 = a.getAgentes();
                System.out.println(aux3);
                System.out.println("ID:");
                int id3 = Integer.parseInt(sc.nextLine());
                Agente ent4 = (Agente) a.procuraEntidade(id3);
                verObjetos(2, ent4);
                break;
            case 5:
                ArrayList<Agente> aux4;
                aux4 = a.getAgentes();
                System.out.println(aux4);
                System.out.println("ID:");
                int id4 = Integer.parseInt(sc.nextLine());
                Agente ent5 = (Agente) a.procuraEntidade(id4);
                for (int i = 0; i < ent5.getListaCoord().size(); i++) {
                    System.out.println(ent5.getListaCoord().get(i)[0] + " " + ent5.getListaCoord().get(i)[1]);
                }
                break;
            case 6:
                ArrayList<Agente> aux5;
                aux5 = a.getAgentes();
                System.out.println(aux5);
                System.out.println("ID:");
                int id5 = Integer.parseInt(sc.nextLine());
                Agente ent6 = (Agente) a.procuraEntidade(id5);
                System.out.print("Distancia percorrida: ");
                System.out.println(ent6.distanciaPercorrida());
                break;
            case 7:
                ArrayList<Agente> aux6;
                aux6 = a.getAgentes();
                System.out.println(aux6);
                System.out.println("ID:");
                int id6 = Integer.parseInt(sc.nextLine());
                Agente ent7 = (Agente) a.procuraEntidade(id6);
                System.out.print("Numero de objetos diferentes aprendidos: ");
                System.out.println(ent7.getMemoriaVisao().size());
                break;
            case 8:
                ArrayList<Agente> aux7;
                aux7 = a.getAgentes();
                System.out.println(aux7);
                System.out.println("ID:");
                int id7 = Integer.parseInt(sc.nextLine());
                Agente ent8 = (Agente) a.procuraEntidade(id7);
                System.out.print("Numero de objetos aprendidos: ");
                System.out.println(ent8.getMemoria().size());
                break;
            case 9:
                run(a);
                break;
            case 0:
                escreverMundo(a,"teste.dat");
                System.exit(0);
        }
    }

    private static Entidade adicionarEntidades() {
        Scanner sc = new Scanner(System.in);
        String cor, forma, tipo;
        int[] coord = new int[2];
        int raio, est, tv;
        System.out.println("Cor: ");
        cor = sc.nextLine();
        System.out.println("Forma: ");
        forma = sc.nextLine();
        System.out.println("Coordenada X: ");
        coord[0] = Integer.parseInt(sc.nextLine());
        System.out.println("Coordenada Y: ");
        coord[1] = Integer.parseInt(sc.nextLine());
        System.out.println("Agente ou Objeto: ");
        String aux = sc.nextLine();
        if (aux.equalsIgnoreCase("agente")) {
            System.out.println("Raio de visao: ");
            raio = Integer.parseInt(sc.nextLine());
            System.out.println("Estrategia:(1-Aleatorio,2-Hamming,3-Perto) ");
            est = Integer.parseInt(sc.nextLine());
            System.out.println("Tempo de vida: ");
            tv = Integer.parseInt(sc.nextLine());
            if (est == 1) {
                Agente x = new Aleatorio(cor, forma, coord, raio, tv);
                return x;
            } else if (est == 2) {
                Agente x = new Hamming(cor, forma, coord, raio, tv);
                return x;
            } else if (est == 3) {
                Agente x = new Perto(cor, forma, coord, raio, tv);
                return x;
            }
        } else if (aux.equalsIgnoreCase("objeto")) {
            System.out.println("Tipo: (cadeira,caixote,mesa,outro objeto,secretaria) ");
            tipo = sc.nextLine();
            if (tipo.equalsIgnoreCase("cadeira")) {
                Objeto x = new Cadeira(cor, forma, coord);
                return x;
            } else if (tipo.equalsIgnoreCase("caixote")) {
                Objeto x = new Caixote(cor, forma, coord);
                return x;
            } else if (tipo.equalsIgnoreCase("mesa")) {
                Objeto x = new Mesa(cor, forma, coord);
                return x;
            } else if (tipo.equalsIgnoreCase("secretaria")) {
                Objeto x = new Secretaria(cor, forma, coord);
                return x;
            } else {
                Objeto x = new OutroObjeto(cor, forma, coord, tipo);
                return x;
            }
        }
        return null;
    }
//acaba aqui menu
    
    private static void verObjetos(int i, Agente robo) {
        ArrayList<Entidade> aux;
        if (i == 1) {
            aux = robo.getMemoria();
            System.out.println(aux);
        } else if (i == 2) {
            aux = robo.getMemoriaVisao();
            System.out.println(aux);
        }
    }

    public static void run(Mundo a) {
        int i = 0;
        while (i < a.getAgentesSize()) {
            while (a.getAgentes().get(i).getVida() > 0) {
                Agente robo = null;
                if (a.getAgentes().get(i) instanceof Perto) {
                    robo = (Perto) a.getAgentes().get(i);
                } else if (a.getAgentes().get(i) instanceof Aleatorio) {
                    robo = (Aleatorio) a.getAgentes().get(i);
                } else {
                    robo = (Hamming) a.getAgentes().get(i);
                }
                robo.setCampoVisao(a.devolverObjetos(robo.getCoord(), robo.getRaioVisao()));
                if (robo.proxObjecto() == false) {
                    robo.naoEncontrou(a.getMaxCoor());
                }
            }
            i++;
        }
    }

    public static void escreverMundo(Mundo a, String nome) throws FileNotFoundException, IOException {
        ObjectOutputStream oS = new ObjectOutputStream(new FileOutputStream(nome));
        oS.writeObject(a);
        oS.close();
        escreveDef();
    }

    public static Mundo carregarMundo(String nome) throws IOException, ClassNotFoundException {
        ObjectInputStream iS = new ObjectInputStream(new FileInputStream(nome));
        Mundo a = (Mundo) iS.readObject();
        iS.close();
        carregarDef();
        return a;
    }

    private static void escreveDef() throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("def.txt"));
        pw.println(prox_id);
        pw.close();
    }

    private static void carregarDef() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("def.txt")));
        prox_id = Integer.parseInt(br.readLine());
        br.close();
    }

    static int atribuirID() {
        return (prox_id++);
    }
}
