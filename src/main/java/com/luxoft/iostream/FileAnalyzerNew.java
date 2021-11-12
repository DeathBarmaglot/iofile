package com.luxoft.iostream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class FileAnalyzerNew {
    public void analyze(String path, String word) throws IOException {

        String content = readContent(path);

        List<String> sentences = splitIntoSentences(content);

        List<String> filteredSentences = filter(sentences, word);

        int count = countWord(filteredSentences);
        printSentencesWithWord(filteredSentences);
        printCount(count);
    }

    private void printCount(int count) {
        System.out.println(count);
    }

    private void printSentencesWithWord(List<String> filteredSentences) {
        for (int i = 0; i < filteredSentences.size(); i++) {
            System.out.println(filteredSentences.get(i));

        }
    }


    private int countWord(List<String> filteredSentences) {
        return filteredSentences.size();
    }

    private List<String> filter(List<String> sentences, String word) {
        ArrayList arrayList = new ArrayList();
        sentences.stream().map(sentence -> (sentence.split(" "))).forEach(array -> IntStream.range(0, array.length).filter(j -> array[j].equals(word)).mapToObj(j -> Arrays.toString(array)).forEach(arrayList::add));
        return arrayList;

    }

    private List<String> splitIntoSentences(String content) {
        return Arrays.asList(content.split("\n"));
    }

    private String readContent(String path) throws IOException {
        InputStream inputStream = new FileInputStream(path);
        String result = "";
        int letter;
        while ((letter = inputStream.read()) != -1) {
            result += (char) letter;

        }
        inputStream.close();
        return result;
    }
}
