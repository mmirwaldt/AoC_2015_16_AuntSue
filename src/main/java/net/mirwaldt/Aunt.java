package net.mirwaldt;

import java.util.LinkedHashMap;
import java.util.Map;

public class Aunt {
    private final int number;
    private final Map<AuntFeature, Integer> auntFeatures = new LinkedHashMap<>();

    public Aunt(int number) {
        this.number = number;
    }

    public void addAuntFeature(AuntFeature auntFeature, int count) {
        auntFeatures.put(auntFeature, count);
    }

    public boolean meetsProfileMFCSAM(Aunt auntProfile) {
        for (Map.Entry<AuntFeature, Integer> auntFeatureEntry : auntFeatures.entrySet()) {
            final AuntFeature auntFeature = auntFeatureEntry.getKey();
            final Integer count = auntFeatureEntry.getValue();
            if (!count.equals(auntProfile.auntFeatures.get(auntFeature))) {
                return false;
            }
        }
        return true;
    }

    public boolean meetsProfileRetroEncabulator(Aunt auntProfile) {
        for (Map.Entry<AuntFeature, Integer> auntFeatureEntry : auntFeatures.entrySet()) {
            final AuntFeature auntFeature = auntFeatureEntry.getKey();
            final Integer count = auntFeatureEntry.getValue();
            if(auntFeature.equals(AuntFeature.CATS)
                    || auntFeature.equals(AuntFeature.TREES)) {
                if(count <= auntProfile.auntFeatures.get(auntFeature)) {
                    return false;
                }
            } else if(auntFeature.equals(AuntFeature.POMERANIANS)
                    || auntFeature.equals(AuntFeature.GOLDFISH)) {
                if(count >= auntProfile.auntFeatures.get(auntFeature)) {
                    return false;
                }
            } else if (!count.equals(auntProfile.auntFeatures.get(auntFeature))) {
                return false;
            }
        }
        return true;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Aunt{" +
                "number=" + number +
                ", auntFeatures=" + auntFeatures +
                '}';
    }

    public String featuresToString() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<AuntFeature, Integer> auntFeatureEntry : auntFeatures.entrySet()) {
            result.append(auntFeatureEntry.getKey().name().toLowerCase())
                    .append(": ")
                    .append(auntFeatureEntry.getValue())
                    .append(", ");
        }
        return result.substring(0, result.length()-2);
    }
}
