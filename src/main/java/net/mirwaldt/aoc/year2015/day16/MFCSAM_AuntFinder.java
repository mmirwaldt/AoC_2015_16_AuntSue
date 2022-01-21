package net.mirwaldt.aoc.year2015.day16;

public class MFCSAM_AuntFinder extends AbstractAuntFinder {
    @Override
    protected boolean isWrong(AuntFeature auntFeature, Integer actualCount, Integer expectedCount) {
         return !actualCount.equals(expectedCount);
    }
}
