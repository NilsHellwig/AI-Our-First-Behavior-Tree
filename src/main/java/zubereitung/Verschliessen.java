package zubereitung;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import com.badlogic.gdx.ai.btree.annotation.TaskAttribute;
import kuechengeraet.Glas;
import kuechengeraet.Kuechengeraet;
import rezept.Rezept;
import zutat.Zutat;

public class Verschliessen extends LeafTask {
    @TaskAttribute public String geraet;

    public Status execute() {
        Rezept recipe = (Rezept)getObject();
        Glas glas = (Glas) recipe.getTool(geraet);
        glas.setMode(true);
        return Status.SUCCEEDED;
    }

    protected Task copyTo(Task task) {
        return null;
    }
}
