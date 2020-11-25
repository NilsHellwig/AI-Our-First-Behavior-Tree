package zubereitung;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import com.badlogic.gdx.ai.btree.annotation.TaskAttribute;
import rezept.Rezept;
import zutat.Zutat;

public class Auskuehlen extends LeafTask {
    @TaskAttribute
    public String zutat;

    public Task.Status execute() {
        Rezept recipe = (Rezept)getObject();
        Zutat z;

        z = recipe.getIngredient(zutat);

        if (z != null) {
            System.out.println("Ich lasse " + z + " auskühlen");
            return Task.Status.SUCCEEDED;
        }
        else {
            System.out.println(z + " kommt im Rezept nicht vor.");
            return Task.Status.FAILED;
        }
    }

    protected Task copyTo(Task task) {
        return null;
    }
}
