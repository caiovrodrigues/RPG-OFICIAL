package ucb.rpg.classes;

import ucb.rpg.classes.util.Caracteristica;
import ucb.rpg.classes.util.Personagem;

import java.util.Scanner;

public class Mago extends Personagem {
    public Mago() {
        super("Mago", Caracteristica.INTELIGENCIA, Caracteristica.FORCA, 70, 50, 100, 40);
    }

    public void usarHabilidadeEspecial(Personagem alvo) {
        System.out.println("Escolha a habilidade a ser utilizada:");
        System.out.println("1. Bola de Fogo (consume 30 de mana)");
        System.out.println("2. Bola de Raio (consume 20 de mana)");

        Scanner scanner = new Scanner(System.in);
        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                if (mana >= 30) {
                    bolaDeFogo(alvo);
                    mana -= 30;
                } else {
                    System.out.println("Mana insuficiente para usar Bola de Fogo.");
                }
                break;
            case 2:
                if (mana >= 20) {
                    bolaDeRaio(alvo);
                    mana -= 20;
                } else {
                    System.out.println("Mana insuficiente para usar Bola de Raio.");
                }
                break;
            default:
                System.out.println("Opção inválida. Usando Bola de Fogo por padrão.");
                if (mana >= 30) {
                    bolaDeFogo(alvo);
                    mana -= 30;
                } else {
                    System.out.println("Mana insuficiente para usar Bola de Fogo.");
                }
                break;
        }
    }

    public void bolaDeFogo(Personagem alvo) {
        int dano = 30;
        System.out.println(nome + " conjura uma Bola de Fogo em " + alvo.getNome() + ", causando " + dano + " de dano.");
        alvo.receberDano(dano);
    }

    public void bolaDeRaio(Personagem alvo) {
        int dano = 20;
        System.out.println(nome + " conjura um Raio em " + alvo.getNome() + ", causando " + dano + " de dano.");
        alvo.receberDano(dano);
    }

    @Override
    public void mostrarHabilidades(Personagem alvo) {

    }

    @Override
    public void habilidade1(Personagem alvo) {

    }

    @Override
    public void habilidade2(Personagem alvo) {

    }
}
