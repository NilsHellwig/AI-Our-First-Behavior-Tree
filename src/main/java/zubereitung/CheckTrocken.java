package zubereitung;

import com.badlogic.gdx.ai.btree.LeafTask;
import com.badlogic.gdx.ai.btree.Task;
import com.badlogic.gdx.ai.btree.annotation.TaskAttribute;

public class CheckTrocken extends LeafTask {
    @TaskAttribute public String zutat;

    public Status execute() {
        // Hier haben wir einfach direkt SUCCEEDED zurückgegeben. Man könnte natürlich einen Timer
        // implementieren, sodass dieser Task erst nach einer gewissen Zeit erfolgreich ist.
        // Dies würde jedoch nur das schnelle Ausführen des Trees verhindern.
        if (zutat!=null){
            System.out.println(zutat + " ist nun trocken!");
            return Status.SUCCEEDED;
        } else {
            System.out.println("Es wurde keine Zutat übergeben");
            return Status.FAILED;
        }
    }

    protected Task copyTo(Task task) {
        return null;
    }
}
