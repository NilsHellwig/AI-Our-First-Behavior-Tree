package zubereitung;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import com.badlogic.gdx.ai.btree.annotation.TaskAttribute;
import kuechengeraet.Glas;
import rezept.Rezept;
import zutat.Zutat;

public class Lagern extends LeafTask {
    @TaskAttribute public String produkt;
    @TaskAttribute public String art;

    public Status execute() {
        /* muss noch implementiert werden!*/
        Rezept recipe = (Rezept)getObject();
        for (String key : recipe.geraete.keySet()) {
            if (key.startsWith("glas")){
                Glas glas = (Glas)recipe.geraete.get(key);
                double usedVolume = glas.getUsedVolume();
                System.out.println("Wir lagern "+key+" bei "+art+". In dem Glas befinden sich "+usedVolume);
            }
        }

        return Status.SUCCEEDED;
    }

    protected Task copyTo(Task task) {
        return null;
    }
}
