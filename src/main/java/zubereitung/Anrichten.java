package zubereitung;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import com.badlogic.gdx.ai.btree.annotation.TaskAttribute;
import kuechengeraet.Kuechengeraet;
import rezept.Rezept;
import zutat.Zutat;

import java.lang.reflect.InvocationTargetException;

import static java.lang.Class.forName;

public class Anrichten extends LeafTask {
    @TaskAttribute
    public String geraet;
    @TaskAttribute
    public String ergebnis;
    @TaskAttribute
    public String typ;
    @TaskAttribute
    public String zutat;

    public Status execute() {
        Rezept recipe = (Rezept) getObject();
        Kuechengeraet k;

        k = recipe.getTool(geraet);

        if (k != null) {
            System.out.println("Ich richte mit " + geraet+ " an");

            Class<?> ergebnisClass = null;
            try {
                ergebnisClass = forName("zutat.produkt." + typ);
                Zutat ergebnisIngredient = (Zutat)ergebnisClass.getDeclaredConstructor().newInstance();
                ergebnisIngredient.setName(ergebnis);
                recipe.addIngredient(ergebnisIngredient);
                Zutat zutatIngredient = recipe.getIngredient(zutat);
                zutatIngredient.verbrauchen();
                return Status.SUCCEEDED;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            return Status.FAILED;
        } else {
            System.out.println(k + " ist nicht verfügbar.");
            return Status.FAILED;
        }
    }

    protected Task copyTo(Task task) {
        return null;
    }
}