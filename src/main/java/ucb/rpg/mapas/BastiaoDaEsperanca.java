package ucb.rpg.mapas;

import ucb.rpg.classes.util.Caracteristica;
import ucb.rpg.classes.util.Personagem;
import ucb.rpg.inimigos.Feiticeiro;
import ucb.rpg.inimigos.Gownther;
import ucb.rpg.inimigos.Saqueador;
import ucb.rpg.services.RolagemDados;

import java.util.List;

public class BastiaoDaEsperanca extends Mapa{
    public BastiaoDaEsperanca(Personagem jogador) {
        super("Bastião da Esperança", jogador, List.of("Boa defesa contra zumbis devido ao terreno elevado"), List.of("Recursos limitados para coletar nas proximidades"));
    }

    @Override
    public void start() {
        System.out.printf("Seja bem vindo ao %s %s %n", getNome(), jogador.getNome());
        System.out.println("\nVocê está explorando o mercado quando testemunha um assalto diante de seus olhos. \nUm vendedor de artefatos é brutalmente atacado por ladrões que roubam seus bens místicos.\n");
        inicio();
    }

    private void inicio() {
        System.out.println("1 - Você decide ajudar o vendedor e vai atrás dos ladrões");
        System.out.println("2 - Você finge que não viu e continua seu caminho");

        System.out.print("Escolha: ");
        escolha = sc.nextInt();

        if(escolha == 1){
            interacao1();
        }
        else if(escolha == 2){
            interacao2();
        }else{
            start();
        }
    }

    private void interacao1() {
        System.out.println("Você decide ajudar o vendedor e vai atrás dos ladrões. \nApós uma breve investigação, descobre que eles estão escondidos em uma cabana isolada no acampamento.");
        System.out.println("Ao chegar na cabana, você enfrenta uma luta fora e dentro da cabana.");

        sc.nextLine();
        sc.nextLine();

        int dado = RolagemDados.teste(jogador, Caracteristica.FORCA);

        //luta fora:
        if (dado  >= 1 && dado <= 5) {
            System.out.println("O zumbi te agarra com força, suas garras rasgando sua pele. Você cai no chão, sangrando e com dor");
            System.out.println("Você falha em derrotar o zumbi e é gravemente ferido. Perde 10 pontos de vida.");

        } else if (dado >= 6 && dado <= 14) {
            System.out.println("Você se defende e ataca com precisão. O zumbi cai morto, mas não sem antes te ferir. Você se afasta, sentindo a dor dos ferimentos");
            System.out.println("Você luta bravamente e consegue derrotar o zumbi, mas sai ferido. Perde 5 pontos de vida.");
        } else if (dado >= 15 && dado <= 20) {
            System.out.println("Com um movimento rápido e preciso, você destrói o zumbi. Nenhuma gota de sangue é derramada enquanto você avança para a cabana");
            System.out.println("Você derrota o zumbi com um golpe magistral, saindo ileso.");
        }

        sc.nextLine();
        //luta dentro:
        //Dado.rolar();

        if (dado >= 1 && dado <= 5) {
            System.out.println("Você falha em derrotar o ladrão e é capturado. Perde 15 pontos de vida.");

        } else if (dado >= 6 && dado <= 14) {
            System.out.println("Você luta bravamente e consegue derrotar o ladrão, mas sai ferido. Perde 5 pontos de vida.");

        } else if (dado >= 15 && dado <= 20) {
            System.out.println("Você derrota o ladrão com um golpe magistral, saindo ileso.");
        }

        moduloFinal();
    }

    private void interacao2() {
        Batalha.batalhar(jogador, new Feiticeiro());
    }




    private void moduloFinal() {
        System.out.println("\nApós retornar à loja com o artefato, o vendedor propõe um quiz. Se acertar, ganha um item da loja.");

        System.out.println("Pergunta 1: Qual é o artefato mais poderoso da loja?");
        System.out.println("A) Espada das Sombras");
        System.out.println("B) Amuleto da Luz");
        System.out.println("C) Elmo do Destino");
        System.out.print("Sua resposta: ");
        char resposta1 = sc.next().charAt(0);

        System.out.println("Pergunta 2: Qual o nome do vendedor?");
        System.out.println("A) Carlos");
        System.out.println("B) João");
        System.out.println("C) Mauricio");
        System.out.print("Sua resposta: ");
        char resposta2 = sc.next().charAt(0);

        System.out.println("Pergunta 3: Qual é a origem do artefato roubado?");
        System.out.println("A) Montanhas do Norte");
        System.out.println("B) Floresta Encantada");
        System.out.println("C) Deserto do Fogo");
        System.out.print("Sua resposta: ");
        char resposta3 = sc.next().charAt(0);

        if (resposta1 == 'B' && resposta2 == 'C' && resposta3 == 'B') {
            System.out.println("Impressionante! Aqui está seu prêmio. Mas cuidado, os ladrões estão voltando!");
            System.out.println("O vendedor entrega um item poderoso. Você se prepara para a batalha final.");
            //batalhaBandidos(true);
        } else {
            System.out.println("Você falhou miseravelmente. Agora, enfrente minha verdadeira forma!");
            System.out.println("O vendedor se revela Mauricio, o vilão. Uma batalha intensa começa.");
            //batalhaBandidos(false);
        }


//        if (AcertouQuiz) {
//            if (resultado >= 1 && resultado <= 5) {
//                System.out.println("Você é derrotado pelos ladrões. Perde 20 pontos de vida.");
//            } else if (resultado >= 6 && resultado <= 14) {
//                System.out.println("Você luta bravamente e consegue derrotar os ladrões, mas sai gravemente ferido. Perde 10 pontos de vida.");
//            } else if (resultado >= 15 && resultado <= 20) {
//                System.out.println("Você derrota os ladrões com um golpe magistral, saindo ileso.");
//            }
//        } else {
//            if (resultado >= 1 && resultado <= 5) {
//                System.out.println("Você é derrotado por Mauricio. Perde 20 pontos de vida.");
//            } else if (resultado >= 6 && resultado <= 14) {
//                System.out.println("Você luta bravamente e consegue derrotar Mauricio, mas sai gravemente ferido. Perde 10 pontos de vida.");
//            } else if (resultado >= 15 && resultado <= 20) {
//                System.out.println("Você derrota Mauricio com um golpe magistral, saindo ileso.");
//            }
//        }

        System.out.println("A batalha terminou e você sobreviveu. Parabéns por completar o Bastião da Esperança!");
    }
}

