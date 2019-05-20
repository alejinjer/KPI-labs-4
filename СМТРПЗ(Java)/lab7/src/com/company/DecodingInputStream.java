package com.company;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DecodingInputStream extends FilterInputStream {

    protected DecodingInputStream(InputStream in) {
        super(in);
    }

    public int read() throws IOException {
        return super.read()/2;
    }
}
