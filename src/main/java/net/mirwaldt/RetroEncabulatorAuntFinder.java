package net.mirwaldt;

public class RetroEncabulatorAuntFinder extends AbstractAuntFinder {
    @Override
    protected boolean isWrong(AuntFeature auntFeature, Integer actualCount, Integer expectedCount) {
        if(auntFeature.equals(AuntFeature.CATS)
                || auntFeature.equals(AuntFeature.TREES)) {
            return actualCount <= expectedCount;
        } else if(auntFeature.equals(AuntFeature.POMERANIANS)
                || auntFeature.equals(AuntFeature.GOLDFISH)) {
            return actualCount >= expectedCount;
        } else {
            return !actualCount.equals(expectedCount);
        }
    }
}
