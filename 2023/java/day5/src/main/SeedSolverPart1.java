package main;

import java.util.*;

public class SeedSolverPart1 {

    public long solve(long[][][] maps) {
        long lowestAnswer = 999_999_999_999_999L;

        long[] seeds = maps[0][0];int count = 0;
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

    private long getLowestLocationForThreshold(long seed, long[][][] maps, int theSameThreshold) {
        System.out.println("starting getting all values that are less than " + theSameThreshold);
        long[][] seedToSoils = maps[1];
        long[][] soilToFerts = maps[2];
        long[][] fertToWaters = maps[3];
        long[][] waterToLights = maps[4];
        long[][] lightToTemps = maps[5];
        long[][] tempToHums = maps[6];
        long[][] humToLocs = maps[7];

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

        for (long[] seedToSoil : seedToSoils) {
            soil = getValueFromRange(seed, seedToSoil);
            soilTheSame = seed == soil ? 1 : 0;

            for (long[] soilToFert : soilToFerts) {
                fert = getValueFromRange(soil, soilToFert);
                fertTheSame = soil == fert ? 1 : 0;
                fertTheSame += soilTheSame;

                for (long[] fertToWater : fertToWaters) {
                    water = getValueFromRange(fert, fertToWater);
                    waterTheSame = fert == water ? 1 : 0;
                    waterTheSame += fertTheSame;

                    for (long[] waterToLight : waterToLights) {
                        light = getValueFromRange(water, waterToLight);
                        lightTheSame = water == light ? 1 : 0;
                        lightTheSame += waterTheSame;

                        for (long[] lightToTemp : lightToTemps) {
                            temp = getValueFromRange(light, lightToTemp);
                            tempTheSame = light == temp ? 1 : 0;
                            tempTheSame += lightTheSame;

                            for (long[] tempToHum : tempToHums) {
                                hum = getValueFromRange(temp, tempToHum);
                                humTheSame = temp == hum ? 1 : 0;
                                humTheSame += tempTheSame;

                                for (long[] humToLoc : humToLocs) {
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


    private int calculateLowestAmountOfTheSame(long seed, long[][][] maps) {
        System.out.println("starting with calculating the least amount of the same values is possible");
        long[][] seedToSoils = maps[1];
        long[][] soilToFerts = maps[2];
        long[][] fertToWaters = maps[3];
        long[][] waterToLights = maps[4];
        long[][] lightToTemps = maps[5];
        long[][] tempToHums = maps[6];
        long[][] humToLocs = maps[7];

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

        for (long[] seedToSoil : seedToSoils) {
            soil = getValueFromRange(seed, seedToSoil);
            soilTheSame = seed == soil ? 1 : 0;

            for (long[] soilToFert : soilToFerts) {
                fert = getValueFromRange(soil, soilToFert);
                fertTheSame = soil == fert ? 1 : 0;
                fertTheSame += soilTheSame;

                for (long[] fertToWater : fertToWaters) {
                    water = getValueFromRange(fert, fertToWater);
                    waterTheSame = fert == water ? 1 : 0;
                    waterTheSame += fertTheSame;

                    for (long[] waterToLight : waterToLights) {
                        light = getValueFromRange(water, waterToLight);
                        lightTheSame = water == light ? 1 : 0;
                        lightTheSame += waterTheSame;

                        for (long[] lightToTemp : lightToTemps) {
                            temp = getValueFromRange(light, lightToTemp);
                            tempTheSame = light == temp ? 1 : 0;
                            tempTheSame += lightTheSame;

                            for (long[] tempToHum : tempToHums) {
                                hum = getValueFromRange(temp, tempToHum);
                                humTheSame = temp == hum ? 1 : 0;
                                humTheSame += tempTheSame;

                                for (long[] humToLoc : humToLocs) {
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


    public long getValueFromRange(long value, long[] values) {
        long sourceStart = values[1];
        if (value >= sourceStart && value <= sourceStart + values[2]) {
            return value + (values[0] - sourceStart);
        }
        return value;
    }
}
