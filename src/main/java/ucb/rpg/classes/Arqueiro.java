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
        System.out.println("1. Tacar Machado");
        System.out.println("2. Stun");

        Scanner scanner = new Scanner(System.in);
        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                habilidade1(alvo);
                break;
            case 2:
                habilidade2(alvo);
                break;
            default:
                System.out.println("Opção inválida. Usando habilidade 1 por padrão.");
                habilidade1(alvo);
                break;
        }
    }

    @Override //ENCHE O RABO DE FLECHAS
    public void habilidade1(Personagem alvo) {
        if (flechas >= 1) {
            int dano = 15;
            System.out.println(getNome() + " usa Enche o Rabo de Flechas em " + alvo.getNome() + ", causando " + dano + " de dano.");
            alvo.receberDano(dano);
            flechas--;
            System.out.println(getNome() + " agora tem " + flechas + " flechas restantes.");
        } else {
            System.out.println("Flechas insuficientes para usar Enche o Rabo de Flechas. Atacando normalmente.");
            atacar(alvo);
        }
    }

    @Override //FLECHA POTENTE
    public void habilidade2(Personagem alvo) {
        int manaRequerida = 10;
        if (getMana() >= manaRequerida && flechas >= 1) {
            int dano = 30;
            System.out.println(getNome() + " usa Flecha Potente em " + alvo.getNome() + ", causando " + dano + " de dano.");
            alvo.receberDano(dano);
            gastarMana(manaRequerida);
            flechas--;
            System.out.println(getNome() + " agora tem " + flechas + " flechas restantes.");
        } else {
            if (getMana() < manaRequerida) {
                System.out.println("Mana insuficiente para usar Flecha Potente. Atacando normalmente.");
            } else {
                System.out.println("Flechas insuficientes para usar Flecha Potente. Atacando normalmente.");
            }
            atacar(alvo);
        }
    }

//    public void encheORaboDeFlechas(Personagem alvo) {
//        if (flechas >= 1) {
//            int dano = 15;
//            System.out.println(getNome() + " usa Enche o Rabo de Flechas em " + alvo.getNome() + ", causando " + dano + " de dano.");
//            alvo.receberDano(dano);
//            flechas--;
//            System.out.println(getNome() + " agora tem " + flechas + " flechas restantes.");
//        } else {
//            System.out.println("Flechas insuficientes para usar Enche o Rabo de Flechas. Atacando normalmente.");
//            atacar(alvo);
//        }
//    }
//
//    public void flechaPotente(Personagem alvo) {
//        int manaRequerida = 10;
//        if (getMana() >= manaRequerida && flechas >= 1) {
//            int dano = 30;
//            System.out.println(getNome() + " usa Flecha Potente em " + alvo.getNome() + ", causando " + dano + " de dano.");
//            alvo.receberDano(dano);
//            gastarMana(manaRequerida);
//            flechas--;
//            System.out.println(getNome() + " agora tem " + flechas + " flechas restantes.");
//        } else {
//            if (getMana() < manaRequerida) {
//                System.out.println("Mana insuficiente para usar Flecha Potente. Atacando normalmente.");
//            } else {
//                System.out.println("Flechas insuficientes para usar Flecha Potente. Atacando normalmente.");
//            }
//            atacar(alvo);
//        }
//    }

    public void atacar(Personagem alvo) {
        int dano = 10;
        System.out.println(getNome() + " ataca " + alvo.getNome() + ", causando " + dano + " de dano.");
        alvo.receberDano(dano);
    }




}
