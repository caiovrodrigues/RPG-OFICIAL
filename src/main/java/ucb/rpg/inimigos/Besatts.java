package ucb.rpg.inimigos;

import ucb.rpg.classes.util.Caracteristica;
import ucb.rpg.classes.util.Personagem;

public class Besatts extends Personagem {

    public Besatts() {
        super("Besatt's", Caracteristica.NENHUMA, Caracteristica.NENHUMA, 40, 30, 20, 0);
    }

    public void investidaSombria(Personagem alvo) {
        int dano = 15;
        System.out.println(getNome() + " avança com uma Investida Sombria contra " + alvo.getNome() + ", causando " + dano + " de dano.");
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

