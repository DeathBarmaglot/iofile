package com.luxoft.iostream;

import java.io.IOException;

public class TestAnalyzer {
    public static void main(String[] args) throws IOException {
        String path = args[0];
        String word = args[1];

        FileAnalyzerNew instance = new FileAnalyzerNew();
        instance.analyze(path, word);

    }
}
