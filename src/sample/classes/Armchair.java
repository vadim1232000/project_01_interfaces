package sample.classes;

public class Armchair implements IDoubleArea {

    private String name;
    private int firstArea;
    private int secondArea;

    public Armchair(String name, int firstArea, int secondArea){
        this.name = name;
        this.firstArea = firstArea;
        this.secondArea = secondArea;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getFirstArea() {
        return firstArea;
    }

    @Override
    public Integer getSecondArea() {
        return secondArea;
    }
}