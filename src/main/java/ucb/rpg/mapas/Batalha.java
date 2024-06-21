package ucb.rpg.mapas;

import jdk.swing.interop.SwingInterOpUtils;
import ucb.rpg.Imagens.ImagemMauricio;
import ucb.rpg.classes.util.Personagem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Batalha {

    private static String[] falasInimigo = {
            "Finalmente, alguém ousado o suficiente para enfrentar-me. Prepare-se para o seu fim!",
            "Nem doeu. Seu esforço é inútil! Eu sou invencível!",
            "Você chama isso de ataque? Já vi crianças fazerem melhor.",
            "Você parece cansado. Quer uma pausa? Talvez um chá?",
            "Estou quase sentindo pena de você. Quase.",
            "HAHAHAHA, Isso é o que chamam de herói hoje em dia??",
            "HAHAHAHA, Não se fazem mais heróis como antigamente"
    };

    public static void batalhar(Personagem atacante, Personagem alvo){
        System.out.println();
        if(atacante.getVida() > 0){
            if(isInimigo(atacante)){
                System.out.println(atacante.getNome() + " vida: " + atacante.getVida() + "; " + alvo.getNome() + " vida: " + alvo.getVida());
                atacante.mostrarHabilidades(alvo);
            }else{
                System.out.println(atacante.getNome() + " vida: " + atacante.getVida() + "; " + alvo.getNome() + " vida: " + alvo.getVida());
                atacante.mostrarHabilidades(alvo);
                System.out.println();
                if(!(alvo.getVida() <= 0)){
                    System.out.println(alvo.getNome() + ": '" + falasInimigo[new Random().nextInt(0, falasInimigo.length - 1)] + "'");
                }else{
                    System.out.println(alvo.getNome() + ": '" + "Isso... isso não é possível. Eu sou... eu sou o mais forte. Naaaaaaaaaaaaãoo....." + "'\n");
                }

            }

            if(alvo.getVida() <= 0 && isInimigo(alvo)){
                System.out.printf("""
                        %s em um golpe magistral acaba derrotando %s
                        Parabéns, você acaba de ganhar do maior dos ladrões.
                        
                        %s agora está morto e a cidade volta a viver em paz.
                        
                        """, atacante.getNome(), alvo.getNome(), alvo.getNome());
                try {
                    Thread.sleep(5000);
                    ImagemMauricio.exibirImagem();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            if(alvo.getVida() <= 0 && !isInimigo(alvo)){
                System.out.printf("""
                        %s dá um golpe magistral em %s e acaba te derrotando!
                        Derrota, você acaba de perder a batalha final para o maior dos ladrões.
                        
                        %s agora está morto e a cidade continua em trevas.
                        
                        """, atacante.getNome(), alvo.getNome(), alvo.getNome());
                try {
                    Thread.sleep(5000);
                    ImagemMauricio.exibirImagem();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            try {
                Thread.sleep(3000);
                batalhar(alvo, atacante);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static boolean isInimigo(Personagem atacante){
        List<String> nomesInimigos = new ArrayList<>(List.of("Besatt's", "Mauricio", "Feiticeiro Sombrio", "Gðwnthër", "Líder dos Bandidos", "Saqueador"));
        return nomesInimigos.contains(atacante.getNome());
    }

}
