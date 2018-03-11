package rtrk.pnrs.cats;

import rtrk.pnrs.food.Portion;

public class DomesticCat extends Cat {

    private final String ONOMATOPEIA = "meow";

    @Override
    public String say() {
        return ONOMATOPEIA;
    }

    @Override
    public void pet() {
        System.out.println("purr...");
    }

}

