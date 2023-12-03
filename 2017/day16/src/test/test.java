package test;

import main.Dance1;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class test {

    Dance1 dance1 = new Dance1();

    @Test
    public void test1() {
        char[] chars = {'a', 'b', 'c', 'd', 'e'};
        char[] result = {'e', 'a', 'b', 'c', 'd'};
        chars = dance1.performAction(new int[]{0,1,0}, chars);
        assertArrayEquals(chars, result);

        result = new char[]{'e', 'a', 'b', 'd', 'c'};
        chars = dance1.performAction(new int[]{1,3,4}, chars);
        assertArrayEquals(chars, result);

        result = new char[]{'b', 'a', 'e', 'd', 'c'};
        chars = dance1.performAction(new int[]{2,101,98}, chars);
        assertArrayEquals(chars, result);
    }
}
