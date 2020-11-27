package zubereitung;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import com.badlogic.gdx.ai.btree.annotation.TaskAttribute;
import rezept.Rezept;
import zutat.Zutat;

import java.io.InputStreamReader;
import java.util.Scanner;

public class CheckWürzung extends LeafTask {
    @TaskAttribute public String geschmack;
    @TaskAttribute public String produkt;

    public Status execute() {
        Rezept recipe = (Rezept)getObject();
        Zutat z = recipe.getIngredient(produkt);
        if (z == null) {
            System.out.println(z + " kommt im Rezept nicht vor.");
            return Status.FAILED;
        }
        else {
            Scanner s = new Scanner(System.in);

            System.out.print("Ist das Produkt so "+geschmack+" genug?: (j/n): ");
            String input = s.nextLine();
            if (input.startsWith("j")) return Status.SUCCEEDED;
            else return Status.FAILED;
        }
    }

    protected Task copyTo(Task task) {
        return null;
    }
}
