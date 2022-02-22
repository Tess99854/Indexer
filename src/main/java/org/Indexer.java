package org;

import org.linguisticModule.Stemmer;
import org.tokenization.StopWordsManager;
import org.tokenization.TextTokenizer;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

public class Indexer {
    public static SortedMap<String, SortedMap<String, Integer>> terms = new TreeMap<>();
    private TextTokenizer tokenizer;
    private Stemmer stemmer = new Stemmer();
    private String content;
    private String path;


    public Indexer(String content, String path) throws FileNotFoundException {
        // todo: make another constructor for default language and manage exception
        this.content = content;
        this.path = path;
        StopWordsManager wordsManager = new StopWordsManager("en");
        tokenizer = new TextTokenizer(wordsManager);
    }

    public void generateIndex() throws FileNotFoundException {
        ArrayList<String> words = tokenizer.tokenize(content);
        words = stemmer.stemm(words);


        for (String word : words) {
            if (terms.containsKey(word)) {
                SortedMap<String, Integer> docs = terms.get(word);
                if (docs.containsKey(path)) {
                    terms.get(word).put(path, terms.get(word).get(path) + 1);
                } else {
                    terms.get(word).put(path, 1);
                }
            } else {
                SortedMap<String, Integer> docs = new TreeMap<>();
                docs.put(path, 1);
                terms.put(word, docs);
            }

        }
    }

    public static SortedMap getIndex() {
        return terms;
    }

    public static SortedMap searchIndex(String term) {
        return terms.get(term);
    }
}
