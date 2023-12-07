package main;

import java.util.*;

public class SeedSolverPart1 {

    long max = 0;
    public long solve(List<List<List<Long>>> maps) {
        long lowest = 999_999_999_999_999L;

        List<Long> seeds = maps.get(0).get(0);
        int count = 0;
        for (long seed : seeds) {
            System.out.println("Seed: " + seed + ", Count: " + count++);
            int theSameThreshold = calculateLowestAmountOfTheSame(seed, maps);
            List<Long> goodValues = getAllValuesWithTheSame(seed, maps, theSameThreshold);

            for (Long goodValue : goodValues) {
                if (goodValue < lowest) {
                    lowest = goodValue;
                }
            }
            System.out.println("Current lowest: " + lowest);
        }

        return lowest;
    }

    private List<Long> getAllValuesWithTheSame(long seed, List<List<List<Long>>> maps, int theSameThreshold) {
        System.out.println("starting getting all values that are less than " + theSameThreshold);
        List<List<Long>> seedToSoils = maps.get(1);
        List<List<Long>> soilToFerts = maps.get(2);
        List<List<Long>> fertToWaters = maps.get(3);
        List<List<Long>> waterToLights = maps.get(4);
        List<List<Long>> lightToTemps = maps.get(5);
        List<List<Long>> tempToHums = maps.get(6);
        List<List<Long>> humToLocs = maps.get(7);

        List<Long> allLocations = new LinkedList<>();

        for (List<Long> seedToSoil : seedToSoils) {
            for (List<Long> soilToFert : soilToFerts) {
                for (List<Long> fertToWater : fertToWaters) {
                    for (List<Long> waterToLight : waterToLights) {
                        for (List<Long> lightToTemp : lightToTemps) {
                            for (List<Long> tempToHum : tempToHums) {
                                for (List<Long> humToLoc : humToLocs) {
                                    int theSame = 0;
                                    long soil = getValueFromRange(seed, seedToSoil);
                                    if (isSame(seed, soil)) {
                                        theSame++;
                                    }
                                    long fert = getValueFromRange(soil, soilToFert);
                                    if (isSame(soil, fert)) {
                                        theSame++;
                                    }

                                    long water = getValueFromRange(fert, fertToWater);
                                    if (isSame(fert, water)) {
                                        theSame++;
                                    }

                                    long light = getValueFromRange(water, waterToLight);
                                    if (isSame(water, light)) {
                                        theSame++;
                                    }

                                    long temp = getValueFromRange(light, lightToTemp);
                                    if (isSame(light, temp)) {
                                        theSame++;
                                    }

                                    long hum = getValueFromRange(temp, tempToHum);
                                    if (isSame(temp, hum)) {
                                        theSame++;
                                    }

                                    long location = getValueFromRange(hum, humToLoc);
                                    if (isSame(hum, location)) {
                                        theSame++;
                                    }

                                    if (theSame == theSameThreshold) {
                                        allLocations.add(location);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return allLocations;
    }


    private int calculateLowestAmountOfTheSame(long seed, List<List<List<Long>>> maps) {
        System.out.println("starting with calculating the least amount of the same values is possible");
        List<List<Long>> seedToSoils = maps.get(1);
        List<List<Long>> soilToFerts = maps.get(2);
        List<List<Long>> fertToWaters = maps.get(3);
        List<List<Long>> waterToLights = maps.get(4);
        List<List<Long>> lightToTemps = maps.get(5);
        List<List<Long>> tempToHums = maps.get(6);
        List<List<Long>> humToLocs = maps.get(7);


        int leastTheSame = 99;
        for (List<Long> seedToSoil : seedToSoils) {
            for (List<Long> soilToFert : soilToFerts) {
                for (List<Long> fertToWater : fertToWaters) {
                    for (List<Long> waterToLight : waterToLights) {
                        for (List<Long> lightToTemp : lightToTemps) {
                            for (List<Long> tempToHum : tempToHums) {
                                for (List<Long> humToLoc : humToLocs) {
                                    int theSame = 0;
                                    long soil = getValueFromRange(seed, seedToSoil);
                                    if (isSame(seed, soil)) {
                                        theSame++;
                                    }
                                    long fert = getValueFromRange(soil, soilToFert);
                                    if (isSame(soil, fert)) {
                                        theSame++;
                                    }

                                    long water = getValueFromRange(fert, fertToWater);
                                    if (isSame(fert, water)) {
                                        theSame++;
                                    }

                                    long light = getValueFromRange(water, waterToLight);
                                    if (isSame(water, light)) {
                                        theSame++;
                                    }

                                    long temp = getValueFromRange(light, lightToTemp);
                                    if (isSame(light, temp)) {
                                        theSame++;
                                    }

                                    long hum = getValueFromRange(temp, tempToHum);
                                    if (isSame(temp, hum)) {
                                        theSame++;
                                    }

                                    long location = getValueFromRange(hum, humToLoc);
                                    if (isSame(hum, location)) {
                                        theSame++;
                                    }

                                    if (theSame < leastTheSame) {
                                        leastTheSame = theSame;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return leastTheSame;
    }

    public boolean isSame(long a, long b) {
        return a == b;
    }


    public long getValueFromRange(long value, List<Long> values) {
        long destinationStart = values.get(0);
        long sourceStart = values.get(1);
        long range = values.get(2);

        if (value >= sourceStart && value <= sourceStart + range) {
            return value + (destinationStart - sourceStart);
        }

        return value;
    }
}
