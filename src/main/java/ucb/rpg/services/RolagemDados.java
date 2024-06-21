package ucb.rpg.services;

import ucb.rpg.classes.util.Caracteristica;
import ucb.rpg.classes.util.Personagem;

import java.util.Random;

public class RolagemDados {
    private static final Random random = new Random();

    public static int rolarD20() {
        return random.nextInt(20) + 1;
    }

    public static int rolarComVantagem() {
        int rolagem1 = rolarD20();
        int rolagem2 = rolarD20();
        System.out.println("Rolagem com Vantagem: Dado 1 = " + rolagem1 + ", Dado 2 = " + rolagem2);
        int resultado = Math.max(rolagem1, rolagem2);
        System.out.printf("Resultado: %s %s %n%n", resultado, getTexto(resultado));
        return resultado;
    }

    public static int rolarComDesvantagem() {
        int rolagem1 = rolarD20();
        int rolagem2 = rolarD20();
        System.out.println("Rolagem com Desvantagem: Dado 1 = " + rolagem1 + ", Dado 2 = " + rolagem2);
        int resultado = Math.min(rolagem1, rolagem2);
        System.out.printf("Resultado: %s %s %n%n", resultado, getTexto(resultado));
        return resultado;
    }

    public static int teste(Personagem personagem, Caracteristica caracteristica){
        if(personagem.getVantagem().equals(caracteristica)){
            return rolarComVantagem();
        }
        if(personagem.getDesvantagem().equals(caracteristica)){
            return rolarComDesvantagem();
        }
        return rolarComDesvantagem();
    }

    private static String getTexto(Integer num){
        return switch (num){
            case 1, 2, 3, 4, 5 -> "(Falha crítica)";
            case 6, 7, 8, 9, 10, 11, 12, 13, 14 -> "(Neutro)";
            case 15, 16, 17, 18, 19, 20 -> "(Acerto crítico)";
            default -> throw new IllegalArgumentException("Valor do dado inesperado " + num);
        };
    }

    public static boolean pedraPapelTesoura(int escolha) {
        //1 - Pedra
        //2 - Papel
        //3 - Tesoura
        int escolhaInimiga = random.nextInt(1, 3);

        boolean venceu = false;

        if(escolha == 1){
            if(escolhaInimiga == 1){
                System.out.println("Empate!!!!");
                System.out.println("Sua escolha foi pedra e o inimigo escolheu também pedra");
            }else if(escolhaInimiga == 2){
                System.out.println("Perdeu!!!!");
                System.out.println("Sua escolha foi pedra e o inimigo escolheu papel");
            }else{
                System.out.println("Vitória!!!!");
                System.out.println("Sua escolha foi pedra e o inimigo escolheu tesoura");
                venceu = true;
            }
        }
        if(escolha == 2){
            if(escolhaInimiga == 1){
                System.out.println("Vitória!!!!");
                System.out.println("Sua escolha foi papel e o inimigo escolheu pedra");
                venceu = true;
            }else if(escolhaInimiga == 2){
                System.out.println("Empate!!!!");
                System.out.println("Sua escolha foi papel e o inimigo escolheu também papel");
            }else{
                System.out.println("Perdeu!!!!");
                System.out.println("Sua escolha foi papel e o inimigo escolheu tesoura");
            }
        }
        if(escolha == 3){
            if(escolhaInimiga == 1){
                System.out.println("Perdeu!!!!");
                System.out.println("Sua escolha foi tesoura e o inimigo escolheu também pedra");
            }else if(escolhaInimiga == 2){
                System.out.println("Vitória!!!!");
                System.out.println("Sua escolha foi tesoura e o inimigo escolheu papel");
                venceu = true;
            }else{
                System.out.println("Empate!!!!");
                System.out.println("Sua escolha foi tesoura e o inimigo escolheu também tesoura");
            }
        }
        return venceu;
    }
}
