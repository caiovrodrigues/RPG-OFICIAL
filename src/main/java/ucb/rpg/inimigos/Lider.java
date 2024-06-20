package ucb.rpg.inimigos;

import ucb.rpg.classes.util.Caracteristica;
import ucb.rpg.classes.util.Personagem;

public abstract class Lider extends Personagem {

    public Lider() {
        super("Líder dos Bandidos", Caracteristica.NENHUMA, Caracteristica.NENHUMA, 80, 60, 50, 45);
    }

    public void comandoTatico(Personagem alvo) {
        int dano = 25; 
        System.out.println(getNome() + " ordena um ataque coordenado em " + alvo.getNome() + ", causando " + dano + " de dano.");
        alvo.receberDano(dano);
    }
}
