package net.mirwaldt.aoc.year2015.day16;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static net.mirwaldt.aoc.year2015.day16.AuntFeature.*;

public class AuntFinderMain {
    public static void main(String[] args) throws IOException {
        final List<String> lines = Files.readAllLines(Path.of("input.txt"), StandardCharsets.US_ASCII);
        final Aunt auntProfile = createAuntProfile();

        final AuntFinder auntFinder = new MFCSAM_AuntFinder();
        addAunts(lines, auntFinder);
        System.out.println(auntFinder.findAunt(auntProfile)); // result: 103


        final AuntFinder partTwoAuntFinder = new RetroEncabulatorAuntFinder();
        addAunts(lines, partTwoAuntFinder);
        System.out.println(partTwoAuntFinder.findAunt(auntProfile)); // result: 405
    }

    private static Aunt createAuntProfile() {
        final Aunt auntProfile = new Aunt(0);
        auntProfile.addAuntFeature(CHILDREN, 3);
        auntProfile.addAuntFeature(CATS, 7);
        auntProfile.addAuntFeature(SAMOYEDS, 2);
        auntProfile.addAuntFeature(POMERANIANS, 3);
        auntProfile.addAuntFeature(AKITAS, 0);
        auntProfile.addAuntFeature(VIZSLAS, 0);
        auntProfile.addAuntFeature(GOLDFISH, 5);
        auntProfile.addAuntFeature(TREES, 3);
        auntProfile.addAuntFeature(CARS, 2);
        auntProfile.addAuntFeature(PERFUMES, 1);
        return auntProfile;
    }

    private static void addAunts(List<String> lines, AuntFinder auntFinder) {
        int auntCounter = 1;
        for (String line : lines) {
            final String[] tokens = line.split(" ");
            final Aunt aunt = new Aunt(auntCounter);

            final String firstAuntFeature = tokens[2].replace(":", "").toUpperCase();
            final int firstAuntFeatureValue = Integer.parseInt(tokens[3].replace(",",""));
            aunt.addAuntFeature(AuntFeature.valueOf(firstAuntFeature), firstAuntFeatureValue);

            final String secondAuntFeature = tokens[4].replace(":", "").toUpperCase();
            final int secondAuntFeatureValue = Integer.parseInt(tokens[5].replace(",",""));
            aunt.addAuntFeature(AuntFeature.valueOf(secondAuntFeature), secondAuntFeatureValue);

            final String thirdAuntFeature = tokens[6].replace(":", "").toUpperCase();
            final int thirdAuntFeatureValue = Integer.parseInt(tokens[7]);
            aunt.addAuntFeature(AuntFeature.valueOf(thirdAuntFeature), thirdAuntFeatureValue);

            auntFinder.addAunt(aunt);
            auntCounter++;
        }
    }
}
