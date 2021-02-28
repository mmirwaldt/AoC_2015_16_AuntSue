package net.mirwaldt;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractAuntFinder implements AuntFinder {
    protected final List<Aunt> aunts = new ArrayList<>(500);

    @Override
    public void addAunt(Aunt aunt) {
        aunts.add(aunt);
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
