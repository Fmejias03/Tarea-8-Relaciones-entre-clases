import java.util.Scanner;

public class JugadorGuerra {
    private int fichas;
    private Dado dado;
    private String nombre;

    public JugadorGuerra() {
        this.fichas = 10;
        this.dado = new Dado();
        this.nombre = "";
    }

    public int getFichas() {
        return fichas;
    }

    public void setFichas(int fichas) {
        this.fichas = fichas;
    }

    public Dado getDado() {
        return dado;
    }

    public void setDado(Dado dado) {
        this.dado = dado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int tirarDado() {
        return dado.tirar();
    }

    public void ganarFicha() {
        fichas++;
    }

    public void perderFicha() {
        fichas--;
    }
}
