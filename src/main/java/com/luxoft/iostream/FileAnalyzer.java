package com.luxoft.iostream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

public class FileAnalyzer {
    public static void main(String... args) throws Exception {

        InputStream is = new FileInputStream(args[0]);
        int c;
        int count = 0;
        String d = args[1];
        String str = "";
        ArrayList<String> words = new ArrayList<String>();
        ArrayList<Integer> separate = new ArrayList<Integer>();
        ArrayList<Integer> duck = new ArrayList<Integer>();
        while ((c = is.read()) != -1) {

            if ((char) c == 32) {
                words.add(str);
                if (str.equals(d)) {
                    duck.add(count);
                }
                count++;
                str = "";
            } else {
                str += (char) c;
            }

            if ((char) c == 46 || (char) c == 63 || (char) c == 33) {
                separate.add(count);
            }

        }

        is.close();

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




