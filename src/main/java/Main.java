import com.badlogic.gdx.ai.btree.BehaviorTree;
import com.badlogic.gdx.ai.btree.Task;
import kuechengeraet.Pfanne;
import quantitaet.Essloeffel;
import rezept.Rezept;
import zutat.Pinienkern;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String [] args) throws FileNotFoundException {
        Rezept myR;
        String[] rezepte = new String[3];
        rezepte[0] = "BärlauchLemonPesto";
        rezepte[1] = "NektarinenMozerellaSalat";
        rezepte[2] = "ZucchiniBasilikumPesto";
        myR = new Rezept("Pesto", "data/"+rezepte[1]+".tree");

        BehaviorTree<Rezept> r;

        myR.init();

        r = myR.getTree();

        System.out.println("Situation vor Kochen");
        myR.status();

        do {
            r.step();
            System.out.println("tree hat Status: " + r.getStatus());
        }
        while (r.getStatus() == Task.Status.RUNNING);

        System.out.println("Situation nach Kochen");
        myR.status();
    }
}