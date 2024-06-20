package ucb.rpg.inimigos;


import ucb.rpg.classes.util.Caracteristica;
import ucb.rpg.classes.util.Personagem;

public class Mauricio extends Personagem {

    public Mauricio() {
        super("Mauricio", Caracteristica.NENHUMA, Caracteristica.NENHUMA, 100, 50, 30, 0);
    }

    public void golpeSombrio(Personagem alvo) {
        int manaRequerida = 20;
        if (getMana() >= manaRequerida) {
            int dano = 50;
            System.out.println(getNome() + " usa Golpe Sombrio em " + alvo.getNome() + ", causando " + dano + " de dano.");
            alvo.receberDano(dano);
            gastarMana(manaRequerida);
        } else {
            System.out.println(getNome() + " não tem mana suficiente para usar Golpe Sombrio.");
            atacar(alvo);
        }
    }

    public void rajadaDeSombras(Personagem alvo) {
        int manaRequerida = 30;
        if (getMana() >= manaRequerida) {
            int danoInicial = 30;
            int danoPorTurno = 10;
            int duracao = 3;

            System.out.println(getNome() + " usa Rajada de Sombras em " + alvo.getNome() + ", causando " + danoInicial + " de dano inicial e " + danoPorTurno + " de dano por turno durante " + duracao + " turnos.");
            alvo.receberDano(danoInicial);

            for (int i = 0; i < duracao; i++) {
                System.out.println("Rajada de Sombras continua causando " + danoPorTurno + " de dano em " + alvo.getNome() + ".");
                alvo.receberDano(danoPorTurno);
            }

            gastarMana(manaRequerida);
        } else {
            System.out.println(getNome() + " não tem mana suficiente para usar Rajada de Sombras.");
            atacar(alvo);
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

