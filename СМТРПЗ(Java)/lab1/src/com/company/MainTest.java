package com.company;
import org.junit.Assert;
import org.junit.Test;

public class MainTest {
    @Test
    public void splitter_test_words() {
        String[] input = Main.splitter("Hello        World");
        String[] correctOutput = {"Hello", "World"};
        Assert.assertEquals(input, correctOutput);
    }

    @Test
    public void splitter_test_chars() {
        String[] input = Main.splitter("# : & 8 r");
        String[] correctOutput = {"#", ":", "&", "8", "r"};
        Assert.assertEquals(input, correctOutput);
    }

    @Test
    public void splitter_test_numbers() {
        String[] input = Main.splitter("-20 137 221.23");
        String[] correctOutput = {"-20", "137", "221.23"};
        Assert.assertEquals(input, correctOutput);
    }

    @Test
    public void splitter_test_spaces() {
        String[] input = Main.splitter("   ");
        String[] correctOutput = {};
        Assert.assertEquals(input, correctOutput);
    }

    @Test
    public void splitter_test_empty() {
        String[] input = Main.splitter("");
        String[] correctOutput = {""};
        Assert.assertEquals(input, correctOutput);
    }

    @Test
    public void countOfDifferentSymbols_test_spaces() {
        long input = Main.countOfDifferentSymbols("   ");
        long correctOutput = 1;
        Assert.assertEquals(input, correctOutput);
    }

    @Test
    public void countOfDifferentSymbols_test_latters() {
        long input = Main.countOfDifferentSymbols("qqwerr");
        long correctOutput = 4;
        Assert.assertEquals(input, correctOutput);
    }

    @Test
    public void countOfDifferentSymbols_test_symbols() {
        long input = Main.countOfDifferentSymbols("@@%***r###");
        long correctOutput = 5;
        Assert.assertEquals(input, correctOutput);
    }

    @Test
    public void countOfDifferentSymbols_test_register() {
        long input = Main.countOfDifferentSymbols("qqQQWwwW");
        long correctOutput = 4;
        Assert.assertEquals(input, correctOutput);
    }

    @Test
    public void countOfDifferentSymbols_test_sentence() {
        long input = Main.countOfDifferentSymbols("Java govno (C++ is better)");
        long correctOutput = 17;
        Assert.assertEquals(input, correctOutput);
    }

    @Test
    public void task5_test() {
        String[] input = Main.task5("Hello! My name is Sasha!");
        String[] correctOutput = {"My", "name", "is"};
        Assert.assertEquals(input, correctOutput);
    }
    
}