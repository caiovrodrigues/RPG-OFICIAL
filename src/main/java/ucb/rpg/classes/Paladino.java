package ucb.rpg.classes;

import ucb.rpg.classes.util.Caracteristica;
import ucb.rpg.classes.util.Personagem;

import java.util.Scanner;

public class Paladino extends Personagem {

    private int cura;

    public Paladino() {
        super("Paladino", Caracteristica.NENHUMA, Caracteristica.NENHUMA, 90, 75, 60, 80);
    }

    public void usarHabilidadeEspecial(Personagem alvo) {
        System.out.println("Escolha a habilidade a ser utilizada:");
        System.out.println("1. Curar");
        System.out.println("2. Atacar");

        Scanner scanner = new Scanner(System.in);
        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                curar();
                break;
            case 2:
                atacar(alvo);
                break;
            default:
                System.out.println("Opção inválida. Usando ataque por padrão.");
                atacar(alvo);
                break;
        }
    }

    public void curar() {
        System.out.println(nome + " usou a habilidade Curar, recuperando " + cura + " de vida.");
        vida += cura;
        if (vida > 90) {
            vida = 90;
        }
        System.out.println("Vida atual: " + vida);
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

    @Override
    public String toString() {
        return super.toString() +
                ", cura=" + cura;
    }
}
