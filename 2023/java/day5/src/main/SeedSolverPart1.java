package main;

import java.util.*;

public class SeedSolverPart1 {

    public long solve(List<List<List<Long>>> maps) {
        long lowestAnswer = 999_999_999_999_999L;

        List<Long> seeds = maps.get(0).get(0);
        int count = 0;
        for (long seed : seeds) {
            System.out.println("Seed: " + seed + ", Count: " + count++);
            int theSameThreshold = calculateLowestAmountOfTheSame(seed, maps);
            System.out.println(theSameThreshold);
            long lowestValidLocation = getLowestLocationForThreshold(seed, maps, theSameThreshold);
            System.out.println(lowestValidLocation);
            System.out.println();
            if (lowestValidLocation < lowestAnswer) {
                lowestAnswer = lowestValidLocation;
            }
        }

        return lowestAnswer;
    }

    private long getLowestLocationForThreshold(long seed, List<List<List<Long>>> maps, int theSameThreshold) {
        System.out.println("starting getting all values that are less than " + theSameThreshold);
        List<List<Long>> seedToSoils = maps.get(1);
        List<List<Long>> soilToFerts = maps.get(2);
        List<List<Long>> fertToWaters = maps.get(3);
        List<List<Long>> waterToLights = maps.get(4);
        List<List<Long>> lightToTemps = maps.get(5);
        List<List<Long>> tempToHums = maps.get(6);
        List<List<Long>> humToLocs = maps.get(7);

        long soil;
        long fert;
        long water;
        long light;
        long temp;
        long hum;
        long location;

        int soilTheSame;
        int fertTheSame;
        int waterTheSame;
        int lightTheSame;
        int tempTheSame;
        int humTheSame;
        int locationTheSame;

        long lowestValidLocation = 9_999_999_999L;

        for (List<Long> seedToSoil : seedToSoils) {
            soil = getValueFromRange(seed, seedToSoil);
            soilTheSame = seed == soil ? 1 : 0;

            for (List<Long> soilToFert : soilToFerts) {
                fert = getValueFromRange(soil, soilToFert);
                fertTheSame = soil == fert ? 1 : 0;
                fertTheSame += soilTheSame;

                for (List<Long> fertToWater : fertToWaters) {
                    water = getValueFromRange(fert, fertToWater);
                    waterTheSame = fert == water ? 1 : 0;
                    waterTheSame += fertTheSame;

                    for (List<Long> waterToLight : waterToLights) {
                        light = getValueFromRange(water, waterToLight);
                        lightTheSame = water == light ? 1 : 0;
                        lightTheSame += waterTheSame;

                        for (List<Long> lightToTemp : lightToTemps) {
                            temp = getValueFromRange(light, lightToTemp);
                            tempTheSame = light == temp ? 1 : 0;
                            tempTheSame += lightTheSame;

                            for (List<Long> tempToHum : tempToHums) {
                                hum = getValueFromRange(temp, tempToHum);
                                humTheSame = temp == hum ? 1 : 0;
                                humTheSame += tempTheSame;

                                for (List<Long> humToLoc : humToLocs) {
                                    location = getValueFromRange(hum, humToLoc);
                                    locationTheSame = hum == location ? 1 : 0;
                                    locationTheSame += humTheSame;

                                    if (locationTheSame == theSameThreshold) {
                                        if (location < lowestValidLocation) {
                                            lowestValidLocation = location;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return lowestValidLocation;
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


        long soil;
        long fert;
        long water;
        long light;
        long temp;
        long hum;
        long location;

        int soilTheSame;
        int fertTheSame;
        int waterTheSame;
        int lightTheSame;
        int tempTheSame;
        int humTheSame;
        int locationTheSame;

        int leastTheSame = 99;

        for (List<Long> seedToSoil : seedToSoils) {
            soil = getValueFromRange(seed, seedToSoil);
            soilTheSame = seed == soil ? 1 : 0;

            for (List<Long> soilToFert : soilToFerts) {
                fert = getValueFromRange(soil, soilToFert);
                fertTheSame = soil == fert ? 1 : 0;
                fertTheSame += soilTheSame;

                for (List<Long> fertToWater : fertToWaters) {
                    water = getValueFromRange(fert, fertToWater);
                    waterTheSame = fert == water ? 1 : 0;
                    waterTheSame += fertTheSame;

                    for (List<Long> waterToLight : waterToLights) {
                        light = getValueFromRange(water, waterToLight);
                        lightTheSame = water == light ? 1 : 0;
                        lightTheSame += waterTheSame;

                        for (List<Long> lightToTemp : lightToTemps) {
                            temp = getValueFromRange(light, lightToTemp);
                            tempTheSame = light == temp ? 1 : 0;
                            tempTheSame += lightTheSame;

                            for (List<Long> tempToHum : tempToHums) {
                                hum = getValueFromRange(temp, tempToHum);
                                humTheSame = temp == hum ? 1 : 0;
                                humTheSame += tempTheSame;

                                for (List<Long> humToLoc : humToLocs) {
                                    location = getValueFromRange(hum, humToLoc);
                                    locationTheSame = hum == location ? 1 : 0;
                                    locationTheSame += humTheSame;

                                    if (locationTheSame <= leastTheSame) {
                                        leastTheSame = locationTheSame;
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


    public long getValueFromRange(long value, List<Long> values) {
        long sourceStart = values.get(1);
        if (value >= sourceStart && value <= sourceStart + values.get(2)) {
            return value + (values.get(0) - sourceStart);
        }
        return value;
    }
}
