package org.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FilesResolver implements IReader {
    private ArrayList<File> files = new ArrayList<>();

    public void open(String filePath) {
        File path = new File(filePath);

        if (path.isDirectory()) {
            // Get all files from the directory.
            File[] fList = path.listFiles();

            for (File file : fList) {
                if (file.isFile()) {
                    files.add(file);
                } else if (file.isDirectory()) {
                    open(file.getAbsolutePath());
                }
            }
        } else {
            files.add(path);
        }

    }

    public String read() throws IOException {
        StringBuilder content = new StringBuilder();
        String line;

        for (File file : files) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            reader.close();
        }


        return content.toString();
    }
}
