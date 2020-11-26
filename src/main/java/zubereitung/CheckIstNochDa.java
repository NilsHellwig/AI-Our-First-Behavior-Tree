package zubereitung;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import com.badlogic.gdx.ai.btree.annotation.TaskAttribute;
import rezept.Rezept;
import zutat.Zutat;

public class CheckIstNochDa extends LeafTask {
    @TaskAttribute public String zutat;

    public Status execute() {
        Rezept recipe = (Rezept)getObject();
        Zutat z;

        z = recipe.getIngredient(zutat);
        System.out.println("check wie viel noch da: "+z.getQuantity().getQuantity());
        if (z != null) {
            if (z.getQuantity().getQuantity() > 0) {
                return Status.SUCCEEDED;
            } else {
                return Status.FAILED;
            }
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
