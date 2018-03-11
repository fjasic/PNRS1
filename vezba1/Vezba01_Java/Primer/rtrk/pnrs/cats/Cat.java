package rtrk.pnrs.cats;

import rtrk.pnrs.food.EatListener;
import rtrk.pnrs.food.Portion;

public abstract class Cat {

    public void pet() {
        System.out.println("Watch out, this cat might scratch you!");
    }

    public abstract String say();

    public void feed(Portion foodPortion, EatListener callback) {
        foodPortion.setFood(0);
        callback.onEatingFinished(this);
    }
}
