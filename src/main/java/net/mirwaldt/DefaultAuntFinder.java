package net.mirwaldt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefaultAuntFinder implements AuntFinder {
    private final List<Aunt> aunts = new ArrayList<>(50);

    @Override
    public void addAunt(Aunt aunt) {
        aunts.add(aunt);
    }

    @Override
    public int findAunt(Aunt auntProfile) {
        Aunt foundAunt = null;
        for (Aunt aunt : aunts) {
            if (aunt.meetsProfile(auntProfile)) {
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

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        for (Aunt aunt : aunts) {
            stringBuilder
                    .append("Sue ")
                    .append(aunt.getNumber())
                    .append(": ")
                    .append(aunt.featuresToString())
                    .append("\n");
        }
        return stringBuilder.toString();
    }
}
