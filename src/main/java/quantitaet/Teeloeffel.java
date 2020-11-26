package quantitaet;

public class Teeloeffel extends Quantitaet {
    public Teeloeffel() {
        super("EL", 0);
    }

    public Teeloeffel(double amount) {
        super("EL", amount);
    }

    public Teeloeffel(String name, double amount) {
        super(name, amount);
    }

    public String toString() {
        return name;
    }
}
