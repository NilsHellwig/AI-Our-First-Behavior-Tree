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

public class CheckTrocken extends LeafTask {
    @TaskAttribute public String zutat;

    public Status execute() {
        // Hier haben wir einfach direkt SUCCEEDED zurückgegeben. Man könnte natürlich einen Timer
        // implementieren, sodass dieser Task erst nach einer gewissen Zeit erfolgreich ist.
        // Dies würde jedoch nur das schnelle Ausführen des Trees verhindern.
        System.out.println(zutat + " ist nun trocken!");
        return Status.SUCCEEDED;
    }

    protected Task copyTo(Task task) {
        return null;
    }
}
