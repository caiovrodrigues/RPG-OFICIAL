package ucb.rpg.classes;

import ucb.rpg.classes.util.Caracteristica;
import ucb.rpg.classes.util.Personagem;

import java.util.Scanner;

public class Barbaro extends Personagem {
    private boolean stun;

    public Barbaro() {
        super("Bárbaro", Caracteristica.FORCA, Caracteristica.INTELIGENCIA, 100, 80, 30, 70);
        this.stun = false;
    }

    @Override
    public void mostrarHabilidades(Personagem alvo) {
        System.out.println("Escolha a habilidade a ser utilizada:");
        System.out.println("1. Tacar Machado");
        System.out.println("2. Stun");

        Scanner scanner = new Scanner(System.in);
        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                tacarMachado(alvo);
                break;
            case 2:
                stun();
                break;
            default:
                System.out.println("Opção inválida. Usando Tacar Machado por padrão.");
                tacarMachado(alvo);
                break;
        }
    }

    public void tacarMachado(Personagem alvo) {
        int dano = 20;
        System.out.println(nome + " tacou um machado em " + alvo.getNome() + " causando " + dano + " de dano.");
        alvo.receberDano(dano);
    }

    public void stun() {
        this.stun = true;
        System.out.println(nome + " ganhou um turno adicional.");
    }

    @Override
    public void habilidade1(Personagem alvo) {

    }

    @Override
    public void habilidade2(Personagem alvo) {

    }



    public boolean isStun() {
        return stun;
    }

    public void resetStun() {
        this.stun = false;
    }


}
