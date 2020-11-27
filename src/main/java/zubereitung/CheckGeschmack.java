package zubereitung;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import com.badlogic.gdx.ai.btree.annotation.TaskAttribute;
import rezept.Rezept;
import zutat.Zutat;

import java.util.Scanner;

public class CheckGeschmack extends LeafTask {
    @TaskAttribute public String masse;

    public Status execute() {
        Rezept recipe = (Rezept)getObject();
        Zutat z;

        z = recipe.getIngredient(masse);

        if (z == null) {
            System.out.println(z + " kommt im Rezept nicht vor.");
            return Status.FAILED;
        }
        else {
            Scanner s = new Scanner(System.in);

            System.out.print("Schmeckt "+masse+" gut?: (j/n): ");
            String input = s.nextLine();
            if (input.startsWith("j")) return Status.SUCCEEDED;
            else return Status.FAILED;
        }
    }

    protected Task copyTo(Task task) {
        return null;
    }
}
