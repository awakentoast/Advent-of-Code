package main;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class SpreadsheetSolver {

    public int checksumPart1(List<List<Integer>> spreadsheet) {
        AtomicInteger result = new AtomicInteger();

        spreadsheet.forEach(row -> {
            Optional<Integer> max = row.stream().reduce(Integer::max);
            Optional<Integer> min = row.stream().reduce(Integer::min);
            result.addAndGet(max.get() - min.get());
        });

        return result.get();
    }

    public int checksumPart2(List<List<Integer>> spreadsheet) {
        AtomicInteger result = new AtomicInteger();

        spreadsheet.forEach(row -> {
            for (int i = 0; i < row.size(); i++) {
                for (int j = 0; j < row.size(); j++) {
                    if (i != j) {
                        int modResult = row.get(i) % row.get(j);
                        if (modResult == 0) {
                            result.addAndGet(row.get(i) / row.get(j));
                        }
                    }
                }
            }
        });

        return result.get();
    }

}
