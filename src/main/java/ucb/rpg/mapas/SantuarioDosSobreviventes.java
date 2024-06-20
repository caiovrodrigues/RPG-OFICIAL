package ucb.rpg.mapas;

import ucb.rpg.classes.util.Personagem;

import java.util.List;

public class SantuarioDosSobreviventes extends Mapa{
    public SantuarioDosSobreviventes(Personagem jogador) {
        super("Santuário dos Sobreviventes", jogador, List.of(), List.of());
    }

    @Override
    public void start() {

    }
}
