package org.tokenization;

import junit.framework.TestCase;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class StopWordsManagerTest extends TestCase {

    public void testGetStopWords() throws FileNotFoundException {
        StopWordsManager manager = new StopWordsManager();

        manager.getStopWords();
    }

    public void testExtendList() throws FileNotFoundException {
        StopWordsManager manager = new StopWordsManager();

        manager.extendList(new ArrayList<String>(Arrays.asList("no", "and")));
    }
}