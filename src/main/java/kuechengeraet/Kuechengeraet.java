package kuechengeraet;

abstract public class Kuechengeraet {
    protected String bezeichnung;

    public Kuechengeraet() {
    }

    public void setName(String n) {
        bezeichnung = n;
    }

    public String bezeichner() {
        return bezeichnung;
    }

    public String toString() {
        return bezeichnung;
    }

    public void facts(boolean nlg) {
        if (nlg) System.out.println(bezeichnung + " ist " + this.getClass().getSimpleName());
        else System.out.println(this.getClass().getSimpleName() + "(" + bezeichnung + ")" );
    }
}
