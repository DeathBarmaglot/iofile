package com.luxoft.iostream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

public class FileAnalyzer {
    public static void main(String... args) throws Exception {

        InputStream inputStream = new FileInputStream(args[0]);
        int letter;
        int count = 0;
        String word = args[1];
        String string = "";
        ArrayList<String> words = new ArrayList<String>();
        ArrayList<Integer> separate = new ArrayList<Integer>();
        ArrayList<Integer> duck = new ArrayList<Integer>();

        while ((letter = inputStream.read()) != -1) {

            if ((char) letter == 32) {
                words.add(string);
                if (string.equals(word)) {
                    duck.add(count);
                }
                count++;
                string = "";
            } else {
                string += (char) letter;
            }

            if ((char) letter == 46 || (char) letter == 63 || (char) letter == 33) {
                separate.add(count);
            }

        }

        inputStream.close();

        for (int j = 0; j < duck.size(); j++) {
        int min = 0;
        int max = 0;
        for (int i = 0; i < separate.size(); i++) {
            if (separate.get(i) > duck.get(j)) {
                min = (separate.get(i - 1))+1;
                max = (separate.get(i))+1;
                break;
            }
        }
        for (int i = min; i < max; i++) {
            System.out.print(words.get(i)+" ");
        }
        System.out.println();
}
    }


}




