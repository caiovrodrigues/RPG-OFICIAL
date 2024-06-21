package ucb.rpg.classes;

import ucb.rpg.classes.util.Caracteristica;
import ucb.rpg.classes.util.Personagem;

import java.util.Scanner;

public class Guerreiro extends Personagem {

    public Guerreiro() {
        super("Guerreiro", Caracteristica.FORCA, Caracteristica.DESTREZA, 95, 85, 50, 75);
    }

    @Override
    public void mostrarHabilidades(Personagem alvo) {
        System.out.println("Escolha a habilidade a ser utilizada:");
        System.out.println("1. Quebra o Chão (consume 25 de mana)");
        System.out.println("2. Habilidade defensiva (cura ou armadura, consome 20 de mana)");

        Scanner scanner = new Scanner(System.in);
        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                if (mana >= 25) {
                    quebraOChao(alvo);
                    mana -= 25;
                } else {
                    System.out.println("Mana insuficiente para usar Quebra o Chão.");
                }
                break;
            case 2:
                if (mana >= 20) {
                    habilidadeDefensiva();
                    mana -= 20;
                } else {
                    System.out.println("Mana insuficiente para usar Habilidade defensiva.");
                }
                break;
            default:
                System.out.println("Opção inválida. Usando Quebra o Chão por padrão.");
                if (mana >= 25) {
                    quebraOChao(alvo);
                    mana -= 25;
                } else {
                    System.out.println("Mana insuficiente para usar Quebra o Chão.");
                }
                break;
        }
    }

    public void quebraOChao(Personagem alvo) {
        int debuffDefesa = 10;
        System.out.println(getNome() + " quebra o chão, reduzindo a defesa de " + alvo.getNome() + " em " + debuffDefesa + ".");
        alvo.reduzirDefesa(debuffDefesa);
    }

    public void habilidadeDefensiva() {
        int aumentoVida = 30;
        vida += aumentoVida;
        System.out.println(getNome() + " usa uma habilidade defensiva, ganhando " + aumentoVida + " de vida. Vida atual: " + vida);
    }

    @Override
    public void habilidade1(Personagem alvo) {

    }

    @Override
    public void habilidade2(Personagem alvo) {

    }
}
