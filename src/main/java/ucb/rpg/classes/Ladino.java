package ucb.rpg.classes;

import ucb.rpg.classes.util.Caracteristica;
import ucb.rpg.classes.util.Personagem;

import java.util.Scanner;

public class Ladino extends Personagem {
    private boolean invisivel;

    public Ladino() {
        super("Ladino", Caracteristica.DESTREZA, Caracteristica.FORCA, 80, 70, 50, 60);
        this.invisivel = false;
    }

    @Override
    public void mostrarHabilidades(Personagem alvo) {
        System.out.println("Escolha a habilidade a ser utilizada:");
        System.out.println("1. Tacar Faca");
        System.out.println("2. Ficar Invisível");

        Scanner scanner = new Scanner(System.in);
        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                tacarFaca(alvo);
                break;
            case 2:
                ficarInvisivel();
                break;
            default:
                System.out.println("Opção inválida. Usando tacar faca por padrão.");
                tacarFaca(alvo);
                break;
        }
    }

    public void tacarFaca(Personagem alvo) {
        int dano = 20;
        System.out.println(getNome() + " tacou uma faca em " + alvo.getNome() + " causando " + dano + " de dano.");
        alvo.receberDano(dano);
    }

    public void ficarInvisivel() {
        this.invisivel = true;
        this.forca += 20;
        System.out.println(getNome() + " ficou invisível, ganhando um buff de ataque e pulando o turno do adversário.");
    }

    public boolean SeInvisivel() {
        return invisivel;
    }

    public void InvisibilidadeAcabar() {
        if (invisivel) {
            this.invisivel = false;
            this.forca -= 20;
            System.out.println(getNome() + " não está mais invisível.");
        }
    }



    @Override
    public void habilidade1(Personagem alvo) {

    }

    @Override
    public void habilidade2(Personagem alvo) {

    }
}
