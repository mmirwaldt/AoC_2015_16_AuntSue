package net.mirwaldt.aoc.year2015.day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public abstract class AbstractAuntFinder implements AuntFinder {
    protected final List<Aunt> aunts = new ArrayList<>(500);

    @Override
    public void addAunt(Aunt aunt) {
        aunts.add(aunt);
    }

    @Override
    public int findAunt(Aunt auntProfile) {
        Aunt foundAunt = null;
        for (Aunt auntCandidate : aunts) {
            if (meetsProfile(auntCandidate, auntProfile)) {
                if (foundAunt == null) {
                    foundAunt = auntCandidate;
                } else {
                    throw new IllegalArgumentException("Another aunt found. " + Arrays.asList(foundAunt, auntCandidate));
                }
            }
        }
        if (foundAunt == null) {
            return -1;
        } else {
            return foundAunt.getNumber();
        }
    }

    private boolean meetsProfile(Aunt auntCandidate, Aunt auntProfile) {
        for (Map.Entry<AuntFeature, Integer> auntFeatureEntry : auntCandidate.getAuntFeatures().entrySet()) {
            final AuntFeature auntFeature = auntFeatureEntry.getKey();
            final Integer actualCount = auntFeatureEntry.getValue();
            final Integer expectedCount = auntProfile.getAuntFeatures().get(auntFeature);
            if(isWrong(auntFeature, actualCount, expectedCount)) {
                return false;
            }
        }
        return true;
    }

    protected abstract boolean isWrong(AuntFeature auntFeature, Integer actualCount, Integer expectedCount);
}
