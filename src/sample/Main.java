package sample;

import sample.classes.Building;
import sample.classes.LightBulb;
import sample.classes.Desk;
import sample.classes.Armchair;
import sample.exceptions.WrongIlluminanceException;
import sample.exceptions.WrongSpaceException;

public class Main {

    public static void main(String[] args) throws WrongSpaceException, WrongIlluminanceException {
        Building building = new Building("Building 1");

        building.addRoom("Room 1", 100, 3);
        building.addRoom("Room 2", 30, 2);
        building.getRoom("Room 1").add(new LightBulb(150));
        building.getRoom("Room 1").add(new LightBulb(500));
        building.getRoom("Room 1").add(new Desk("Desk", 30));
        building.getRoom("Room 1").add(new Armchair("CHair", 2, 4));
   //     building.getRoom("Room 2").add(new LightBulb(600));
    //    building.getRoom("Room 2").add(new LightBulb(700))building.getRoom("Room 2").add(new Desk("Desk", 20));
//        building.getRoom("Room 2").add(new Armchair("CHair", 1, 2));

        building.describe();
    }
}