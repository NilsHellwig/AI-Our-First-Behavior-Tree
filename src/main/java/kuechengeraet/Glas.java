package kuechengeraet;

public class Glas extends Kuechengeraet {
    public boolean verschlossen;
    public double usedVolume;
    public static double VOLUME = 300.0; // 300 g
    public Glas() {
        bezeichnung = "Glas";
        verschlossen = false;
        usedVolume = 0;
    }
    public void setMode(boolean verschlossen) {
        this.verschlossen = verschlossen;
    }
    public double getUsedVolume(){
        return this.usedVolume;
    }
    public void addUsedVolume(double amount){
        this.usedVolume += amount;
    }
    public boolean getMode(){
        return this.verschlossen;
    }
}
