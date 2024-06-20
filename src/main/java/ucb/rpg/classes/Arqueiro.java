package ucb.rpg.classes;

import ucb.rpg.classes.util.Caracteristica;
import ucb.rpg.classes.util.Personagem;

import java.util.Scanner;

public class Arqueiro extends Personagem {
	
    private int flechas;

    public Arqueiro() {
        super("Arqueiro", Caracteristica.DESTREZA, Caracteristica.FORCA, 85, 70, 40, 65);
        this.flechas = 20;
    }

    @Override
    public void mostrarHabilidades(Personagem alvo) {
        System.out.println("Escolha a habilidade a ser utilizada:");
        System.out.println("1. Enche o Rabo de Flechas");
        System.out.println("2. Flecha Potente");

        Scanner scanner = new Scanner(System.in);
        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                encheORaboDeFlechas(alvo);
                break;
            case 2:
                flechaPotente(alvo);
                break;
            default:
                System.out.println("Opção inválida. Usando Enche o Rabo de Flechas por padrão.");
                encheORaboDeFlechas(alvo);
                break;
        }
    }

    public void encheORaboDeFlechas(Personagem alvo) {
        int flechasRequeridas = 4;
        if (flechas >= flechasRequeridas) {
            int dano = 15;
            System.out.println(getNome() + " usa Enche o Rabo de Flechas em " + alvo.getNome() + ", causando " + dano + " de dano.");
            alvo.receberDano(dano);
            flechas -= flechasRequeridas;
            System.out.println(getNome() + " agora tem " + flechas + " flechas restantes.");
        } else {
            System.out.println("Flechas insuficientes para usar Enche o Rabo de Flechas. Atacando normalmente.");
            atacar(alvo);
        }
    }

    public void flechaPotente(Personagem alvo) {
        int flechasRequeridas = 5;
        if (flechas >= flechasRequeridas) {
            int dano = 50;
            System.out.println(getNome() + " usa Flecha Potente em " + alvo.getNome() + ", acertando todos os pontos vitais e causando " + dano + " de dano.");
            alvo.receberDano(dano);
            flechas -= flechasRequeridas;
            System.out.println(getNome() + " agora tem " + flechas + " flechas restantes.");
        } else {
            System.out.println("Flechas insuficientes para usar Flecha Potente. Atacando normalmente.");
            atacar(alvo);
        }
    }

    public void atacar(Personagem alvo) {
        int dano = 10;
        System.out.println(getNome() + " ataca " + alvo.getNome() + ", causando " + dano + " de dano.");
        alvo.receberDano(dano);
    }
}
