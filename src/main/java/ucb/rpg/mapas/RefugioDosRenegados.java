package ucb.rpg.mapas;

import ucb.rpg.classes.util.Caracteristica;
import ucb.rpg.classes.util.Personagem;
import ucb.rpg.inimigos.Gownther;
import ucb.rpg.services.RolagemDados;

import java.util.List;

public class RefugioDosRenegados extends Mapa{
    private boolean perdeuBraco;
    public RefugioDosRenegados(Personagem jogador) {
        super("Refúgio dos Renegados", jogador, List.of(), List.of());
    }

    @Override
    public void start() {
        System.out.println("""
                Módulo 1: Você está andando pela cidade quando avista um grupo de bandidos atacando e roubando um morador indefeso em um beco.
                Você decide intervir.
                """);

        System.out.println("1 - Convencer ");
        System.out.println("2 - Roubar");
        System.out.print("Escolha: ");

        escolha = sc.nextInt();
        System.out.println();

        if (escolha == 1) {
            interacaoConvencer();
        } else {
            interacaoRoubar();
        }
    }

    //caso escolha convencer
    private void interacaoConvencer() {
        System.out.println("Teste de Inteligência: Convencer os bandidos.");
        int resultado = RolagemDados.teste(jogador, Caracteristica.INTELIGENCIA);
        if (resultado <= 5) {
            System.out.printf("""
                    Falha Crítica: Você não conseguiu convencer os bandidos, que se voltam contra você. Você apanha e perde 10 pontos de vida. (Vida %d -> %d)
                    Os bandidos caçoaram de você e começaram a te atacar sem piedade.
                    """, jogador.getVida(), jogador.getVida() - 10);
            jogador.diminuirVida(10);
        } else if (resultado <= 14) {
            System.out.println("""
                    Neutro: Você conseguiu convencer os bandidos com dificuldade. Eles hesitam, mas acabam deixando o morador em paz.
                    QUASE NÃO CONSIGO, mas os bandidos finalmente recuaram, deixando o morador escapar.
                    """);
        } else {
            System.out.printf("""
                    Acerto Crítico: Você conseguiu convencer os bandidos de forma magistral. Eles se afastam imediatamente, e o morador agradecido te ajuda a recuperar vida.
                    Sua persuasão foi tão eficaz que os bandidos desistiram instantaneamente. O morador, agradecido, oferece ajuda e você recupera 10 pontos de vida. (Vida %d -> %d)
                    """, jogador.getVida(), jogador.getVida() + 10);
            jogador.aumentarVida(10);
        }

        modulo2();
    }

    //caso escolha roubar
    private void interacaoRoubar() {
        System.out.println("Teste de Força: Enfrentar os bandidos.");
        int resultado = RolagemDados.teste(jogador, Caracteristica.FORCA);
        if (resultado <= 5) {
            jogador.diminuirVida(10);
            System.out.println("Falha Crítica: Você tenta intimidar os bandidos, mas falha miseravelmente. Eles te atacam e você perde 10 pontos de vida.");
            System.out.println("Os bandidos riram da sua tentativa e começaram a te atacar brutalmente. 'Acha que pode nos enfrentar?'");
        } else if (resultado <= 14) {
            jogador.diminuirVida(10);
            System.out.println("Neutro: Você enfrenta os bandidos com dificuldade. Consegue se defender, mas sai ferido.");
            System.out.println("Com muito esforço, você consegue se defender. 'Isso foi por pouco', pensa enquanto se afasta.");
        } else {
            jogador.aumentarVida(10);
            System.out.println("Acerto Crítico: Você enfrenta os bandidos de forma magistral. Eles acabam fugindo, e você encontra um item que recupera sua vida.");
            System.out.println("Sua força impressionante fez os bandidos recuarem. 'Não vale a pena', dizem enquanto fogem. Entre os itens deixados, você encontra algo que recupera 10 pontos de vida.");
        }

        modulo2();
    }

    private void modulo2() {
        System.out.println("Mais tarde voê está andando pela cidade quando de repente é emboscado por um grupo de bandidos. Eles te cercam, prontos para atacar. Você se prepara para decidir.");

        System.out.println("1 - Lutar ");
        System.out.println("2 - Correr");
        System.out.print("Escolha: ");

        escolha = sc.nextInt();
        System.out.println();

        if (escolha == 1) {
            interacaoLutar();
        } else {
            interacaoCorrer();
        }
    }

    //caso escolhar lutar
    private void interacaoLutar() {
        System.out.println("Teste de Força: Lutar contra os bandidos.");
        int resultado = RolagemDados.teste(jogador, Caracteristica.FORCA);
        if (resultado <= 5) {
            perdeuBraco = true;
            System.out.println("Falha Crítica: Você foi pego de surpresa e sofreu um ferimento grave. Perde um braço e não pode mais usar a habilidade 1.");
        } else if (resultado <= 14) {
            System.out.printf("Neutro: Você luta bravamente, conseguindo matar dois bandidos, mas o último consegue escapar. Perde 10 de vida. (Vida %d -> %d)%n", jogador.getVida(), jogador.getVida() - 10);
            System.out.println("Você se defende e ataca com ferocidade. Dois bandidos caem mortos, mas o terceiro foge. 'Isso não acabou', ele grita enquanto corre.");
            jogador.diminuirVida(10);
        } else {
            System.out.println("Acerto Crítico: Você executa um movimento acrobático impressionante, matando todos os bandidos.");
            System.out.println("Com um movimento incrível, você dá um mortal para trás e, em um ataque preciso, mata todos os bandidos. 'Isso foi impressionante', pensa enquanto olha os corpos ao seu redor.");
        }

        System.out.println("""
                
                Para dar uma revira volta, você é chamado e tem um último fio de esperança. Ganhar no Pedra, Papel e Tesoura;
                """);

        System.out.println("1 - Pedra");
        System.out.println("2 - Papel");
        System.out.println("3 - Tesoura");

        System.out.print("Escolha: ");
        int escolha = sc.nextInt();

        boolean venceu = RolagemDados.pedraPapelTesoura(escolha);

        if(venceu){
            System.out.println("""
                    
                    PARABÉNS, VOCÊ VENCEU O PEDRA PAPEL E TESOURA E TERMINOU COM CHAVE DE OURO REFÚGIOS DOS RENEGADOS.
                    """);
        }else{
            System.out.println("""
                    
                    DERROTA, VOCÊ PERDEU O PEDRA PAPEL E TESOURA E OS BANDIDOS ESTÃO RINDO DA SUA CARA.
                    """);
        }
    }

    //caso escolha correr
    private void interacaoCorrer() {
        System.out.println("Teste de Destreza: Correr para escapar dos bandidos.");
        int resultado = RolagemDados.teste(jogador, Caracteristica.DESTREZA);
        if (resultado <= 5) {
            System.out.printf("Falha Crítica: Você tropeça durante a fuga e é capturado pelos bandidos, que te espancam. Você perde 20 pontos de vida. (Vida %d -> %d) %n", jogador.getVida(), jogador.getVida() - 20);
            System.out.println("Os bandidos te alcançam rapidamente e te derrubam. 'Achou que podia fugir?', dizem enquanto te espancam brutalmente.");
            jogador.diminuirVida(20);
            batalhaCorrida();
        } else if (resultado <= 14) {
            jogador.diminuirVida(10);
            System.out.println("Neutro: Você consegue fugir, mas não sem dificuldade. Sai ferido e cansado, mas a salvo.");
            System.out.println("Você corre com todas as suas forças, sentindo os bandidos no seu encalço. 'Quase me pegaram', pensa enquanto finalmente consegue despistá-los, exausto e ferido.");
            moduloFinal();
        } else {
            System.out.println("Acerto Crítico: Você corre tão rápido que levanta uma nuvem de poeira e detritos, que atinge os olhos dos bandidos, fazendo-os tropeçar uns nos outros e caírem em uma vala cheia de estacas afiadas, causando suas mortes.");
            System.out.println("Com uma agilidade impressionante, você dispara como um raio. A poeira levantada pela sua corrida cega os bandidos, que tropeçam e caem desajeitadamente em uma vala cheia de estacas afiadas. 'Nem me viram fugir', você pensa, enquanto escuta os gritos deles diminuírem até o silêncio total.");
            moduloFinal();
        }
    }

    //caso tente correr e não de certo
    private void batalhaCorrida() {
        System.out.println("Batalha Corrida: Você deve lutar para escapar.");
        System.out.println("Teste de Força: Lutar contra os bandidos.");
        int resultado = RolagemDados.teste(jogador, Caracteristica.FORCA);
        if (resultado <= 5) {
            System.out.printf("Falha Crítica: Você não consegue lutar bem e os bandidos te espancam. Você perde 15 pontos de vida (Vida %d -> %d) e é capturado.", jogador.getVida(), jogador.getVida() - 15);
            System.out.println("Você tenta lutar, mas os bandidos são muitos e fortes. 'Agora você vai pagar', dizem enquanto te espancam. Você sente cada golpe e perde 15 pontos de vida, sendo finalmente capturado.");
            jogador.diminuirVida(15);

            System.out.println("É o fim... você foi capturado!");
        } else if (resultado <= 14) {
            System.out.println("Neutro: Você consegue lutar bravamente, ferindo alguns bandidos, mas acaba gravemente ferido e só consegue fugir por um triz.");
            System.out.println("Você luta com todas as suas forças, ferindo alguns bandidos. 'Você é forte, mas não o suficiente', dizem enquanto você consegue escapar por um triz, gravemente ferido e perdendo 10 pontos de vida.");
            jogador.diminuirVida(10);

            moduloFinal();
        } else {
            System.out.println("Acerto Crítico: Você luta com uma força e habilidade impressionantes, derrotando todos os bandidos.");
            System.out.println("Com uma força e habilidade surpreendentes, você derruba os bandidos um a um com golpes precisos e mortais. 'Ele é um monstro!', gritam enquanto caem, o último sendo derrubado de uma varanda e caindo em uma carroça de ferramentas afiadas. No final, você está em pé, vitorioso, rodeado pelos corpos dos bandidos.");
            moduloFinal();
        }
    }

    //caso consiga correr e de certo // caso não consiga correr e triunfe na batalha
    private void moduloFinal() {
        System.out.println("***"
                + "Módulo Final: A entrada para a Caverna das Sombras é encontrada em uma viela estreita e mal iluminada, camuflada por uma porta de pedra que se mescla perfeitamente com o ambiente rochoso ao seu redor. Uma vez dentro, você descobre que a caverna é mais do que apenas um refúgio seguro contra os Besatt’s. Ela é adornada com inscrições antigas e símbolos místicos que contam histórias de tempos passados, quando heróis enfrentaram criaturas das trevas como Gðwnthër"
                + "No coração da caverna, um altar antigo está adornado com runas e incrustações de gemas que parecem pulsar com energia mística. Livros antigos e pergaminhos empoeirados estão guardados em nichos escavados na rocha ao redor da sala principal. Pinturas rupestres nas paredes ásperas retratam batalhas épicas entre heróis e demônios, oferecendo insights sobre táticas de combate e fraquezas dos Besatt’s.\r\n"
                + "\r\n"
                + "Diante dessas descobertas na Caverna das Sombras, você se confronta com a decisão crucial: usar os conhecimentos ancestrais para enfrentar Gðwnthër e restaurar a paz, ou optar por uma vida pacífica de sobrevivência enquanto o mundo ao redor sucumbe ao caos demoníaco. Suas escolhas moldarão não apenas seu próprio destino, mas também o curso da história que se desenrola diante de você.\r\n"
                + "\r\n"
                + "Assim, na quietude protegida da Caverna das Sombras, você planeja seus próximos passos com cuidado, preparando-se para o confronto iminente ou resignando-se à paz frágil que o refúgio oferece, enquanto o destino da humanidade pende na balança entre luz e trevas."
                + "Para desvendar os segredos mais profundos da caverna e garantir seu domínio sobre seu destino, você enfrenta um desafio intelectual crucial: um quiz de conhecimento ancestral que guarda o caminho para a sabedoria e poder dentro da Caverna das Sombras.");

        System.out.println("Responder Quiz");

        sc.nextLine();
        sc.nextLine();
        quiz();
    }

    private void quiz() {
        System.out.println("Quiz: Para desvendar os segredos mais profundos da caverna e garantir seu domínio sobre seu destino, você enfrenta um desafio intelectual crucial.");

        System.out.println("Pergunta 1: Qual é o nome dado ao refúgio principal da Caverna das Sombras onde todos se encontram?");
        System.out.println("1. Sala dos Segredos  2. Salão Principal  3. Câmara da Resistência");
        int resposta1 = sc.nextInt();

        System.out.println("Pergunta 2: Como são iluminados os corredores e câmaras da Caverna das Sombras?");
        System.out.println("1. Por lâmpadas elétricas modernas  2. Por tochas antigas que lançam sombras dançantes  3. Por lanternas a gás penduradas nas paredes");
        int resposta2 = sc.nextInt();

        System.out.println("Pergunta 3: O que é encontrado nos nichos escavados na rocha ao redor da sala principal?");
        System.out.println("1. Escudos e armaduras  2. Leitos improvisados cobertos por mantas grossas e almofadas desgastadas  3. Livros antigos e pergaminhos empoeirados");
        int resposta3 = sc.nextInt();

        if (resposta1 == 2 && resposta2 == 2 && resposta3 == 3) {
            System.out.println("Você desbloqueia o acesso aos conhecimentos antigos da Caverna das Sombras, fortalecendo seu entendimento sobre como enfrentar Gðwnthër e os Besatt’s.");
            System.out.println("Com o conhecimento adquirido, você se prepara para o confronto final dentro da caverna.");
            sc.nextLine();
            sc.nextLine();
            Batalha.batalhar(jogador, new Gownther());
        } else {
            System.out.println("Sua falha em responder corretamente desperta uma reação inesperada. O chão treme enquanto múltiplos Besatt’s despertam de seu repouso nas sombras, iniciando uma batalha frenética dentro da caverna.");
            System.out.println("Mesmo derrotando alguns, eles se multiplicam no chão, o derrubando. Ao cair, seu último suspiro é absorvido pela escuridão da caverna.");
            System.out.println("O mundo lá fora, ignorante de seu sacrifício, logo enfrentará o mesmo destino. Os Besatt’s emergem da caverna, espalhando-se como uma praga sombria. Cidades e reinos caem um após o outro, e a escuridão consome tudo, marcando o início de uma era de trevas.");
            sc.nextLine();
            sc.nextLine();
            batalhaFinal();
        }
    }

    //caso erre o quiz // não tem vitória aqui, independente do que aconteça vai dar esse texto final
    private void batalhaFinal() {
        System.out.println("Batalha Final: Dentro da Caverna das Sombras, os Besatt’s.");

        System.out.println("Teste de Força: Lutar contra os Besatt’s.");
        int resultado = RolagemDados.teste(jogador, Caracteristica.FORCA);
        if (resultado <= 5) {
            jogador.diminuirVida(15);
            System.out.println("Falha Crítica: Você não consegue lutar bem e os Besatt’s te espancam. Você perde 15 pontos de vida e é capturado.");
            System.out.println("Você tenta lutar, mas os Besatt’s são muitos e fortes. 'Agora você vai pagar', dizem enquanto te espancam. Você sente cada golpe e perde 15 pontos de vida, sendo finalmente capturado.");
            System.out.println("Ao cair, seu último suspiro é absorvido pela escuridão da caverna.");
            System.out.println("O mundo lá fora, ignorante de seu sacrifício, logo enfrentará o mesmo destino. Os Besatt’s emergem da caverna, espalhando-se como uma praga sombria. Cidades e reinos caem um após o outro, e a escuridão consome tudo, marcando o início de uma era de trevas.");
        } else if (resultado <= 14) {
            jogador.diminuirVida(10);
            System.out.println("Neutro: Você consegue lutar bravamente, ferindo alguns Besatt’s, mas acaba gravemente ferido e só consegue fugir por um triz.");
            System.out.println("Você luta com todas as suas forças, ferindo alguns Besatt’s. 'Você é forte, mas não o suficiente', dizem enquanto você consegue escapar por um triz, gravemente ferido e perdendo 10 pontos de vida.");
            System.out.println("Mesmo derrotando alguns, eles se multiplicam no chão, o derrubando. Ao cair, seu último suspiro é absorvido pela escuridão da caverna.");
            System.out.println("O mundo lá fora, ignorante de seu sacrifício, logo enfrentará o mesmo destino. Os Besatt’s emergem da caverna, espalhando-se como uma praga sombria. Cidades e reinos caem um após o outro, e a escuridão consome tudo, marcando o início de uma era de trevas.");
        } else {
            System.out.println("Acerto Crítico: Você luta com uma força e habilidade impressionantes, derrotando todos os Besatt’s.");
            System.out.println("Com uma força e habilidade surpreendentes, você derruba os Besatt’s um a um com golpes precisos e mortais. 'Ele é um monstro!', gritam enquanto caem, o último sendo derrubado de uma varanda e caindo em uma carroça de ferramentas afiadas.");
            System.out.println("Você sai vitorioso da batalha final, mas ao olhar ao redor, vê que os Besatt’s se multiplicaram no chão. Mesmo derrotando alguns, eles continuam a se espalhar pela caverna.");
            System.out.println("Ao cair, seu último suspiro é absorvido pela escuridão da caverna.");
            System.out.println("O mundo lá fora, ignorante de seu sacrifício, logo enfrentará o mesmo destino. Os Besatt’s emergem da caverna, espalhando-se como uma praga sombria. Cidades e reinos caem um após o outro, e a escuridão consome tudo, marcando o início de uma era de trevas.");
        }

        sc.nextLine();
        sc.nextLine();
        sc.nextLine();

        System.out.println("""
                Realmente parecia o fim, sua energia estava indo embora junto com sua esperança...
                
                Porém, você é chamado e tem um último fio de esperança. Ganhar no Pedra, Papel e Tesoura;
                
                """);

        System.out.println("1 - Pedra");
        System.out.println("2 - Papel");
        System.out.println("3 - Tesoura");

        System.out.print("Escolha: ");
        int escolha = sc.nextInt();

        boolean venceu = RolagemDados.pedraPapelTesoura(escolha);

        if(venceu){
            System.out.println("""
                    
                    PARABÉNS, VOCÊ VENCEU O PEDRA PAPEL E TESOURA E TERMINOU COM CHAVE DE OURO REFÚGIOS DOS RENEGADOS.
                    """);
        }else{
            System.out.println("""
                    
                    DERROTA, VOCÊ PERDEU O PEDRA PAPEL E TESOURA E OS BANDIDOS ESTÃO RINDO DA SUA CARA.
                    """);
        }
    }
}