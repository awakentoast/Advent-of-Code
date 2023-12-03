package main;

public class Judge1 {
    public int solve(Generator generatorA, Generator generatorB) {
        int answer = 0;

        for (int i = 0; i < 40_000_000; i++) {
            generatorA.calculateNextValue();
            generatorB.calculateNextValue();
//            System.out.println(generatorA.value + " " + generatorB.value);
            if (compareLowest16Bits(generatorA, generatorB)) {
                answer++;
            }
        }

        return answer;
    }

    public boolean compareLowest16Bits(Generator generatorA, Generator generatorB) {
        String bitsA = Long.toBinaryString(generatorA.value);
        String bitsB = Long.toBinaryString(generatorB.value);

        if  (bitsA.length() < 16 || bitsB.length() < 16) {
            return false;
        }
        String subStringA = bitsA.substring(bitsA.length() - 16);
        String subStringB = bitsB.substring(bitsB.length() - 16);

        return subStringA.equals(subStringB);
    }
}
