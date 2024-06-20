package ucb.rpg.inimigos;

import ucb.rpg.classes.util.Caracteristica;
import ucb.rpg.classes.util.Personagem;

public abstract class Saqueador extends Personagem {

    public Saqueador() {
        super("Saqueador", Caracteristica.NENHUMA, Caracteristica.NENHUMA, 60, 50, 30, 40);
    }

    public void ataqueFurtivo(Personagem alvo) {
        int dano = 20;
        System.out.println(getNome() + " realiza um ataque furtivo em " + alvo.getNome() + ", causando " + dano + " de dano.");
        alvo.receberDano(dano);
    }
}
