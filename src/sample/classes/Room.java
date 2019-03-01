package sample.classes;

import sample.exceptions.WrongIlluminanceException;
import sample.exceptions.WrongSpaceException;

import java.util.ArrayList;

public class Room {

    private static final int WND_ILLUMINANCE = 700;
    private static final int MAX_ILLUMINANCE = 4000;
    private static final int MAX_SPACE = 70;

    private String name;

    private int area;
    private int numberWidows;

    private ArrayList<ILight> listLightBulb;
    private ArrayList<IFurniture> listFurniture;

    public Room(String name, int area, int numberWidows) throws IllegalArgumentException {
        this.name = name;

        if (area > 0)
            this.area = area;
        else
            throw new IllegalArgumentException("Uncorrect value");
        if (numberWidows > 0)
            this.numberWidows = numberWidows;
        else
            throw new IllegalArgumentException("Uncorrect value");

        this.listLightBulb = new ArrayList<ILight>();
        this.listFurniture = new ArrayList<IFurniture>();
    }
    public String getName() {
        return name;
    }
    private int getIllumination(){
        int sum = WND_ILLUMINANCE * numberWidows;
        if(!listLightBulb.isEmpty())
            for (ILight bulb : listLightBulb)
                sum+=bulb.getIx();
        return sum;
    }
    private int getMinFilledArea(){
        int sum = 0;
        if(!listFurniture.isEmpty())
            for(IFurniture furniture : listFurniture)
                sum+=furniture.getFirstArea();
        return sum;
    }
    private int getMaxFilledArea(){
        int sum = 0;
        if(!listFurniture.isEmpty())
            for(IFurniture furniture : listFurniture)
                if(furniture instanceof IDoubleArea)
                    sum+=((IDoubleArea) furniture).getSecondArea();
        return sum;
    }
    public void add(ILight light) throws WrongIlluminanceException {

        if (getIllumination() + light.getIx() < MAX_ILLUMINANCE)
            listLightBulb.add(light);
        else
            throw new WrongIlluminanceException("Uncorrect value. Lighting limit exceeded");
    }

    public void add(IFurniture furniture) throws WrongSpaceException {

        if (100 * (this.getMaxFilledArea() + furniture.getFirstArea()) / this.area < MAX_SPACE)
            listFurniture.add(furniture);
        else
            throw new WrongSpaceException("Uncorrect value. Limit exceeded");
    }

    public void describe() {
        System.out.println("  " + name);
        System.out.print("    Lightning = " + this.getIllumination());
        if(numberWidows>0)
            System.out.print(" (" + numberWidows + " "
                    + (((numberWidows % 10 >=2)&&(numberWidows % 10 <=4))
                    ?("windows "):((numberWidows % 10 == 1)?("window "):("window ")))
                    + "each" + WND_ILLUMINANCE + " lx");
        if(!listLightBulb.isEmpty())
        {
            if(listLightBulb.size() == 1)
                System.out.print(", lightBulb ");
            else
                System.out.print(", lightBulb ");

            System.out.print(listLightBulb.get(0).getIx() + " lx");
            for (int i = 1; i<listLightBulb.size();i++)
                System.out.print(" and " + listLightBulb.get(i).getIx() + " lx");
        }
        System.out.println(")");

        System.out.print("    Area = " + this.area + " m^2 (");

        if(!listFurniture.isEmpty())
        {
            System.out.print("busy "+ this.getMinFilledArea());
            if(this.getMaxFilledArea() - this.getMinFilledArea()>0)
                System.out.print("-" + this.getMaxFilledArea());

            System.out.print(" m^2, guaranteed free " + (this.area - this.getMaxFilledArea()) + " m^2 or ");
            if (!listFurniture.isEmpty()){
                int x = 100*(this.area - this.getMaxFilledArea())/this.area;
                System.out.print(x);
            }
            else
                System.out.print("100");
            System.out.println("% area)");

            System.out.println("    Furniture:");
            for (IFurniture furniture : listFurniture)
                System.out.println("      " + furniture.getName() + " (area " + furniture.getFirstArea() + " m^2)");
        }
        else {
            System.out.println("free 100%)");
            System.out.println("    No furniture");
        }

    }


}

