package zubereitung;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import com.badlogic.gdx.ai.btree.annotation.TaskAttribute;
import rezept.Rezept;
import zutat.Zutat;

public class Würzen extends LeafTask {
    @TaskAttribute public String produkt;
    @TaskAttribute public String zutat;

    public Task.Status execute() {
        Rezept recipe = (Rezept) getObject();
        Zutat p, z;

        p = recipe.getIngredient(produkt);
        z = recipe.getIngredient(zutat);

        if (p == null) {
            System.out.println(p + " kommt im Rezept nicht vor.");
            return Task.Status.FAILED;
        }
        else if (z == null) {
            System.out.println(z + " kommt im Rezept nicht vor.");
            return Task.Status.FAILED;
        } else {
            System.out.println("Ich würze " + p + " mit " + z);
            z.verbrauchen();
            return Status.SUCCEEDED;
        }
    }

    protected Task copyTo(Task task) {
        return null;
    }
}