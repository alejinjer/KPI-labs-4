package com.company;


import org.junit.Assert;
import org.junit.Test;

public class MainTest {
    Main main = new Main();

    @Test
    public void test_average() throws AssertionError {
        String[] arr1 = {"a","ab","abc","abcd","abcde"};
        float average = main.getAverageLength.getAverageLength(arr1);
        float correctResult = 3;
        boolean result = (average == correctResult);
        Assert.assertEquals(result, true);
    }

    @Test
    public void testLess() {
        String[] arr = new String[] {"ae", "awqeb", "abc", "awfbcd", "abwefcde", "abcdef","a", "aeeb", "abc", "abcd"};
        String[] arr1 = main.getLessThanAverage.getLessThanAverage(arr);
        String[] arr2 = new String[] {"ae", "abc","a", "aeeb", "abc", "abcd"};
        Assert.assertArrayEquals(arr1, arr2);
    }

    @Test
    public void testMore() {
        String[] arr = new String[] {"ae", "awqeb", "abc", "awfbcd", "abwefcde", "abcdef","a", "aeeb", "abc", "abcd"};
        String[] arr1 = main.getMoreThanAverage.getMoreThanAvarage(arr);
        String[] arr2 = new String[] {"awqeb", "awfbcd", "abwefcde", "abcdef"};
        Assert.assertArrayEquals(arr1, arr2);
    }

}