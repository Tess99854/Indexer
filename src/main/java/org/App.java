package org;

import org.reader.FilesResolver;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";


    public static void main(String[] args) throws IOException {
        FilesResolver resolver = new FilesResolver();
        Scanner sc = new Scanner(System.in);
        System.out.println(ANSI_PURPLE + "Specify the indexed files or directories separated by space: " + ANSI_RESET);

        String[] paths = sc.nextLine().split(" ");
        ArrayList<File> files = new ArrayList<>();
        for (String path : paths) {
            files.addAll(resolver.open(path));
        }

        for (File file : files) {
            try {
                String docsContent = resolver.read(file);
                Indexer indexer = new Indexer(docsContent, file.getPath());
                indexer.generateIndex();

            } catch (IOException e) {
                System.out.println(file.getName() + " is missing");
            }
        }

        if (!Indexer.getIndex().isEmpty()) {
            System.out.println(ANSI_PURPLE + "Search for a word: " + ANSI_RESET);
            String term = sc.nextLine();

            System.out.println(Indexer.searchIndex(term).entrySet());

        }
    }
}
