package ucb.rpg.mapas;

import ucb.rpg.classes.util.Personagem;

import java.util.List;
import java.util.Scanner;

public abstract class Mapa {
    protected final Scanner sc = new Scanner(System.in);
    protected static int escolha;

    private String nome;
    private List<String> vantagens;
    private List<String> desvantagens;
    protected Personagem jogador;

    public Mapa(String nome, Personagem jogador, List<String> vantagens, List<String> desvantagens) {
        this.nome = nome;
        this.jogador = jogador;
        this.vantagens = vantagens;
        this.desvantagens = desvantagens;
    }

    public String getNome() {
        return nome;
    }

    public List<String> getVantagens() {
        return vantagens;
    }

    public List<String> getDesvantagens() {
        return desvantagens;
    }

    public abstract void start();

    @Override
    public String toString() {
        return "Mapa{" +
                "nome='" + nome + '\'' +
                ", vantagens=" + vantagens +
                ", desvantagens=" + desvantagens +
                '}';
    }
}
