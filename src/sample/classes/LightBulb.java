package sample.classes;

public class LightBulb implements ILight {

    private int lx;

    public LightBulb(int lx){
        this.lx = lx;
    }
    @Override
    public Integer getIx() {
        return lx;
    }
}