package ucb.rpg;

import ucb.rpg.classes.*;
import ucb.rpg.classes.util.Personagem;
import ucb.rpg.mapas.BastiaoDaEsperanca;
import ucb.rpg.mapas.Mapa;
import ucb.rpg.mapas.RefugioDosRenegados;
import ucb.rpg.mapas.SantuarioDosSobreviventes;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        Mapa mapa;

        System.out.println("""
                 _____                                           _____\s
                ( ___ )-----------------------------------------( ___ )
                 |   |            _                              |   |\s
                 |   |           | |    ___  _ __ ___            |   |\s
                 |   |           | |   / _ \\| '__/ _ \\           |   |\s
                 |   |           | |__| (_) | | |  __/           |   |\s
                 |   |           |_____\\___/|_|  \\___|           |   |\s
                 |___|                                           |___|\s
                (_____)-----------------------------------------(_____)
                """);
        System.out.println("""
                Após um demônio ancestral, Maurício, voltar a ascensão trazendo consigo uma horda crescente de
                outros demônios inferiores chamados de Besatt’s, dos quais os comportamentos lembram muito os de zumbis…
                Você, sobrevivente do acampamento tem a opção de, tentar trazer a paz de volta se livrando de Maurício,
                ou apenas tentar viver os restos dos seus dias de maneira pacífica, você escolhe.
                """);

        System.out.print("Pressione enter para continuar...");
        scanner.nextLine();

        Personagem personagem = mostrarEscolhaPersonagem();

        System.out.println("""
                1 - Bastião da Esperança
                2 - Refúgio dos Renegados
                """);

        System.out.print("Escolha: ");
        int escolhaMapa = scanner.nextInt();

        mapa = switch (escolhaMapa){
            case 1 -> new BastiaoDaEsperanca(personagem);
            case 2 -> new RefugioDosRenegados(personagem);
            default -> new BastiaoDaEsperanca(personagem);
        };

        mapa.start();

    }

    private static Personagem mostrarEscolhaPersonagem(){
        Personagem personagem;
        System.out.println("""
                
                1 - Ladino
                2 - Bárbaro
                3 - Paladino
                4 - Arqueiro
                5 - Mago
                6 - Guerreiro
                """);

        System.out.print("Escolha: ");
        int escolha = scanner.nextInt();

        personagem = switch (escolha){
            case 1 -> new Ladino();
            case 2 -> new Barbaro();
            case 3 -> new Paladino();
            case 4 -> new Arqueiro();
            case 5 -> new Mago();
            case 6 -> new Guerreiro();
            default -> throw new RuntimeException("Erro ao escolher personagem.");
        };

        System.out.printf("%-10s%-6s%-7s%-5s%-5s%-13s%-12s%n", "NOME", "FORÇA", "DEFESA", "MANA", "VIDA", "VANTAGEM", "DESVANTAGEM");
        System.out.println(personagem);

        System.out.println("1 - Confirmar personagem");
        System.out.println("0 - Voltar");

        System.out.print("Escolha: ");
        int confirmaPersonagem = scanner.nextInt();

        if(confirmaPersonagem != 1){
            mostrarEscolhaPersonagem();
        }
        return personagem;

    }
}

