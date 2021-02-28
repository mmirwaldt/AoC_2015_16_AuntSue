package net.mirwaldt;

import java.util.Arrays;

public class RetroEncabulatorAuntFinder extends AbstractAuntFinder {
    @Override
    public int findAunt(Aunt auntProfile) {
        Aunt foundAunt = null;
        for (Aunt aunt : aunts) {
            if (aunt.meetsProfileRetroEncabulator(auntProfile)) {
                if (foundAunt == null) {
                    foundAunt = aunt;
                } else {
                    throw new IllegalArgumentException("Another aunt found. " + Arrays.asList(foundAunt, aunt));
                }
            }
        }
        if (foundAunt == null) {
            return -1;
        } else {
            return foundAunt.getNumber();
        }
    }
}
