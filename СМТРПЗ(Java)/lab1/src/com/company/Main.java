package com.company;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static String[] splitter(String str)
    {
        return str.split("\\s+");
    }

    public static long countOfDifferentSymbols(String str)
    {
        return str.chars().distinct().count();
    }

    public static String[] task5(String str)
    {
        String[] splitted =  splitter(str);
        List<String> list = new ArrayList<String>();
        for(String s: splitted) {
            if(countOfDifferentSymbols(s) == s.length())
            {
                list.add(s);
            }
        }
        String[] result = list.toArray(new String[0]);
        return result;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System. in);
        String input = scanner. nextLine();
        String[] str = task5(input);
        for(String s: str)
        {
            System.out.println(s);
        }
    }
}