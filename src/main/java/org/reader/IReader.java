package org.reader;

import java.io.File;
import java.io.IOException;

public interface IReader {
    public String read(File file) throws IOException;
}
