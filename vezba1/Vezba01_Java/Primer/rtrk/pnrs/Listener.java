package rtrk.pnrs;

import rtrk.pnrs.cats.Cat;
import rtrk.pnrs.food.EatListener;

public class Listener implements EatListener {

    @Override
    public void onEatingFinished(Cat animal) {
        animal.pet();
    }
}

