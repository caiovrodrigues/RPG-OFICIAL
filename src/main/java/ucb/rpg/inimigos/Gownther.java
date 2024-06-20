package ucb.rpg.inimigos;

import ucb.rpg.classes.util.Caracteristica;
import ucb.rpg.classes.util.Personagem;

public class Gownther extends Personagem {
    private boolean aumentoAtaqueProximoTurno = false;

    public Gownther() {
        super("Gðwnthër", Caracteristica.NENHUMA, Caracteristica.NENHUMA, 120, 80, 50, 0);
    }

    public void chamaInfernal(Personagem alvo) {
        int manaRequerida = 30;
        if (getMana() >= manaRequerida) {
            int danoInicial = 20;
            int danoPorTurno = 10;
            int duracaoChama = 3;

            System.out.println(getNome() + " invoca Chamas Infernais em " + alvo.getNome() + ", causando " + danoInicial + " de dano inicial e " + danoPorTurno + " de dano por turno durante " + duracaoChama + " turnos.");
            alvo.receberDano(danoInicial);

            for (int i = 0; i < duracaoChama; i++) {
                System.out.println("Chamas Infernais queimam " + alvo.getNome() + ", causando " + danoPorTurno + " de dano.");
                alvo.receberDano(danoPorTurno);
            }

            gastarMana(manaRequerida);
        } else {
            atacar(alvo);
        }
    }

    public void furiaDemoniaca() {
        System.out.println(getNome() + " entra em Fúria Demoníaca, aumentando o dano do próximo ataque!");
        aumentoAtaqueProximoTurno = true;
    }

    public void atacar(Personagem alvo) {
        int dano = 10;
        if (aumentoAtaqueProximoTurno) {
            dano += 5; 
            aumentoAtaqueProximoTurno = false;
        }
        System.out.println(getNome() + " ataca " + alvo.getNome() + ", causando " + dano + " de dano.");
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
