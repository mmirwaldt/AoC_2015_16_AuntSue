package net.mirwaldt.aoc.year2015.day16;

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

    public Map<AuntFeature, Integer> getAuntFeatures() {
        return auntFeatures;
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
}
