package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static ArrayList<String> readFromFile(File file) throws FileNotFoundException
    {
        ArrayList<String> tmpList = new ArrayList<String>();
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine())
            tmpList.add(sc.nextLine());
        return tmpList;
    }

    public static void writeToFile(File file, ArrayList<String> list) throws IOException {
        Comparator<String> comparator = (String o1, String o2) -> o1.length() - o2.length();
        FileWriter fileWriter = new FileWriter(file);
        list.sort(comparator);
        for (String s: list) {
            fileWriter.write(s);
            fileWriter.write("\n");
        }
        fileWriter.close();
    }

    public static void main(String[] args) throws IOException {
        ArrayList<String> list = readFromFile(new File("/Users/admin/Documents/KPI-labs-4/СМТРПЗ(Java)/lab5/input.txt"));
        writeToFile(new File("/Users/admin/Documents/KPI-labs-4/СМТРПЗ(Java)/lab5/output.txt"), list);
    }
}