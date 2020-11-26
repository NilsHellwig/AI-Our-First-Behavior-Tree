package zubereitung;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import com.badlogic.gdx.ai.btree.annotation.TaskAttribute;
import kuechengeraet.Glas;
import kuechengeraet.Kuechengeraet;
import rezept.Rezept;
import zutat.Zutat;

import java.io.InputStreamReader;
import java.util.Scanner;

public class CheckIstVoll extends LeafTask {
    @TaskAttribute public String geraet;

    public Status execute() {
        Rezept recipe = (Rezept)getObject();
        Glas g;

        g = (Glas)recipe.getTool(geraet);

        if (g == null) {
            System.out.println(g + " kommt im Rezept nicht vor.");
            return Status.FAILED;
        }
        else {
            if (g.getUsedVolume()==300){
                return Status.SUCCEEDED;
            } else{
                return Status.FAILED;
            }
        }
    }

    protected Task copyTo(Task task) {
        return null;
    }
}
