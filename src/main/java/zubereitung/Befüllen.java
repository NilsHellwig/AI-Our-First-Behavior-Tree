package zubereitung;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import com.badlogic.gdx.ai.btree.annotation.TaskAttribute;
import kuechengeraet.Glas;
import quantitaet.Gewicht;
import quantitaet.Quantitaet;
import rezept.Rezept;
import zutat.Zutat;

public class Befüllen extends LeafTask {
    @TaskAttribute public String produkt;
    @TaskAttribute public String glas;

    public Status execute() {
        Rezept recipe = (Rezept)getObject();
        Zutat z;
        Glas g;
        g = (Glas) recipe.getTool(glas);
        z = recipe.getIngredient(produkt);
        System.out.println("Befüllen: "+g.getUsedVolume());
        if (z != null && g != null) {
            g.addUsedVolume(10);
            Quantitaet q = new Gewicht(z.getQuantity().getQuantity()-10);
            z.setQuantity(q);
            if (z.getQuantity().getQuantity()==0){
                z.verbrauchen();
            }
            return Status.SUCCEEDED;
        }
        else {
            System.out.println(z +" oder "+ g +" kommt im Rezept nicht vor.");
            return Status.FAILED;
        }
    }

    protected Task copyTo(Task task) {
        return null;
    }
}
