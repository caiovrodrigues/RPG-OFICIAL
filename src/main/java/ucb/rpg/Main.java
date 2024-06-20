package ucb.rpg;

import ucb.rpg.classes.Arqueiro;
import ucb.rpg.classes.util.Personagem;
import ucb.rpg.mapas.BastiaoDaEsperanca;

public class Main {
    public static void main(String[] args) {
        Personagem arqueiro = new Arqueiro();

        var mapaBastiao = new BastiaoDaEsperanca(arqueiro);

        mapaBastiao.start();

    }
}
    	/*
        Personagem ladino = new Ladino();
        Personagem barbaro = new Barbaro();
        Personagem paladino = new Paladino();
        Personagem arqueiro = new classes.Arqueiro();
        Personagem mago = new Mago();
        Personagem guerreiro = new Guerreiro();

        System.out.println("Exibindo atributos e realizando testes para cada personagem:\n");

        ladino.exibirAtributos();
        ladino.("destreza");
        ladino.realizarTeste("forca");
        System.out.println();

        barbaro.exibirAtributos();
        barbaro.realizarTeste("inteligencia");
        System.out.println();

        paladino.exibirAtributos();
        paladino.realizarTeste("destreza");
        System.out.println();

        arqueiro.exibirAtributos();
        arqueiro.realizarTeste("destreza");
        arqueiro.realizarTeste("forca");
        System.out.println();

        mago.exibirAtributos();
        mago.realizarTeste("inteligencia");
        mago.realizarTeste("forca");
        mago.realizarTeste("destreza");
        System.out.println();

        guerreiro.exibirAtributos();
        guerreiro.realizarTeste("forca");
        guerreiro.realizarTeste("destreza");
        System.out.println();
    }
}

   
        
        
        

    /*public void executarBatalha() {
        classes.Arqueiro arqueiro = new classes.Arqueiro();
        Gownther gownther = new Gownther();

        Scanner scanner = new Scanner(System.in);

    
        System.out.println("Você é o classes.Arqueiro e vai enfrentar Gðwnthër!");
        
        System.out.println(arqueiro);
        System.out.println(gownther);
        

        while (arqueiro.estaVivo() && gownther.estaVivo()) {
            System.out.println("Escolha uma habilidade:");
            System.out.println("1. Enche o rabo de flechas");
            System.out.println("2. Flecha potente");
            System.out.print("Escolha: ");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    arqueiro.encheORaboDeFlechas(gownther);
                    break;
                case 2:
                    arqueiro.flechaPotente(gownther);
                    break;
                default:
                    System.out.println("Escolha inválida. Escolha novamente.");
                    continue;
            }

            if (gownther.estaVivo()) {
                gownther.chamaInfernal(arqueiro);
                gownther.furiaDemoniaca();
            }

            System.out.println("------------------------------");
            System.out.println(arqueiro);
            System.out.println(gownther);
            System.out.println("------------------------------");
        }

        if (!gownther.estaVivo()) {
            System.out.println("Gðwnthër foi derrotado! Parabéns!");
        } else {
            System.out.println("Infelizmente, Gðwnthër foi forte demais");
        }

        scanner.close();
    }
}
*/


        
        
