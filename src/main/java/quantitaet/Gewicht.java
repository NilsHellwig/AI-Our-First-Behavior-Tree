package quantitaet;

public class Gewicht extends Quantitaet {
    public Gewicht() {
        super("gram", 0);
    }

    public Gewicht(double gram) {
        super("gram", gram);
    }

    public Gewicht(String name, double gewicht) {
        super(name, gewicht);
    }

    public String toString() {
        return name;
    }
}
