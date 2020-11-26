package zubereitung;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import com.badlogic.gdx.ai.btree.annotation.TaskAttribute;
import kuechengeraet.Glas;
import kuechengeraet.Kuechengeraet;
import rezept.Rezept;
import zutat.Zutat;

import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

import static java.lang.Class.forName;

public class GlasZurSammlungHinzufügen extends LeafTask {

    public Status execute() {
        // Wenn bereits das Glas "glas" in der Liste ist, was der Fall ist,
        // sollte bereits ein Glas gefüllt worden sein.
        // Das befüllte Glas wird dann mit einer unique-Id zu der Liste der Geräte hinzugefügt.
        Rezept recipe = (Rezept)getObject();
        Glas glas;
        glas = (Glas) recipe.getTool("glas");
        if (glas!=null){
            Class<?> clazz = null;
            try {
                clazz = forName("kuechengeraet.Glas");
                Glas neuesVollesGlas = (Glas) clazz.getDeclaredConstructor().newInstance();
                String uniqueID = UUID.randomUUID().toString();
                neuesVollesGlas.setName("glas"+uniqueID);
                neuesVollesGlas.usedVolume = 300;
                recipe.addTool(neuesVollesGlas);
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
        }
        return Status.SUCCEEDED;
    }

    protected Task copyTo(Task task) {
        return null;
    }
}
