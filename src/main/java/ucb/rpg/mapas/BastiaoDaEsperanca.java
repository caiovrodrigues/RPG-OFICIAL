package ucb.rpg.mapas;

import ucb.rpg.Imagens.ImagemGownther;
import ucb.rpg.classes.util.Caracteristica;
import ucb.rpg.classes.util.Personagem;
import ucb.rpg.inimigos.Feiticeiro;
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
        System.out.println("2 - Você decide ajudar os ladrões, ajudando a roubar");

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
            jogador.diminuirVida(20);

            sc.nextLine();
            interacao1_2();

        } else if (dado >= 6 && dado <= 14) {
            System.out.printf("""
                    Você se defende e ataca com precisão. O ladrão cai morto, mas não sem antes te ferir. Você se afasta, sentindo a dor dos ferimentos
                    Você luta bravamente e consegue derrotar o ladrão, mas sai ferido. Perde 10 pontos de vida. (Vida %d -> %d)
                    
                    Ladrões: "aahhgggggwwwwr..." *agonizando de dor*
                    Você: "Foi por pouco... Uffa"
                          "Malditos, esses golpes vão deixar marcas..."
                    """, jogador.getVida(), jogador.getVida() - 10);
            jogador.diminuirVida(10);
            sc.nextLine();
            interacao1_2();
        } else if (dado >= 15 && dado <= 20) {
            System.out.println("Com um movimento rápido e preciso, você destrói o ladrão. Nenhuma gota de sangue é derramada enquanto você avança para a cabana");
            System.out.println("Você derrota o ladrão com um golpe magistral, saindo ileso.");
            sc.nextLine();
            interacao1_2();
        }
    }

    private void interacao1_2() {
        System.out.print("""
                O vendedor chega correndo ao local e te encontra ferido.
                Ele observa a cena com surpresa e os ferimentos em seu rosto.
                
                Vendedor: "Mu-muito obrigado"
                Vendedor: "Você arriscou sua vida por mim e pelos meus artefatos. Não posso te deixar ferido aqui. Irei te ajudar"
                Você: "Não posso deixar ladrões levarem vantagem na minha frente. Toma aqui devolta seus bens místicos..."
                """);

        sc.nextLine();

        System.out.printf("O vendedor então te dá uma porção de cura como recompensa e você recupera 10 de vida (Vida: %d -> %d)%n", jogador.getVida(), jogador.getVida() + 10);
        jogador.aumentarVida(10);

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
            interacao1_2_2();
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
            ImagemGownther.exibirImagem();

            System.out.println("Você: 'O monstro mais temido dos ladrões é você????'");

            System.out.println("""
                    Enquanto você diz isso o maurício "o vendedor" se transforma em um pinguim e te desafia à uma batalha final
                    Quem perder, sai da cidade para sempre!
                    """);

            Batalha.batalhar(jogador, new Mauricio());

        } else if (dado >= 11 && dado <= 20) {
            System.out.print("""
                    Os ladrões têm causado problemas no mercado há anos, e o vendedor é apenas uma das vítimas.
                    O jogador e o vendedor estão determinados a pôr um fim às suas atividades.
                    
                    Vendedor: "Eles não sabem com quem mexeram."
                    Vendedor: "Tenho 1 porção mágica que é herança do meu Avô, eu a guardo a 7 chaves e nunca compartilhei com ninguém. Ele sempre me dizia que eu saberia a hora certa para usar"
                    Vendedor: "Tenho certeza que este é o momento"
                    Você: "Glub glub glub" *Tomando porção*
                    
                    Você sente uma sensação refrescante percorre o corpo do jogador, restaurando suas reservas de energia mágica e aumentando seu poder consideravelmente.
                    """);
            System.out.printf("Força %d -> %d; Mana %d -> %d; Defesa: %d -> %d",
                    jogador.getForca(), jogador.getForca() + 30,
                    jogador.getMana(), jogador.getMana() + 30,
                    jogador.getDefesa(), jogador.getDefesa() + 30);
            jogador.setForca(jogador.getForca() + 30);
            jogador.setMana(jogador.getMana() + 30);
            jogador.setDefesa(jogador.getDefesa() + 30);

            Batalha.batalhar(jogador, new Mauricio());
        }
    }

    //Escolheu a forma pacífica e vai jogar o quiz
    private void interacao1_2_2(){
        System.out.println("""
                Ao chegar no esconderijo dos ladrões. Um dos ladrões se aproxima e pergunta o que você quer.
                
                Você: "Ei, vamos conversar. Talvez possamos encontrar um acordo que beneficie todos nós."
                Maurício: "Ok, ok... Responda a um quiz, se acertar o deixamos em paz, caso contrário você morre!!!!"
                Você: "Ta bom, vamos lá!"
                """);
        moduloFinal();
    }

    private void moduloFinal() {

        System.out.println("Pergunta 1: Qual é o artefato mais poderoso da loja?");
        System.out.println("A) Espada das Sombras");
        System.out.println("B) Amuleto da Luz");
        System.out.println("C) Elmo do Destino");
        System.out.print("Sua resposta: ");
        char resposta1 = sc.next().toLowerCase().charAt(0);

        System.out.println("Pergunta 2: Qual o nome do vendedor?");
        System.out.println("A) Carlos");
        System.out.println("B) João");
        System.out.println("C) Mauricio");
        System.out.print("Sua resposta: ");
        char resposta2 = sc.next().toLowerCase().charAt(0);

        System.out.println("Pergunta 3: Qual é a origem do artefato roubado?");
        System.out.println("A) Montanhas do Norte");
        System.out.println("B) Floresta Encantada");
        System.out.println("C) Deserto do Fogo");
        System.out.print("Sua resposta: ");
        char resposta3 = sc.next().toLowerCase().charAt(0);

        boolean acertouQuiz = resposta1 == 'b' && resposta2 == 'c' && resposta3 == 'b';

        if (acertouQuiz) {
            System.out.println("""
                    Impressionante! Aqui está seu prêmio.
                    O vendedor entrega um item poderoso.
                    Você o consome e se torna o herói mais forte de Bastião da Esperança.
                    """);
        } else {
            System.out.println("""
                    
                    Você falhou miseravelmente. Agora, enfrente minha verdadeira forma!
                    O vendedor se revela Mauricio, o vilão. Uma batalha intensa começa.
                    """);
            sc.nextLine();
            Batalha.batalhar(jogador, new Mauricio());
        }

        System.out.println("Você sobreviveu. Parabéns por completar o Bastião da Esperança!");
    }







    private void interacao2() {
        System.out.println("""
                Após ajudar os ladrões a roubar o vendedor, você é levado ao esconderijo dos ladrões como um novo aliado.
                Lá, você conhece o líder da gangue e descobre mais sobre suas operações e objetivos.
                """);
        sc.nextLine();

        System.out.println("""
                É dada uma missão a você, ir com mais 2 ladrões a cidade realizar roubo a uma mercadoria valiosa que está escondido em um dos vagões da cidade.
                
                Você, pensativo, vai a cidade realizar essa missão. No fundo isso vai contra seus valores.
                """);
        sc.nextLine();

        System.out.println("""
                No meio do roubo com seus aliados, você olha pra si mesmo e faz uma decisão
                
                1 - Você se arrepende e se rebela contra os próprios ladrões que outrora era seu aliado.
                2 - Você segue seu coração e segue com o roubo.
                """);

        System.out.print("Escolha: ");
        int escolha = sc.nextInt();

        if(escolha == 1){
            System.out.println("Você olha para os outros 3 ladrões que estava com você na missão.");
            System.out.println("Você: 'Meu Deus, o que eu estou fazendo??? Isso está errado'");
            sc.nextLine();
            System.out.println("Você: 'Saiam agora daqui, isso não é justo com estes pobres vendedores.'");
            sc.nextLine();
            System.out.println("Ladrão 1: 'Então é assim que vai ser? Um traidor no meio da nossa operação? Você vai se ARREPENDER disso.'");
            sc.nextLine();
            System.out.println("Ladrão 2: 'Traidor! Acabem com ele!'");
            sc.nextLine();
            System.out.println("Começa uma luta entre você e os ladrões");
            System.out.println("Você sai ferido e o vendedor acha que você na verdade você é algum corajoso que estava defendendo suas mercadorias dos ladrões");
            interacao1_2();
        }else{
            provaLealdade();
        }
    }

    private void provaLealdade(){
        System.out.println("""
                Você realiza o roubo e volta para o esconderijo dos ladrões.
                
                Maurício (Chefe dos ladrões): "Excelente trabalho. Você provou seu valor e sua habilidade."
                Maurício (Chefe dos ladrões): "Porém, você era um cidadão comum e traiu os vendedores de bem da cidade"
                Maurício (Chefe dos ladrões): "O que garante que não nos trairá também? Aqui não aceitamos traidores. Você está condenado"
                
                Você fica apreensivo e com medo, pois Maurício está prester a te matar.
                
                1 - Aceito a morte, traidores não tem outro destino.
                2 - Luta pela sua vida, entrando em uma batalha contra o líder Maurício
                
                """);

        System.out.print("Escolha: ");
        escolha = sc.nextInt();
        System.out.println();

        if(escolha == 1){
            System.out.println("DERROTA!");
            System.out.println("Você aceitou a morte, pois este é o destino dos traidores de Bastião da Esperança");
        }
        else if(escolha == 2){
            System.out.println("LUTAREI ATÉ O FINAL CONTRA LADRÕES DE BASTIÃO DA ESPERANÇA!");
            Batalha.batalhar(jogador, new Mauricio());
        }

    }
}

