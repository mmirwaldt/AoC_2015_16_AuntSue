package net.mirwaldt;

import java.util.Arrays;

public class MFCSAM_AuntFinder extends AbstractAuntFinder {
    @Override
    public int findAunt(Aunt auntProfile) {
        Aunt foundAunt = null;
        for (Aunt aunt : aunts) {
            if (aunt.meetsProfileMFCSAM(auntProfile)) {
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
