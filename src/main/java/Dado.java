public class Dado {
    private int caras;

    public Dado() {
        this.caras = 6;
    }

    public int getCaras() {
        return caras;
    }

    public void setCaras(int caras) {
        this.caras = caras;
    }

    public int tirar() {
        return (int) (Math.random() * caras + 1);
    }
}
