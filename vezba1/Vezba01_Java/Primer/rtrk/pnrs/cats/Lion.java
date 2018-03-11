package rtrk.pnrs.cats;

import rtrk.pnrs.food.Portion;

public class Lion extends Cat {

    private static final String ONOMATOPEIA = "ROAR";

    @Override
    public String say() {
        return ONOMATOPEIA;
    }

    @Override
    public void pet() {
        super.pet();
        System.out.println("And eat you!!");
    }

}

