package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        FileOutputStream outStream = new FileOutputStream("test.txt");
        EncodingOutputStream outFilter = new EncodingOutputStream(outStream);

        FileInputStream inStream = new FileInputStream("test.txt");
        DecodingInputStream inFilter = new DecodingInputStream(inStream);

        byte[] buffer = {65, 66, 67, 68, 69};
        int i;

        outFilter.write(buffer);
        outFilter.flush();

        while((i = inFilter.read()) > 0) {
            char c = (char)i;
            System.out.println("Character read: "+c);
        }
    }
}