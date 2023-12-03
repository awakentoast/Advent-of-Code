package test;

import main.StreamSolver1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamSolver1Test {
    StreamSolver1 streamSolver1 = new StreamSolver1();

    String[] streams = new String[8];

    @BeforeEach
    public void init() {
        streams[0] = "{}";
        streams[1] = "{{{}}}";
        streams[2] = "{{},{}}";
        streams[3] = "{{{},{},{{}}}}";
        streams[4] = "{<a>,<a>,<a>,<a>}";
        streams[5] = "{{<ab>},{<ab>},{<ab>},{<ab>}}";
        streams[6] = "{{<!!>},{<!!>},{<!!>},{<!!>}}";
        streams[7] = "{{<a!>},{<a!>},{<a!>},{<ab>}}";

    }

    @Test
    public void part1() {
        int result = 1;
        String stream = streams[0];
        assertEquals(result, streamSolver1.solve(stream));

        result = 6;
        stream = streams[1];
        assertEquals(result, streamSolver1.solve(stream));

        result = 5;
        stream = streams[2];
        assertEquals(result, streamSolver1.solve(stream));

        result = 16;
        stream = streams[3];
        assertEquals(result, streamSolver1.solve(stream));

        result = 1;
        stream = streams[4];
        assertEquals(result, streamSolver1.solve(stream));

        result = 9;
        stream = streams[5];
        assertEquals(result, streamSolver1.solve(stream));

        result = 9;
        stream = streams[6];
        assertEquals(result, streamSolver1.solve(stream));

        result = 3;
        stream = streams[7];
        assertEquals(result, streamSolver1.solve(stream));
    }

    @Test
    public void removeGarbage() {
        String result = "{}";
        String stream = streams[0];
        assertEquals(result, streamSolver1.cleanupString(stream));

        result = "{{{}}}";
        stream = streams[1];
        assertEquals(result, streamSolver1.cleanupString(stream));

        result = "{{},{}}";
        stream = streams[2];
        assertEquals(result, streamSolver1.cleanupString(stream));

        result = "{{{},{},{{}}}}";
        stream = streams[3];
        assertEquals(result, streamSolver1.cleanupString(stream));

        result = "{}";
        stream = streams[4];
        assertEquals(result, streamSolver1.cleanupString(stream));

        result = "{{},{},{},{}}";
        stream = streams[5];
        assertEquals(result, streamSolver1.cleanupString(stream));

        result = "{{},{},{},{}}";
        stream = streams[6];
        assertEquals(result, streamSolver1.cleanupString(stream));

        result = "{{}}";
        stream = streams[7];
        assertEquals(result, streamSolver1.cleanupString(stream));

        result = "{<!!!>}";
        stream = "{<!!!>}";
        assertEquals(result, streamSolver1.cleanupString(stream));

        result = "{}";
        stream = "{<!!!!>}";
        assertEquals(result, streamSolver1.cleanupString(stream));
    }

    @Test
    public void computeAnswer() {
        int result = 1;
        String stream = "{}";
        assertEquals(result, streamSolver1.computeValueOfStream(stream));

        result = 3;
        stream = "{{}}";
        assertEquals(result, streamSolver1.computeValueOfStream(stream));

        result = 5;
        stream = "{{},{}}";
        assertEquals(result, streamSolver1.computeValueOfStream(stream));

        result = 8;
        stream = "{{}, {{}}}";
        assertEquals(result, streamSolver1.computeValueOfStream(stream));
    }
}
