package zutat;

import quantitaet.Quantitaet;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

abstract public class Zutat {
    protected String name;
    protected boolean verbraucht;
    protected Quantitaet quant;
    protected HashMap<String,Boolean> transformation;


    public Zutat() {
        transformation = new HashMap<String, Boolean>();
        transformation.put("verbraucht", Boolean.FALSE);
    }

    public void setName(String n) {
        name = n;
    }

    public void setQuantity(Quantitaet q) {
        quant = q;
    }

    public String id() {
        return name;
    }

    abstract public void verbrauchen();

    abstract public void verarbeiten(String methode);

    public boolean istVerbraucht() {
        return transformation.get("verbraucht");
    }

    public void facts(boolean nlg) {
        if (nlg) System.out.println(name + " ist " + this.getClass().getSimpleName());
        else System.out.println(this.getClass().getSimpleName() + "(" + name + ")");

        if (quant != null) {
            if (nlg) System.out.println(name + " hat Menge " + quant);
            else System.out.println("hatMenge(" + name + "," + quant + ")");
            quant.facts(nlg);
        }

        Set<Map.Entry<String, Boolean>> entries = transformation.entrySet();
        for(Map.Entry<String, Boolean> entry : entries) {
            if (entry.getValue() == Boolean.TRUE) {
                if (nlg) System.out.println(name + " ist " + entry.getKey());
                else System.out.println(entry.getKey() + "(" + name + ")");
            }
            else {
                if (nlg) System.out.println(name + " ist nicht " + entry.getKey());
                else System.out.println("not " + entry.getKey() + "(" + name + ")");
            }
        }
    }

    public boolean verarbeitet(String methode) {
        if (transformation.containsKey(methode))
            return transformation.get(methode).booleanValue();
        else
            return false;
    }
}
