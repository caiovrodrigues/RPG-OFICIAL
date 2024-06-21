package ucb.rpg.mapas;

import ucb.rpg.classes.util.Personagem;

import java.util.Scanner;
import java.util.List;

public class SantuarioDosSobreviventes extends Mapa{
    public SantuarioDosSobreviventes(Personagem jogador) {
        super("Santuário dos Sobreviventes", jogador, List.of(), List.of());
    }

    @Override
    public void start() {
        System.out.printf("""
                Seja bem vindo ao %s %s
                
                Uma atmosfera tensa paira sobre a taverna enquanto o dono, um homem de meia-idade chamado Miguel, se aproxima de você com um semblante preocupado.
                Ele pede sua ajuda, explicando que seu filho, Jorge, desapareceu na floresta durante uma expedição.
                Sem hesitar, você se compromete a encontrar Jorge e trazê-lo de volta são e salvo.
                """, getNome(), jogador.getNome());

        modulo1();
    }

    private void modulo1() {
        System.out.println("\n### Módulo 1 ###");
        System.out.println("Interação: Busca na Floresta");
        System.out.println("Após horas de busca na floresta, você descobre que Jorge está numa parte sombria da cidade. Temendo o pior, você decide invadir a residência onde acha que ele está.");

        dialogo1();
    }

    private void batalhaContraZumbi() {
        System.out.print("Ao redor da cabana você encontra zumbis, ele te avista e começa uma batalha invetiavel:");
    }

    private void dialogo1() {
        System.out.println("\n### Diálogos ###");
        System.out.println("Diálogo 1: Encontrando o Ladrão no Hall Principal");
        System.out.println("Você encontra um ladrão suspeito no hall principal da residência.");
        System.out.println("\"Onde está Jorge? /O que você sabe sobre ele?\", questiona você.");
        System.out.println("\"Eu não sei de quem você está falando! Saia daqui antes que algo ruim aconteça com você!\", responde o ladrão com um olhar ameaçador.");

        batalhaContraBandidos();
    }

    private void batalhaContraBandidos() {
        System.out.println("\n### Batalha contra os Bandidos ###");
        System.out.println("Teste de Força:");

//        int resultado = rolarDados();
//        if (resultado <= 5) {
//            vida -= 15;
//            System.out.println("Falha Crítica: Os bandidos surpreendem você com sua destreza e agressividade. Você sofre um golpe devastador e perde 15 pontos de vida.");
//            System.out.println("\"Os bandidos se movem com uma destreza impressionante, pegando você desprevenido. Seus ataques são devastadores, deixando você gravemente ferido.\"");
//        } else if (resultado <= 14) {
//            vida -= 10;
//            System.out.println("Neutro: Você luta arduamente contra os bandidos, conseguindo resistir aos seus ataques, mas sai ferido. Perde 10 pontos de vida.");
//            System.out.println("\"Você se esforça para resistir aos ataques dos bandidos, mas não sai ileso. Seus ferimentos são evidentes, mas você continua lutando.\"");
//        } else {
//            vida += 10;
//            System.out.println("Acerto Crítico: Com uma habilidade excepcional, você domina os bandidos, forçando-os a recuar e recuperando 10 pontos de vida.");
//            System.out.println("\"Sua habilidade excepcional permite que você domine os bandidos. Eles recuam diante de sua determinação, e você encontra algo que recupera 10 pontos de vida.\"");
//        }

        modulo2();
    }

    private void modulo2() {
        System.out.println("\n### Módulo 2 ###");
        System.out.println("Após descer as escadas, você visualiza Jorge e se assusta com o que vê.");
        System.out.println("Com olhos vidrados, Jorge realizava os gestos do ritual, alheio à sua presença.");
        System.out.println("Sua expressão era uma mistura de determinação e desespero, como se estivesse lutando contra uma força invisível.");

        System.out.println("Enquanto o ritual de invocação de Jorge atinge seu ápice, uma aura sinistra envolve o local,");
        System.out.println("e sombras grotescas começam a tomar forma ao redor de você.");
        System.out.println("Os Besatts, criaturas das trevas convocadas pelo ritual, emergem dos portais recém-abertos,");
        System.out.println("prontos para espalhar caos e destruição.");

        batalhaContraBesatts();
    }

    private void batalhaContraBesatts() {
        System.out.println("\n### Batalha 2 ###");
        System.out.println("Teste de Força:");

//        int resultado = rolarDados();
//        if (resultado <= 5) {
//            vida -= 15;
//            System.out.println("Falha Crítica: O Besatt’s te surpreende com sua força avassaladora. Você sofre um golpe devastador e perde 15 pontos de vida.");
//            System.out.println("\"O Besatt’s se movimenta com uma força avassaladora, pegando você desprevenido. Seus golpes são devastadores, deixando você gravemente ferido.\"");
//        } else if (resultado <= 14) {
//            vida -= 10;
//            System.out.println("Neutro: Você luta arduamente contra o Besatt’s, conseguindo resistir aos seus ataques, mas sai ferido. Perde 10 pontos de vida.");
//            System.out.println("\"Você se esforça para resistir aos ataques do Besatt’s, mas não sai ileso. Seus ferimentos são evidentes, mas você continua lutando.\"");
//        } else {
//            vida += 10;
//            System.out.println("Acerto Crítico: Com uma força excepcional, você domina o Besatt’s, forçando-o a recuar e recuperando 10 pontos de vida.");
//            System.out.println("\"Sua força excepcional permite que você domine o Besatt’s. Ele recua diante de sua determinação, e você encontra algo que recupera 10 pontos de vida.\"");
//        }

        preparativosBatalhaFinal();
    }

    private void preparativosBatalhaFinal() {
        System.out.println("\n### Preparativos para a Batalha Final ###");
        System.out.println("Após enfrentar os Besatts e testemunhar a intensidade do ritual de invocação de Jorge, você se prepara para a batalha final.");

        tentativaDeResgate();
    }

    private void tentativaDeResgate() {
        System.out.println("\n### Interação: Tentativa de Resgate ###");
        System.out.println("Antes de enfrentar a entidade, você tenta um último esforço para trazer Jorge de volta à razão.");
        System.out.println("Aproximando-se cautelosamente, você fala com ele, na esperança de romper a conexão com Gðwnther.");

        System.out.println("\"Jorge, você precisa lutar contra isso! Lembre-se de quem você é. Volte para nós, para seu pai! Miguel está desesperado por você.\"");

        System.out.println("Jorge, com os olhos ainda vidrados, responde com uma voz distorcida: \"É tarde demais... a entidade já tomou conta... Salve-se enquanto pode! Enquanto diz isso, você percebe que o mal maior foi invocado o temido GOWNTHER\"");

        batalhaFinal();
    }

    private void batalhaFinal() {
        System.out.println("\n### Batalha Final contra Gðwnther ###");
        System.out.println("Teste de Força e Habilidade:");

//        int resultado = rolarDados();
//        if (resultado <= 5) {
//            vida -= 20;
//            System.out.println("Falha Crítica: Gðwnther ataca com uma força avassaladora e manipulação psíquica, pegando você desprevenido.");
//            System.out.println("Você sofre um golpe devastador e perde 20 pontos de vida.");
//            System.out.println("\"Gðwnther se manifesta com uma força e malevolência inimagináveis. Seus ataques psíquicos e físicos são devastadores, deixando você à beira da derrota.\"");
//        } else if (resultado <= 14) {
//            vida -= 15;
//            System.out.println("Neutro: Você luta arduamente contra Gðwnther, resistindo aos ataques tanto físicos quanto mentais, mas sai gravemente ferido. Perde 15 pontos de vida.");
//            System.out.println("\"Você se esforça para resistir aos ataques de Gðwnther, tanto físicos quanto psíquicos. Seus ferimentos são severos, mas você continua lutando com todas as suas forças.\"");
//        } else {
//            vida += 15;
//            System.out.println("Acerto Crítico: Com uma força e habilidade excepcionais, você encontra um ponto fraco na entidade, forçando Gðwnther a recuar e dissipando parte da energia sombria. Recupera 15 pontos de vida.");
//            System.out.println("\"Com uma habilidade excepcional, você encontra um ponto fraco em Gðwnther. Sua determinação e força de vontade fazem a entidade recuar, e a energia sombria ao seu redor começa a dissipar.\"");
//        }

        consequenciasBatalhaFinal();
    }

    private void consequenciasBatalhaFinal() {
        System.out.println("\n### Consequências da Batalha Final ###");

        if (jogador.getVida() >= 80) {
            System.out.println("Resolução e Tristeza:");
            System.out.println("Se você conseguiu um acerto crítico na batalha final, a força de Gðwnther começa a desmoronar.");
            System.out.println("A energia maligna se dissipa, e Jorge cai de joelhos, ainda sob a influência da entidade.");
            System.out.println("Em seus últimos momentos de consciência, Jorge luta para se libertar, mas a possessão é forte demais.");
            System.out.println("Ele sussurra uma última mensagem para você: \"Diga ao meu pai... que eu o amo...\".");
            System.out.println("Com essas palavras, Jorge sucumbe à escuridão, morrendo em seus braços.");

            System.out.println("\nDiálogo Final:");
            System.out.println("\"Você fez tudo o que pôde... Gðwnther foi derrotado, mas a possessão foi demais para Jorge. Ele descansará em paz agora\", diz uma voz calma dentro de você, enquanto lágrimas escorrem pelo seu rosto.");

            System.out.println("\nAo retornar à cidade com o corpo de Jorge, Miguel é consumido pela dor, mas agradece profundamente por seus esforços.");
            System.out.println("\"Meu filho... ele foi um herói até o fim. Obrigado por tentar salvá-lo\", diz Miguel, com a voz embargada.");
        } else {
            System.out.println("Diálogo Final:");
            System.out.println("\"Você não foi páreo para mim\", diz Gðwnther triunfantemente.");
            System.out.println("\"Agora, com Jorge ao meu lado, dominaremos este mundo.\"");

            System.out.println("\nMiguel assiste impotente enquanto Jorge, sob a influência de Gðwnther, conduz as forças sombrias em uma série de ataques devastadores.");
            System.out.println("A cidade é a primeira a cair, e o domínio de Gðwnther se espalha rapidamente, trazendo caos e destruição.");
        }
        //se perder a batalha contra o gownther
        System.out.println("\n### Conclusão: A Queda do Mundo ###");
        System.out.println("A derrota é total. Com Gðwnther e Jorge à frente de um exército de criaturas das trevas, o mundo sucumbe ao caos.");
        System.out.println("Cidades e vilas são engolidas pela escuridão, e a resistência é rapidamente esmagada.");
        System.out.println("O reinado de terror de Gðwnther se estende a todos os cantos do planeta, mergulhando a humanidade em uma era de desespero e medo.");

        System.out.println("\nDiálogo Final:");
        System.out.println("\"As forças das trevas prevaleceram. Gðwnther, com Jorge ao seu lado, domina o mundo.");
        System.out.println("A esperança desapareceu, e a escuridão reina suprema.\", narra o narrador.");

        System.out.println("\nMiguel:");
        System.out.println("\"Meu filho... transformado em um monstro... Tudo está perdido\", diz Miguel, com a voz quebrada pela dor e pelo desespero.");

        System.out.println("\nVocê, gravemente ferido, é deixado para testemunhar o início do fim.");
        System.out.println("A luta contra as trevas foi em vão, e a humanidade agora vive sob o jugo de Gðwnther.");
        System.out.println("As histórias de resistência serão contadas em sussurros, mas a verdade é que a luz foi apagada, e a noite eterna caiu sobre o mundo.");
    }
}
