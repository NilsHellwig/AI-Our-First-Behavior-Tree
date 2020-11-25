package zutat;

public class Basilikum extends Zutat {
    public Basilikum() {
        super();
    }

    public void verbrauchen() {
        transformation.put("verbraucht", Boolean.TRUE);
    }

    public void verarbeiten(String methode) {
        if (transformation.containsKey(methode)) {
            System.out.println(methode + "schon angewendet auf " + name);
        }
        else transformation.put(methode, Boolean.TRUE);
    }

    public String toString() {
        return id();
    }
}