package rtrk.pnrs;

import rtrk.pnrs.cats.Cat;
import rtrk.pnrs.cats.DomesticCat;
import rtrk.pnrs.cats.Lion;
import rtrk.pnrs.food.EatListener;
import rtrk.pnrs.food.Portion;

public class AnimalKingdom {

    public static void main(String[] args) {
        System.out.println("Hello from AnimalKingdom class!");

        Lion lion = new Lion();
        System.out.println("What the lion say? " + lion.say());
        lion.pet();

        Cat[] cats = {new Lion(), new DomesticCat()};
        for (int i = 0; i < cats.length; i++) {
            System.out.println("What this cat say? " + cats[i].say());
        }

        Portion foodPortion = new Portion();
        try {
            foodPortion.setFood(-10);
        } catch (IllegalArgumentException illegalArgumentException) {
            illegalArgumentException.printStackTrace();
        }

        for (Cat cat : cats) {
            try {
                foodPortion.setFood(10);
            } catch (IllegalArgumentException illegalArgumentException) {
                illegalArgumentException.printStackTrace();
            }

            cat.feed(foodPortion, new Listener());
        }
    }
}

