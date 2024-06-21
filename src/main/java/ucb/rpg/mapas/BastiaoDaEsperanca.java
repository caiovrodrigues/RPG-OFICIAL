package ucb.rpg.mapas;

import ucb.rpg.classes.util.Caracteristica;
import ucb.rpg.classes.util.Personagem;
import ucb.rpg.inimigos.Feiticeiro;
import ucb.rpg.inimigos.Gownther;
import ucb.rpg.inimigos.Mauricio;
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
        System.out.println();

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
        System.out.println("Ao chegar na cabana, você enfrenta uma luta próxima a ela.");

        System.out.print("\nPressione enter para rolar o dado...");
        sc.nextLine();
        sc.nextLine();

        int dado = RolagemDados.teste(jogador, Caracteristica.FORCA);

        if (dado  >= 1 && dado <= 5) {
            System.out.printf("""
                    O zumbi te agarra com força, suas garras rasgando sua pele. Você cai no chão, sangrando e com dor.
                    Você falha em derrotar o zumbi e é gravemente ferido. Perde 20 pontos de vida. (Vida %d -> %d)
                                
                    Ladrão 1: "HAHAHA, sua coragem é admirável. Pena que não serviu para nada."
                    Ladrão 2: "Isso é para você aprender a não bancar de herói. HAHAH"
                    Ladrão 3: "Vamos embora antes que ele se recupere."
                    Você: "aahhgggggwwwwr... *agonizando de dor*"
                          "Não posso acreditar que fui derrotado por esses ladrões..."
                    """,jogador.getVida(), jogador.getVida() - 20);
            jogador.setVida(jogador.getVida() - 20);

            sc.nextLine();
            interacao1_1();

        } else if (dado >= 6 && dado <= 14) {
            System.out.printf("""
                    Você se defende e ataca com precisão. O zumbi cai morto, mas não sem antes te ferir. Você se afasta, sentindo a dor dos ferimentos
                    Você luta bravamente e consegue derrotar o zumbi, mas sai ferido. Perde 10 pontos de vida. (Vida %d -> %d)
                    
                    Ladrões: "aahhgggggwwwwr..." *agonizando de dor*
                    Você: "Foi por pouco... Uffa"
                          "Malditos, esses golpes vão deixar marcas..."
                    """, jogador.getVida(), jogador.getVida() - 10);
            jogador.setVida(jogador.getVida() - 10);
            sc.nextLine();
            interacao1_2();
        } else if (dado >= 15 && dado <= 20) {
            System.out.println("Com um movimento rápido e preciso, você destrói o zumbi. Nenhuma gota de sangue é derramada enquanto você avança para a cabana");
            System.out.println("Você derrota o zumbi com um golpe magistral, saindo ileso.");
            sc.nextLine();
            interacao1_2();
        }

//        moduloFinal();
    }

    private void interacao1_1() {
        System.out.println("""
                O vendedor 
                """);
    }

    private void interacao1_2() {
        System.out.printf("""
                O vendedor chega correndo ao local e te encontra ferido.
                Ele observa a cena com surpresa e os ferimentos em seu rosto.
                
                Vendedor: "Mu-muito obrigado"
                Vendedor: "Você arriscou sua vida por mim e pelos meus artefatos. Não posso te deixar ferido aqui. Irei te ajudar"
                Você: "Não posso deixar ladrões levarem vantagem na minha frente. Toma aqui devolta seus bens místicos..."
                """);

        sc.nextLine();

        System.out.printf("O vendedor então te dá uma porção de cura como recompensa e você recupera 10 de vida (Vida: %d -> %d)%n", jogador.getVida(), jogador.getVida() + 10);
        jogador.setVida(jogador.getVida() + 10);

        sc.nextLine();

        System.out.println("""
                Após recuperar sua saúde, o vendedor dá uma ideia para planejarmos um ataque ao esconderijo maior dos ladrões.
                
                Vendedor: "Eu descobri onde eles se escondem. Precisamos agir rápido antes que eles se reorganizem. Você está comigo?"
                """);

        System.out.println("1 - Sim. Vamos acabar com essa ameaça de uma vez por todas.");
        System.out.println("2 - Não. Eu quase morri para tentar salvar seus pertences. Talvez possamos resolver isso de outra forma. Vou tentar negociar pacificamente com os ladrões.");

        System.out.print("Escolha: ");
        escolha = sc.nextInt();
        System.out.println();

        if(escolha == 1){
            interacao1_2_1();
        }
        else if(escolha == 2){
        }
    }

    //DECISÃO: CONSEGUIU RECUPERAR OS PERTENCES E AGORA DECIDIU ENFRENTAR O NINHO DELES
    private void interacao1_2_1(){
        System.out.println("Sim. Vamos acabar com essa ameaça de uma vez por todas.");
        System.out.print("\nPressione enter para rolar o dado...");
        sc.nextLine();
        sc.nextLine();

        int dado = RolagemDados.teste(jogador, Caracteristica.FORCA);

        if (dado  >= 0 && dado <= 10) {
            System.out.print("""
                    Vocês estão a caminho...
                    
                    O jogador e o vendedor estão perto do esconderijo dos ladrões.
                    À medida que avançam, o vendedor começa a agir de maneira estranha,hesitando e olhando ao redor de forma nervosa.
                    """);
            System.out.print("\nVocê: 'Estamos quase lá. Por que você está hesitando?'");
            sc.nextLine();
            System.out.print("Vendedor: 'Eu... não posso continuar. A verdade é que eu sou um dos ladrões.'");
            sc.nextLine();
            System.out.print("Você: 'O quê? Você está brincando comigo?'");
            sc.nextLine();
            System.out.print("""
                    Vendedor: 'Não, é verdade. Vivo como um infiltrado na cidade para descobrir ameaçadores. Você é um deles.'
                    Vendedor: 'PRAZER, SOU O MAURÍCIO!!!!!'
                    """);
            sc.nextLine();
            System.out.println("Você: 'O monstro mais temido dos ladrões é você????'");

            System.out.println("""
                    Enquanto você diz isso o maurício "o vendedor" se transforma em um pinguim e te desafia à uma batalha final
                    Quem perder, sai da cidade para sempre!
                    """);

            Batalha.batalhar(jogador, new Mauricio());

        } else if (dado >= 11 && dado <= 20) {
            System.out.printf("""
                    Você se defende e ataca com precisão. O zumbi cai morto, mas não sem antes te ferir. Você se afasta, sentindo a dor dos ferimentos
                    Você luta bravamente e consegue derrotar o zumbi, mas sai ferido. Perde 10 pontos de vida. (Vida %d -> %d)
                                        
                    Ladrões: "aahhgggggwwwwr..." *agonizando de dor*
                    Você: "Foi por pouco... Uffa"
                          "Malditos, esses golpes vão deixar marcas..."
                    """, jogador.getVida(), jogador.getVida() - 10);
            interacao1_2();
        }
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

