package zubereitung;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import com.badlogic.gdx.ai.btree.annotation.TaskAttribute;
import rezept.Rezept;
import zutat.Zutat;

public class Herausnehmen extends LeafTask {
    // Diesen Roesten Task nutzen wir in unserer .tree Datei!
    @TaskAttribute
    public String zutat;
    @TaskAttribute
    public String geraet;

    public Status execute() {
        Rezept recipe = (Rezept) getObject();
        Zutat z = recipe.getIngredient(zutat);

        System.out.println("ich nehme " + z + " aus " + recipe.getTool(geraet));

        return Status.SUCCEEDED;
    }

    protected Task copyTo(Task task) {
        return null;
    }
}