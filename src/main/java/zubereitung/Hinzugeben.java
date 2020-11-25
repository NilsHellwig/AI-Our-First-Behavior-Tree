package zubereitung;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import com.badlogic.gdx.ai.btree.annotation.TaskAttribute;
import rezept.Rezept;
import zutat.Zutat;

public class Hinzugeben extends LeafTask {
    // Diesen Roesten Task nutzen wir in unserer .tree Datei!
    @TaskAttribute
    public String zutat;
    @TaskAttribute
    public String geraet;

    public Status execute() {
        Rezept recipe = (Rezept) getObject();
        Zutat z = recipe.getIngredient(zutat);

        if (z != null) {
            System.out.println("ich gebe " + z + " in " + recipe.getTool(geraet));
            z.verbrauchen();
            return Status.SUCCEEDED;
        }
        else {
            System.out.println(z + " kommt im Rezept nicht vor.");
            return Status.FAILED;
        }
    }

    protected Task copyTo(Task task) {
        return null;
    }
}