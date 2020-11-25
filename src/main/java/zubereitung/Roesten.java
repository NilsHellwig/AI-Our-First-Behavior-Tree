package zubereitung;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import com.badlogic.gdx.ai.btree.annotation.TaskAttribute;
import rezept.Rezept;
import zutat.Zutat;

public class Roesten extends LeafTask {
    // Diesen Roesten Task nutzen wir in unserer .tree Datei!
    @TaskAttribute public String zutat;
    @TaskAttribute public String geraet;
    @TaskAttribute public Integer time;

    public Status execute() {
        Rezept recipe = (Rezept)getObject();
        Zutat z = recipe.getIngredient(zutat);

        if(time > 0){
            System.out.println("ich röste " + z + " in " + recipe.getTool(geraet));
            time--;
            return Status.RUNNING;
        }
        else {
            z.verbrauchen();
            z.verarbeiten("geroestet");

            return Status.SUCCEEDED;
        }
    }

    protected Task copyTo(Task task) {
        return null;
    }
}
