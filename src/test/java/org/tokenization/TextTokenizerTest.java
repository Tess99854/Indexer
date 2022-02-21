package org.tokenization;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;

public class TextTokenizerTest extends TestCase {

    public void testTokenize() {
    }

    public void testNormalise() {
        ArrayList<String> testList = new ArrayList<>(Arrays.asList("Word", "WORD", "wOrD"));
        ArrayList<String> resultList = new ArrayList<>(Arrays.asList("word", "word", "word"));
        StopWordsManager manager = new StopWordsManager();
        TextTokenizer tokenizer = new TextTokenizer(manager);

        ArrayList<String> result = tokenizer.normalise(testList);
        assertEquals(result, resultList);

    }

    public void testCleanUp() {
    }
}