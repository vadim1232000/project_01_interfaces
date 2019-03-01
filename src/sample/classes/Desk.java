package sample.classes;

public class Desk implements IFurniture {

    private String name;
    private int area;

    public Desk(String name, int area){
        this.name = name;
        this.area = area;
    }
    @Override
    public Integer getFirstArea() {
        return area;
    }

    @Override
    public String getName() {
        return name;
    }
}
