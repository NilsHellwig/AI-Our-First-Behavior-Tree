package rezept;

import com.badlogic.gdx.ai.btree.BehaviorTree;
import com.badlogic.gdx.ai.btree.utils.BehaviorTreeParser;
import kuechengeraet.Kuechengeraet;
import zutat.Zutat;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Rezept {
    public HashMap<String, Kuechengeraet> geraete;
    public HashMap<String, Zutat> zutaten;

    private String name;
    private String tree_file_name;
    private BehaviorTree<Rezept> instructions;

    public Rezept(String n, String f) {
        tree_file_name = f;
        name = n;
    }

    public void init() throws FileNotFoundException {
        Reader reader = new FileReader(tree_file_name);
        BehaviorTreeParser<Rezept> parser = new BehaviorTreeParser<Rezept>(BehaviorTreeParser.DEBUG_HIGH);
        instructions = parser.parse(reader, this);

        zutaten = new HashMap<String, Zutat>();
        geraete = new HashMap<String, Kuechengeraet>();
    }

    public BehaviorTree<Rezept> getTree() throws FileNotFoundException {
        return instructions;
    }

    public void addIngredient(Zutat z) {
        zutaten.put(z.id(), z);
    }

    public Zutat getIngredient(String n) {
        return zutaten.get(n);
    }

    public Kuechengeraet getTool(String n) {
        return geraete.get(n);
    }

    public void addTool(Kuechengeraet k) {
        geraete.put(k.bezeichner(), k);
    }

    public void status() {
        Set<Map.Entry<String, Zutat>> ingrs = zutaten.entrySet();
        for (Map.Entry<String, Zutat> e : ingrs) {
            e.getValue().facts(false);
        }

        Set<Map.Entry<String, Kuechengeraet>> tools = geraete.entrySet();
        for (Map.Entry<String, Kuechengeraet> e : tools) {
            e.getValue().facts(false);
        }
    }

    public String name() {
        return name;
    }
}

