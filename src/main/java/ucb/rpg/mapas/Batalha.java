package ucb.rpg.mapas;

import ucb.rpg.classes.util.Personagem;

import java.util.ArrayList;
import java.util.List;

public class Batalha {

    public static void batalhar(Personagem atacante, Personagem alvo){
        System.out.println();
        if(atacante.getVida() > 0 && alvo.getVida() > 0){

            if(isInimigo(atacante)){
//                System.out.println(atacante.getNome() + " é um inimigo e ele está atacando " + alvo.getNome());
                System.out.println(atacante.getNome() + " vida: " + atacante.getVida() + "; " + alvo.getNome() + " vida: " + alvo.getVida());
            }else{
//                System.out.println(atacante.getNome() + " é um aliado e ele está atacando " + alvo.getNome());
                System.out.println(atacante.getNome() + " vida: " + atacante.getVida() + "; " + alvo.getNome() + " vida: " + alvo.getVida());
                atacante.mostrarHabilidades(alvo);
            }
            alvo.setVida(alvo.getVida() - 40);
            try {
                Thread.sleep(3000);
                batalhar(alvo, atacante);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
//        }
//        atacante.mostrarHabilidades(alvo);
    }

    private static boolean isInimigo(Personagem atacante){
        List<String> nomesInimigos = new ArrayList<>(List.of("Besatt's", "Feiticeiro Sombrio", "Gðwnthër", "Líder dos Bandidos", "Saqueador"));
        return nomesInimigos.contains(atacante.getNome());
    }

}
