package com.company;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class EncodingOutputStream extends FilterOutputStream {

    public EncodingOutputStream(OutputStream out) {
        super(out);
    }

    public void write(int b) throws IOException {
        super.write(b * 2);
    }
}
