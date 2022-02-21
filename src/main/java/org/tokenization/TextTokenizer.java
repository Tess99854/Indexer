package org.tokenization;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class TextTokenizer {
    StopWordsManager stopWordsManager;

    public TextTokenizer(StopWordsManager wordsManager) {
        stopWordsManager = wordsManager;
    }

    public ArrayList<String> tokenize(String sentence) throws FileNotFoundException {
        ArrayList<String> tokens = new ArrayList<String>(Arrays.asList(sentence.split("[\\s\\t\\n,()?!.]+")));

        tokens = normalise(tokens);
        tokens = cleanUp(tokens);

        return tokens;
    }

    public ArrayList<String> normalise(ArrayList<String> tokens) {
        return (ArrayList<String>) tokens.stream().map(String::toLowerCase).collect(Collectors.toList());
    }

    public ArrayList<String> cleanUp(ArrayList<String> tokens) throws FileNotFoundException {
        // remove the words existing in the stopList
        tokens.removeAll(stopWordsManager.getStopWords());
        return tokens;
    }
}
