package main;

public class Judge2 {
    Judge1 judge1 = new Judge1();
    public int solve(Generator generatorA, Generator generatorB) {
        int compared = 0;
        int answer = 0;

        while (compared < 5_000_000) {
            generatorA.calculateNextValuePart2(4);
            generatorB.calculateNextValuePart2(8);
            //System.out.println(generatorA.value + " " + generatorB.value);

            if (judge1.compareLowest16Bits(generatorA, generatorB)) {
                answer++;
            }

            compared++;
        }

        return answer;
    }
}
