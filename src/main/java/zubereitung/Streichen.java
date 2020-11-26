package zubereitung;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import com.badlogic.gdx.ai.btree.annotation.TaskAttribute;
import rezept.Rezept;
import zutat.Zutat;

public class Streichen extends LeafTask {
    @TaskAttribute
    public String produkt;
    @TaskAttribute
    public String art;

    public Status execute() {
        Rezept recipe = (Rezept)getObject();
        Zutat z;

        z = recipe.getIngredient(produkt);

        if (z != null) {
            System.out.println("Ich streiche " + z + " "+art);
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

